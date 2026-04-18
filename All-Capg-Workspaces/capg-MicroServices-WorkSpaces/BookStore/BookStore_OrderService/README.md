# BookStore Order Service

## Overview
The **BookStore Order Service** is a microservice responsible for managing **customer orders** in the BookStore application. It uses **OpenFeign** to communicate with the `book-service` to fetch book details (price) when placing an order, automatically calculating the total price based on the book price and quantity ordered.

## Technology Stack
| Technology | Version |
|---|---|
| Java | 21 |
| Spring Boot | 4.0.3 |
| Spring Cloud | 2025.1.0 |
| Spring Data JPA | - |
| MySQL | - |
| Netflix Eureka Client | - |
| OpenFeign | - |
| Build Tool | Maven |

## Port
| Service | Port |
|---|---|
| Order Service | **8082** |

## Service Registration
- **Eureka Name:** `order-service`
- Registers with Eureka Server at `http://localhost:8761/eureka`

## Inter-Service Communication
This service communicates with **BookService** via **Feign Client**:
- `BookClient` calls `GET /api/books/getbook/{id}` on the `book-service`
- On placing an order, the book price is fetched and `totalPrice = bookPrice × quantity` is calculated automatically

## Project Structure
```
BookStore_OrderService/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/bookstore/
│       │       ├── BookStoreOrderServiceApplication.java
│       │       ├── client/
│       │       │   └── BookClient.java          ← Feign Client
│       │       ├── dto/
│       │       │   └── BookDto.java             ← Book Data Transfer Object
│       │       ├── ordercontroller/
│       │       │   └── OrderController.java
│       │       ├── orderentity/
│       │       │   └── Order.java
│       │       ├── orderrepository/
│       │       │   └── OrderRepository.java
│       │       └── orderservice/
│       │           └── OrderService.java
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md
```

## Database Setup
Uses the same MySQL database as BookService:
```sql
CREATE DATABASE bookstoredb;
```

### `application.properties`
```properties
server.port=8082
spring.application.name=order-service

spring.datasource.url=jdbc:mysql://localhost:3306/bookstoredb
spring.datasource.username=root
spring.datasource.password=admin123
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

eureka.client.service-url.defaultZone=http://localhost:8761/eureka
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
```

## Order Entity Fields
| Field | Type | Description |
|---|---|---|
| `id` | Long | Auto-generated order ID |
| `bookId` | Long | ID of the ordered book |
| `customerName` | String | Customer's name |
| `quantity` | Integer | Number of copies ordered |
| `totalPrice` | Double | Auto-calculated (bookPrice × quantity) |
| `status` | String | Order status (e.g., PLACED, CANCELLED) |
| `orderDate` | LocalDate | Date of order (auto-set) |

## Feign Client — BookClient
```java
@FeignClient(name = "book-service")
public interface BookClient {
    @GetMapping("/api/books/getbook/{id}")
    BookDto getBookById(@PathVariable("id") Long id);
}
```
- Discovers `book-service` via Eureka by name
- Returns `BookDto` with fields: `bookId`, `title`, `author`, `isbn`, `price`, `quantity`, `category`

## REST API Endpoints
| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/orders` | Get all orders |
| `GET` | `/api/orders/{id}` | Get an order by ID |
| `POST` | `/api/orders` | Place a new order |
| `PUT` | `/api/orders/{id}` | Update order status |
| `DELETE` | `/api/orders/{id}` | Delete an order |

### Sample Request — Place an Order
```http
POST http://localhost:8082/api/orders
Content-Type: application/json

{
  "bookId": 1,
  "customerName": "John Doe",
  "quantity": 2
}
```
> `totalPrice`, `status`, and `orderDate` are set automatically by the service.

### Sample Response
```json
{
  "id": 1,
  "bookId": 1,
  "customerName": "John Doe",
  "quantity": 2,
  "totalPrice": 999.98,
  "status": "PLACED",
  "orderDate": "2026-03-15"
}
```

### Via API Gateway
```http
GET  http://localhost:8090/api/orders
POST http://localhost:8090/api/orders
GET  http://localhost:8090/api/orders/{id}
PUT  http://localhost:8090/api/orders/{id}
DELETE http://localhost:8090/api/orders/{id}
```

## How to Run

### Prerequisites
- Java 21 installed
- Maven installed
- MySQL running on port 3306
- EurekaServer running on port 8761
- BookService running on port 8081

### Steps
```cmd
mvnw.cmd spring-boot:run
```
Or:
```bash
./mvnw spring-boot:run
```

## Startup Order
```
1. BookStore-EurekaServer  (port 8761)  ← Must be running
2. BookStore-BookService   (port 8081)  ← Must be running (Feign client target)
3. BookStore-OrderService  (port 8082)  ← Start this service
```

## Troubleshooting
| Problem | Solution |
|---|---|
| Feign call fails with 503 | Ensure `book-service` is running and registered in Eureka |
| `bookId` not found | The `bookId` must exist in the `books` table in MySQL |
| Cannot connect to MySQL | Verify MySQL credentials in `application.properties` |
| Port 8082 in use | Change `server.port` in `application.properties` |
