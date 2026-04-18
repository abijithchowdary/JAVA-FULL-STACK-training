# BookStore API Gateway

## Overview

`BookStore-API-GateWay` is the API Gateway for the BookStore microservices setup. It acts as a single entry point for client requests and forwards traffic to downstream services registered in Eureka.

This gateway is currently configured to route requests to:
- `BOOK-SERVICE`
- `ORDER-SERVICE`

## Tech Stack

- Java 17
- Spring Boot 3.2.5
- Spring Cloud Gateway
- Netflix Eureka Client
- Maven Wrapper (`mvnw.cmd`)

## Project Location

`C:\Capgemini-Training\All-Capg-Workspaces\CG_SB_MicroServices-Workspace\BookStore-API-GateWay`

## Current Configuration

The gateway is configured in `src/main/resources/application.yml` with:

- **Gateway port:** `8090`
- **Application name:** `API-GATEWAY`
- **Eureka server:** `http://localhost:8761/eureka`
- **Register with Eureka:** `true`
- **Fetch registry:** `true`
- **Prefer IP address:** `true`

## Configured Routes

### 1. Book Service
- **Route ID:** `book-service`
- **Target URI:** `lb://BOOK-SERVICE`
- **Path predicate:** `/api/books/**`

Example requests through the gateway:
- `GET http://localhost:8090/api/books/getall`
- `GET http://localhost:8090/api/books/getbook/1`
- `POST http://localhost:8090/api/books/add`
- `PUT http://localhost:8090/api/books/update/1`
- `DELETE http://localhost:8090/api/books/delete/1`

### 2. Order Service
- **Route ID:** `order-service`
- **Target URI:** `lb://ORDER-SERVICE`
- **Path predicate:** `/api/orders/**`

Example requests through the gateway:
- `GET http://localhost:8090/api/orders`
- `GET http://localhost:8090/api/orders/1`
- `POST http://localhost:8090/api/orders`
- `PUT http://localhost:8090/api/orders/1`
- `DELETE http://localhost:8090/api/orders/1`

## Prerequisites

Before starting the gateway, make sure these are available:

- Java 17 installed
- Maven wrapper files present in the project
- Eureka Server running on port `8761`
- `BookStore_BookService` running and registered with Eureka
- `BookStore_OrderService` running and registered with Eureka

## Recommended Startup Order

Start the services in this order:

1. `BookStore_EurekaServer`
2. `BookStore_BookService`
3. `BookStore_OrderService`
4. `BookStore-API-GateWay`

## Run the Gateway

From the `BookStore-API-GateWay` folder, use the Maven wrapper.

```bat
cd /d "C:\Capgemini-Training\All-Capg-Workspaces\CG_SB_MicroServices-Workspace\BookStore-API-GateWay"
mvnw.cmd spring-boot:run
```

## Build the Project

```bat
cd /d "C:\Capgemini-Training\All-Capg-Workspaces\CG_SB_MicroServices-Workspace\BookStore-API-GateWay"
mvnw.cmd clean package
```

## Verify Service Registration

Open the Eureka dashboard after starting all services:

`http://localhost:8761`

Check that the gateway and downstream services appear in the registry.

## How Routing Works

The gateway uses service discovery with load-balanced URIs:

- `lb://BOOK-SERVICE`
- `lb://ORDER-SERVICE`

This means requests are forwarded based on the service names registered in Eureka instead of hard-coded host and port values.

## Main Class

Application entry point:

`src/main/java/com/example/demo/BookStoreApiGateWayApplication.java`

This application is annotated with:
- `@SpringBootApplication`
- `@EnableDiscoveryClient`

## Troubleshooting

### Gateway not starting
- Make sure Java 17 is installed.
- Make sure `application.yml` is present under `src/main/resources`.
- Verify no other application is already using port `8090`.

### Routes return 404 or service unavailable
- Confirm Eureka Server is running on port `8761`.
- Confirm Book Service and Order Service are started.
- Verify both services are registered in Eureka.
- Make sure the request path matches the configured predicates:
  - `/api/books/**`
  - `/api/orders/**`

### Service not visible in Eureka
- Check the downstream service configuration for:
  - `eureka.client.service-url.defaultZone=http://localhost:8761/eureka`
- Confirm the service starts without errors.

## Notes

- This README reflects the current gateway configuration found in this project.
- The gateway project currently uses uppercase service IDs in `application.yml`:
  - `BOOK-SERVICE`
  - `ORDER-SERVICE`
- If you later change the application names in downstream services, update the gateway URIs to match the Eureka-registered names.
