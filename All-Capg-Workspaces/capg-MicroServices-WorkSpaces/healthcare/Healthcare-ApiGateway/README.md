# API Gateway – Setup and Usage Guide

## Overview

API Gateway acts as the **single entry point** for all client requests in the Healthcare microservices architecture.

Instead of calling individual services directly, the client sends requests to the **API Gateway**, which then routes them to the appropriate microservice.

The gateway communicates with **Eureka Server** to discover services dynamically.

---

# Steps to Create API Gateway

## 1. Create Spring Boot Project

Create a **Spring Boot Starter Project** with the following dependencies:

- Spring Cloud Gateway
- Eureka Discovery Client

---

## 2. Configure `application.yml`

Place the `application.yml` file inside:

```
src/main/resources
```

Example configuration:

```yaml
spring:
  application:
    name: API-GATEWAY

server:
  port: 8989

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/

spring:
  cloud:
    gateway:
      routes:
        - id: patient-service
          uri: lb://PATIENT-SERVICE
          predicates:
            - Path=/patient/**

        - id: doctor-service
          uri: lb://DOCTOR-SERVICE
          predicates:
            - Path=/doctor/**

        - id: appointment-service
          uri: lb://APPOINTMENT-SERVICE
          predicates:
            - Path=/appointment/**
```

Explanation:

- `lb://SERVICE-NAME`  
  Gateway uses **Eureka service discovery** to locate the service.

- `Path`  
  Defines which request path should be routed to which service.

---

## 3. Run the API Gateway

Start the API Gateway application.

The gateway will run on:

```
http://localhost:8989
```

---

## 4. Test Services through Gateway

Example API calls through gateway:

Patient Service

```
http://localhost:8989/patient/getall
```

Doctor Service

```
http://localhost:8989/doctor/getall
```

Appointment Service

```
http://localhost:8989/appointment/book
```

---

# Architecture Overview

Client → API Gateway → Eureka Server → Microservices

The API Gateway acts as a **routing layer** between the client and backend services.