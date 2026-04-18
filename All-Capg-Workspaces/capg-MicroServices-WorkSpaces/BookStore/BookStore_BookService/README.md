# BookStore Book Service

## Overview
The **BookStore Book Service** is a microservice responsible for managing the **Book Catalog** in the BookStore application. It provides full CRUD (Create, Read, Update, Delete) operations for books and exposes REST APIs consumed directly or via the API Gateway.

## Technology Stack
| Technology | Version |
|---|---|
| Java | 21 |
| Spring Boot | 4.0.3 |
| Spring Cloud | 2025.1.0 |
| Spring Data JPA | - |
| MySQL | - |
| Netflix Eureka Client | - |
| Build Tool | Gradle |

## Port
| Service | Port |
|---|---|
| Book Service | **8081** |

## Service Registration
- **Eureka Name:** `book-service`
- Registers with Eureka Server at `http://localhost:8761/eureka`

## Project Structure
```
BookStore_BookService/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/bookstore/
│       │       ├── BookStoreBookServiceApplication.java
│       │       ├── bookcontroller/
│       │       │   └── BookController.java
│       │       ├── bookentity/
│       │       │   └── Book.java
│       │       ├── bookrepository/
│       │       │   └── BookRepository.java
│       │       └── bookservice/
│       │           └── BookService.java
│       └── resources/
│           ├── application.properties
│           └── application.yml
├── build.gradle
└── README.md
```

## Database Setup
Create the MySQL database before running the service:
```sql
CREATE DATABASE bookstoredb;
```

### `application.properties`
```properties
spring.application.name=book-service
server.port=8081

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
> Update `spring.datasource.username` and `spring.datasource.password` as per your local MySQL setup.

## Book Entity Fields
| Field | Type | Description |
|---|---|---|
| `bookId` | Long | Auto-generated primary key |
| `title` | String | Book title |
| `author` | String | Author name |
| `isbn` | String | ISBN number |
| `price` | double | Price of the book |
| `quantity` | int | Available stock |
| `category` | String | Book category/genre |

## REST API Endpoints
| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/books/getall` | Get all books |
| `GET` | `/api/books/getbook/{id}` | Get a book by ID |
| `POST` | `/api/books/add` | Add a new book |
| `PUT` | `/api/books/update/{id}` | Update an existing book |
| `DELETE` | `/api/books/delete/{id}` | Delete a book |

### Sample Request — Add a Book
```http
POST http://localhost:8081/api/books/add
Content-Type: application/json

{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "978-0132350884",
  "price": 499.99,
  "quantity": 50,
  "category": "Software Engineering"
}
```

### Sample Request — Get All Books
```http
GET http://localhost:8081/api/books/getall
```

### Via API Gateway
```http
GET http://localhost:8090/api/books/getall
POST http://localhost:8090/api/books/add
GET http://localhost:8090/api/books/getbook/{id}
PUT http://localhost:8090/api/books/update/{id}
DELETE http://localhost:8090/api/books/delete/{id}
```

## How to Run

### Prerequisites
- Java 21 installed
- MySQL running on port 3306
- EurekaServer running on port 8761

### Steps
```cmd
gradlew.bat bootRun
```
Or:
```bash
./gradlew bootRun
```

## Troubleshooting
| Problem | Solution |
|---|---|
| Cannot connect to MySQL | Verify MySQL is running and credentials in `application.properties` are correct |
| Not registering with Eureka | Ensure EurekaServer is running before starting BookService |
| Port 8081 in use | Change `server.port` in `application.properties` |
