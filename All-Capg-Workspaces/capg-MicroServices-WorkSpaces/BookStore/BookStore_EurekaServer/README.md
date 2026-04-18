# BookStore Eureka Server

## Overview
The **BookStore Eureka Server** is the **Service Discovery** component of the BookStore microservices architecture. It acts as a registry where all other microservices (`book-service`, `order-service`, `api-gateway`) register themselves, allowing them to discover and communicate with each other by name rather than hard-coded URLs.

## Technology Stack
| Technology | Version |
|---|---|
| Java | 21 |
| Spring Boot | 4.0.3 |
| Spring Cloud | 2025.1.0 |
| Spring Cloud Netflix Eureka Server | 2025.1.0 |
| Build Tool | Gradle |

## Port
| Service | Port |
|---|---|
| Eureka Server | **8761** |

## Project Structure
```
BookStore_EurekaServer/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/bookstore/
│       │       └── BookStoreEurekaServerApplication.java
│       └── resources/
│           ├── application.properties
│           └── application.yml
├── build.gradle
└── README.md
```

## Configuration

### `application.properties`
```properties
spring.application.name=BookStore-EurekaServer
server.port=8761

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
eureka.server.wait-time-in-ms-when-sync-empty=0
```

### Key Configuration Details
- `eureka.client.register-with-eureka=false` — Prevents the server from registering with itself.
- `eureka.client.fetch-registry=false` — Prevents the server from fetching its own registry.
- `eureka.server.wait-time-in-ms-when-sync-empty=0` — Reduces startup delay when no peers exist.

## How to Run

### Prerequisites
- Java 21 installed
- Gradle installed (or use the included `gradlew` wrapper)

### Steps
1. Open a terminal in the project root directory.
2. Run the application:
   ```bash
   ./gradlew bootRun
   ```
   Or on Windows:
   ```cmd
   gradlew.bat bootRun
   ```
3. The Eureka Dashboard will be available at: [http://localhost:8761](http://localhost:8761)

> ⚠️ **Start this service FIRST** before starting any other BookStore microservice.

## Eureka Dashboard
Once running, navigate to [http://localhost:8761](http://localhost:8761) to view:
- Registered services and their instances
- Service health status
- Instance metadata

## Startup Order
```
1. BookStore-EurekaServer  (port 8761)  ← Start First
2. BookStore-BookService   (port 8081)
3. BookStore-OrderService  (port 8082)
4. BookStore-API-Gateway   (port 8090)
```

## Troubleshooting
| Problem | Solution |
|---|---|
| Port 8761 already in use | Change `server.port` in `application.properties` |
| Services not registering | Ensure `eureka.client.service-url.defaultZone` in client services points to `http://localhost:8761/eureka` |
| Dashboard shows no instances | Wait ~30 seconds after client services start for heartbeat registration |
