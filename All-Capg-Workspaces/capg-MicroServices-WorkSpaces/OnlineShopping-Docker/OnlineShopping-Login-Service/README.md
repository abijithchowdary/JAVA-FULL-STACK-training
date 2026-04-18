# Login Service — Online Shopping Application

## Overview

The Login Service is a Spring Boot microservice responsible for user authentication and authorization in the Online Shopping Application. It handles user registration, login validation, JWT token generation, and password encryption using BCrypt.

This service runs independently on **port 9090** and is part of a microservice architecture. Other services like Customer Service communicate with this service via **FeignClient**.

---

## Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| Java | 21 | Core language |
| Spring Boot | 4.0.3 | Framework |
| Spring Security | 7.0.3 | Authentication and BCrypt |
| Spring Data JPA | 4.0.3 | Database operations |
| MySQL | 8.0.42 | Database |
| JWT (jjwt) | 0.11.5 | Token generation |
| HikariCP | 7.0.2 | Connection pooling |
| Apache Tomcat | 11.0.18 | Embedded server |

---

## Project Structure

```
OnlineShopping-Login-Service/
├── src/main/java/com/capg/springboot/
│   ├── OnlineShoppingLoginServiceApplication.java
│   ├── entity/
│   │   └── User.java
│   ├── repository/
│   │   └── UserRepository.java
│   ├── service/
│   │   ├── ILoginService.java
│   │   └── LoginServiceImpl.java
│   ├── controller/
│   │   └── LoginController.java
│   ├── security/
│   │   ├── JwtUtil.java
│   │   └── SecurityConfig.java
│   └── exception/
│       ├── UserNotFoundException.java
│       ├── UserAlreadyExistsException.java
│       ├── InvalidCredentialsException.java
│       └── GlobalExceptionHandler.java
└── src/main/resources/
    └── application.properties
```

---

## Database Configuration

- **Database:** MySQL
- **Database Name:** `ecommerce`
- **Table:** `users`
- **Port:** 3306

### Users Table Structure

| Column | Type | Constraints |
|---|---|---|
| user_id | BIGINT | PRIMARY KEY, AUTO_INCREMENT |
| email | VARCHAR | NOT NULL, UNIQUE |
| password | VARCHAR | NOT NULL (BCrypt hashed) |
| role | VARCHAR | NOT NULL (ADMIN / CUSTOMER) |

---

## application.properties

```properties
server.port=9090
spring.application.name=LOGIN-SERVICE

spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=mySecretKey12345mySecretKey12345mySecretKey12345
jwt.expiration=36000000
```

---

## How to Run

### Prerequisites
- Java 21 installed
- MySQL 8.0 running on port 3306
- Maven installed

### Steps

```bash
# Step 1 — Clone or open the project in your IDE

# Step 2 — Update application.properties with your MySQL password

# Step 3 — Run the application
mvn spring-boot:run

# OR run the main class directly from IDE:
# OnlineShoppingLoginServiceApplication.java
```

### Verify Running
```
Console should show:
OnlineShopping Login service is now running on port 9090...
```

---

## Security

### Password Encryption
- All passwords are hashed using **BCrypt** before saving to database
- BCrypt adds a random salt — same password gives different hash every time
- Hashing runs 2^10 = 1024 times making brute force attacks very slow
- Example: `"pass123"` → `"$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy"`

### JWT Token
- On successful login, a **JWT (JSON Web Token)** is returned
- Token contains: `userId`, `role`, `issuedAt`, `expiration`
- Token is valid for **10 hours**
- Token is signed with a secret key — any tampering is detected automatically

### Roles
| Role | Access |
|---|---|
| `ADMIN` | Full access to all modules |
| `CUSTOMER` | Limited access — read only on products, own profile only |

---

## REST API Endpoints

### Base URL
```
http://localhost:9090
```

### 1. Register User
```
POST /login/addUser
Content-Type: application/json

Request Body:
{
  "email": "john@gmail.com",
  "password": "pass123",
  "role": "CUSTOMER"
}

Success Response: 201 Created
{
  "userId": 1,
  "email": "john@gmail.com",
  "password": "$2a$10$xxx...",
  "role": "CUSTOMER"
}

Error Responses:
409 Conflict      → Email already registered
400 Bad Request   → Invalid role (must be ADMIN or CUSTOMER)
400 Bad Request   → Invalid email format
```

### 2. Login — Validate User
```
POST /login/validateUser
Content-Type: application/json

Request Body:
{
  "email": "john@gmail.com",
  "password": "pass123"
}

Success Response: 200 OK
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIn0.xxxxxx   (JWT Token)

Error Responses:
404 Not Found     → No account found with this email
401 Unauthorized  → Incorrect password
```

### 3. Get User By ID
```
GET /login/getUser/{userId}

Example: GET /login/getUser/1

Success Response: 200 OK
{
  "userId": 1,
  "email": "john@gmail.com",
  "password": "$2a$10$xxx...",
  "role": "CUSTOMER"
}

Error Response:
404 Not Found     → User not found with this ID
```

### 4. Get User By Email
```
GET /login/getUserByEmail/{email}

Example: GET /login/getUserByEmail/john@gmail.com

Success Response: 200 OK
{
  "userId": 1,
  "email": "john@gmail.com",
  "role": "CUSTOMER"
}

Note: This endpoint is primarily called by Customer Service
      via FeignClient — not for direct use
```

### 5. Sign Out
```
PUT /login/signOut/{userId}

Example: PUT /login/signOut/1

Success Response: 200 OK
User 1 signed out successfully

Error Response:
404 Not Found     → User not found
```

### 6. Delete User
```
DELETE /login/removeUser/{userId}

Example: DELETE /login/removeUser/1

Success Response: 200 OK
{
  "userId": 1,
  "email": "john@gmail.com",
  "role": "CUSTOMER"
}

Error Response:
404 Not Found     → User not found
```

---

## Exception Handling

All exceptions are handled globally by `GlobalExceptionHandler.java`

| Exception | HTTP Status | When Thrown |
|---|---|---|
| UserNotFoundException | 404 Not Found | userId or email not found in DB |
| UserAlreadyExistsException | 409 Conflict | Email already registered |
| InvalidCredentialsException | 401 Unauthorized | Wrong password |
| IllegalArgumentException | 400 Bad Request | Invalid role or email format |

---

## How Other Services Use This

Customer Service calls Login Service via **FeignClient**:

```
Customer registers → Customer Service calls POST /login/addUser
                  → Login Service creates User
                  → Returns userId
                  → Customer Service saves customer with that userId
```

This is how microservices communicate — no shared database foreign keys, just HTTP calls between services.

---

## Postman Test Collection — Quick Reference

| # | Method | Endpoint | Expected |
|---|---|---|---|
| 1 | POST | /login/addUser (CUSTOMER) | 201 |
| 2 | POST | /login/addUser (ADMIN) | 201 |
| 3 | POST | /login/addUser (duplicate email) | 409 |
| 4 | POST | /login/addUser (wrong role) | 400 |
| 5 | POST | /login/addUser (bad email) | 400 |
| 6 | POST | /login/validateUser (valid) | 200 + JWT |
| 7 | POST | /login/validateUser (wrong password) | 401 |
| 8 | POST | /login/validateUser (wrong email) | 404 |
| 9 | GET | /login/getUser/1 | 200 |
| 10 | GET | /login/getUser/999 | 404 |
| 11 | PUT | /login/signOut/1 | 200 |
| 12 | PUT | /login/signOut/999 | 404 |
| 13 | DELETE | /login/removeUser/1 | 200 |
| 14 | DELETE | /login/removeUser/999 | 404 |

---

## Mentor
Mr. Ramkumar Sir — Capgemini Training

## Project
Sprint 1 — Team 6 — Online Shopping Application Microservices