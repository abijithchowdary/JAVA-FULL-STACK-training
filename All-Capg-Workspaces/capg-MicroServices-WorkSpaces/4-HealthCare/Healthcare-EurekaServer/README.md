# Eureka Server – Setup and Usage Guide

## Overview

Eureka Server acts as a **Service Registry** in a microservices architecture.

All microservices such as **Patient Service, Doctor Service, Appointment Service and API Gateway** register themselves with Eureka so that they can discover and communicate with each other.

---

# Steps to Create Eureka Server

## 1. Create Spring Boot Project

Create a **Spring Boot Starter Project** with the following dependency:

- Eureka Server

---

## 2. Enable Eureka Server

Open the main application class and annotate it with `@EnableEurekaServer`.

Example:

```java
@SpringBootApplication
@EnableEurekaServer
public class HealthcareEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthcareEurekaServerApplication.class, args);
    }

}
```

---

## 3. Add `application.yml`

Place the `application.yml` file inside:

```
src/main/resources
```

Example configuration:

```yaml
spring:
  application:
    name: EUREKA-SERVER

server:
  port: 8761

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
```

Explanation:

- `register-with-eureka: false`  
  Since this is the **Eureka Server**, it should not register itself.

- `fetch-registry: false`  
  The server does not need to fetch registry information.

---

## 4. Optional Configuration

If the values from `application.yml` are not picked correctly, you can also add them in:

```
application.properties
```

Example:

```
spring.application.name=EUREKA-SERVER
server.port=8761
```

---

## 5. Run the Eureka Server

Run the application.

Once started, open the following URL in the browser:

```
http://localhost:8761
```

You should see the **Eureka Dashboard**.

---

## 6. Register Microservices

Keep the **Eureka Server running** and start other microservices such as:

- API Gateway
- Patient Service
- Doctor Service
- Appointment Service

All these services will **automatically register themselves** in the Eureka Server.

---

# Verify Registration

Open:

```
http://localhost:8761
```

Under **Instances currently registered with Eureka**, you will see the registered microservices.

Example:

- API-GATEWAY
- PATIENT-SERVICE
- DOCTOR-SERVICE
- APPOINTMENT-SERVICE

---

# Architecture Overview

Client → API Gateway → Eureka Server → Microservices

Eureka helps services **discover each other dynamically** without hardcoding service URLs.