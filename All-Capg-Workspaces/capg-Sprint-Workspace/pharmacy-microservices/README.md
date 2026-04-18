# Pharmacy Microservices Monitoring (Actuator + Prometheus + Grafana)

## Overview
This project demonstrates a **simple APM-style monitoring setup** for your existing Java 17 Spring Boot microservices using:

- **Spring Boot Actuator** (operational endpoints like health + metrics)
- **Micrometer** (collects metrics inside Spring Boot)
- **Prometheus** (scrapes metrics and stores them)
- **Grafana** (visualizes metrics in dashboards)

### What is monitored (demo-ready)
- **HTTP request count** (from Spring Boot / Micrometer)
- **Request latency** (calculated as average duration from Micrometer HTTP metrics)
- **JVM memory usage** (heap usage)
- **CPU usage** (system CPU usage)
- Optional: **API call counter** routed through the gateway (`pharmacy_api_calls_total`)

## Features Implemented
### 1) Spring Boot Actuator + Micrometer Prometheus
Each service now includes:
- `spring-boot-starter-actuator`
- `micrometer-registry-prometheus`

And each service’s `application.yml` exposes:
- `GET /actuator/health`
- `GET /actuator/metrics`
- `GET /actuator/prometheus`

### 2) Prometheus setup
`prometheus/prometheus.yml` is configured to scrape:
- `gateway-service`
- all other microservices (Auth/Catalog/Order/Admin/Payment/Notification)

It scrapes `/actuator/prometheus` every **15 seconds**.

### 3) Grafana setup
Grafana is added via Docker Compose and uses the default login:
- `admin / admin`

## Step-by-Step Setup (Local)

### Step 1: Start everything with Docker Compose
From the project root (`pharmacy-microservices`), run:

```powershell
docker compose up --build
```

This starts:
- MySQL
- RabbitMQ
- Eureka
- All microservices + API Gateway
- **Prometheus**
- **Grafana**

### Step 1.1 (optional but recommended): Confirm containers are up

```powershell
docker compose ps
```

You should see containers for `gateway-service`, your microservices, `prometheus`, and `grafana` in a running state.

### Step 1.2 (optional): Build the Java modules locally (outside Docker)
If you want to compile everything locally first:

```powershell
mvn -DskipTests package
```

### Step 2: Verify Actuator is working
Open one service’s Prometheus endpoint in your browser.

Examples:
- API Gateway Actuator Prometheus:
  - `http://localhost:8888/actuator/prometheus`
- Order Service Actuator Prometheus:
  - `http://localhost:9093/actuator/prometheus`

You should see Prometheus-formatted text output (metrics).

### Step 3: Open Prometheus UI
Go to:
- `http://localhost:9090`

Then check targets:
- `Status` -> `Targets`

You should see scrape status for:
- `gateway-service`
- `auth-service`
- `catalog-service`
- `order-service`
- `admin-service`
- `payment-service`
- `notification-service`

If you don’t see them:
- confirm the service container is running
- check the service’s `GET /actuator/prometheus` works (Step 2)

### Step 4: Open Grafana UI
Go to:
- `http://localhost:3000`

Login:
- Username: `admin`
- Password: `admin`

### Step 5: Connect Grafana to Prometheus
In Grafana:
1. Go to **Connections** (or **Data sources**) -> **Add data source**
2. Select **Prometheus**
3. Set the URL to:
   - `http://prometheus:9090`
4. Click **Save & test**

Note: `prometheus` is the Docker Compose service name (it works from inside the Grafana container).

## How to View Metrics

### Option A (quick check): Prometheus directly
In Prometheus UI, use the “Expression” box to test queries like:
- `http_server_requests_seconds_count`
- `jvm_memory_used_bytes`
- `system_cpu_usage`

### Option B: Grafana dashboard panels
In Grafana:
1. Click **Dashboards** -> **New dashboard**
2. Add panels one by one using the queries below
3. Save the dashboard (name it e.g. `Pharmacy APM Demo`)

## Basic APM Dashboard (Beginner)
Create **4 panels** (plus 1 optional custom panel).

### Panel 1: HTTP Request Count
Use this query:
```promql
rate(http_server_requests_seconds_count[1m])
```

Tip: You can add filters like:
```promql
rate(http_server_requests_seconds_count{job="gateway-service"}[1m])
```

### Panel 2: Request Latency (Average)
Use this query (simple average latency):
```promql
rate(http_server_requests_seconds_sum[1m])
/
rate(http_server_requests_seconds_count[1m])
```

This gives average latency in **seconds**.

### Panel 3: JVM Memory Usage (Heap)
Use this query:
```promql
jvm_memory_used_bytes{area="heap"}
```

### Panel 4: CPU Usage
Use this query:
```promql
system_cpu_usage
```

### Optional Panel 5: Custom “API Calls” Counter
If you generated traffic through the gateway (`/api/...`), you can visualize:
```promql
rate(pharmacy_api_calls_total[1m])
```

## Sample Queries (Important)
The following PromQL metric names are the ones you’ll use in Grafana:

- `http_server_requests_seconds_count`
- `jvm_memory_used_bytes`
- `system_cpu_usage`

Suggested latency calculation:
- `rate(http_server_requests_seconds_sum[1m]) / rate(http_server_requests_seconds_count[1m])`

## Interview Explanation (Quick + Clear)

### What is Prometheus?
Prometheus is a **metrics monitoring system**. It:
- periodically **scrapes** metrics from endpoints
- stores them in a time-series database
- lets you query them with **PromQL**

### What is Grafana?
Grafana is a **visualization tool**. It:
- reads metrics from Prometheus
- lets you build dashboards/panels
- is great for “APM-like” monitoring demos

### What is Micrometer?
Micrometer is the **metrics instrumentation library** used by Spring Boot. It:
- collects application/system metrics
- exports them in formats Prometheus can scrape (via registry)

### How Spring Boot integrates with Prometheus
With:
- `spring-boot-starter-actuator`
- `micrometer-registry-prometheus`

Spring Boot automatically exposes:
- `GET /actuator/prometheus`

Prometheus then scrapes that endpoint and Grafana visualizes it.

## Actuator Endpoint Explanations
- `GET /actuator/health`
  - returns service health status (up/down)
- `GET /actuator/metrics`
  - shows available metric names and values (Micrometer metrics)
- `GET /actuator/prometheus`
  - returns metrics in the Prometheus scrape format (`text/plain`)

## Troubleshooting

### Prometheus “targets” show down
1. Confirm the microservice container is running.
2. Test the endpoint from your host:
   - `http://localhost:<service-port>/actuator/prometheus`
3. If the endpoint is blocked by security:
   - Actuator should be allowed at `/actuator/**` for services that require auth (done in code).

### Grafana data source test fails
Try using:
- `http://prometheus:9090` (correct for Docker network)

### No metrics in Grafana
1. Wait for Prometheus to scrape (15 seconds interval).
2. Refresh Grafana panel.
3. Check Prometheus UI query for the metric name.

### Docker Compose won’t start / builds take long
Run again with:
```powershell
docker compose up --build
```

If you changed code and want a clean rebuild, you can stop containers first and run the command again.

---

## Run and test the new features (Email + Async Event, Graceful Shutdown)

### Email feature setup (SMTP)
- **Update** `auth-service/src/main/resources/application.yml`:
  - **`spring.mail.username`**: e.g. `your_email@gmail.com`
  - **`spring.mail.password`**: e.g. `your_app_password_here`
- **Gmail users (recommended)**:
  - Enable 2‑Step Verification
  - Create a **Gmail App Password**
  - Use that App Password as `spring.mail.password`

### Start the service (without Docker)
From the project root (`pharmacy-microservices`), run:

```powershell
mvn -pl auth-service spring-boot:run
```

Auth service should start on **`http://localhost:9091`**.

### Trigger user registration (Signup API)
- **Endpoint**: `POST /api/auth/signup`
- **URL**: `http://localhost:9091/api/auth/signup`
- **Example request body**:

```json
{
  "name": "Demo User",
  "email": "demo.user@example.com",
  "password": "password123",
  "roles": ["CUSTOMER"]
}
```

### Verify the welcome email was sent
- **API response**: `201 Created` with body `User registered successfully`
- **Auth service log** should contain:
  - `Welcome email sent to demo.user@example.com`

If SMTP is not configured correctly, you may see:
- `Failed to send welcome email to ...`

### Test graceful shutdown (@PreDestroy)
- Stop the app:
  - In the terminal running Spring Boot: press **Ctrl + C**
  - Or stop the run from your IDE
- **Expected logs** (from `@PreDestroy` in `AuthService`):
  - `Service is shutting down gracefully...`
  - `Cleanup completed for AuthService.`

