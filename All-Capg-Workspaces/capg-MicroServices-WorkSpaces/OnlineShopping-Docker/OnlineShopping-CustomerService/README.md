# Customer Service — Online Shopping Application

## Overview

The Customer Service is a Spring Boot microservice responsible for managing customer profiles in the Online Shopping Application. It handles customer registration, profile management, and communicates with the Login Service via **FeignClient** for user authentication setup.

This service runs independently on **port 9091**. When a new customer registers, this service internally calls the Login Service (port 9090) to create a user account first, then saves the customer profile — all in a single API call.

---

## Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| Java | 21 | Core language |
| Spring Boot | 4.0.3 | Framework |
| Spring Cloud OpenFeign | 2024.0.0 | HTTP client for Login Service |
| Spring Data JPA | 4.0.3 | Database operations |
| MySQL | 8.0.42 | Database |
| HikariCP | 7.0.2 | Connection pooling |
| Apache Tomcat | 11.0.18 | Embedded server |

---

## Project Structure

```
OnlineShopping-Customer-Service/
├── src/main/java/com/capg/customerservice/
│   ├── CustomerServiceApplication.java
│   ├── entity/
│   │   └── Customer.java
│   ├── dto/
│   │   ├── CustomerRequest.java
│   │   └── UserResponse.java
│   ├── repository/
│   │   └── CustomerRepository.java
│   ├── service/
│   │   ├── ICustomerService.java
│   │   └── CustomerServiceImpl.java
│   ├── controller/
│   │   └── CustomerController.java
│   ├── feignclient/
│   │   └── LoginFeignClient.java
│   └── exception/
│       ├── CustomerNotFoundException.java
│       ├── CustomerAlreadyExistsException.java
│       ├── LoginServiceException.java
│       └── GlobalExceptionHandler.java
└── src/main/resources/
    └── application.properties
```

---

## Database Configuration

- **Database:** MySQL
- **Database Name:** `ecommerce` (shared with Login Service)
- **Table:** `customers`
- **Port:** 3306

### Customers Table Structure

| Column | Type | Constraints |
|---|---|---|
| customer_id | BIGINT | PRIMARY KEY, AUTO_INCREMENT |
| first_name | VARCHAR | NOT NULL |
| last_name | VARCHAR | NOT NULL |
| mobile_number | VARCHAR | NOT NULL |
| email | VARCHAR | NOT NULL, UNIQUE |
| city | VARCHAR | nullable |
| pincode | VARCHAR | nullable |
| user_id | BIGINT | NOT NULL (FK reference to Login Service users table) |

> **Note:** `user_id` is a plain BIGINT column — NOT a JPA `@ManyToOne` foreign key.
> In microservices, cross-service relationships are maintained by storing the ID only,
> not by JPA annotations. The actual User record lives in Login Service database.

---

## application.properties

```properties
server.port=9091
spring.application.name=CUSTOMER-SERVICE

spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

login.service.url=http://localhost:9090
```

---

## How to Run

### Prerequisites
- Java 21 installed
- MySQL 8.0 running on port 3306
- Maven installed
- **Login Service must be running on port 9090** before starting this service

### Steps

```bash
# Step 1 — Start Login Service first (port 9090)

# Step 2 — Open Customer Service project in IDE

# Step 3 — Update application.properties with your MySQL password

# Step 4 — Run the application
mvn spring-boot:run

# OR run the main class directly from IDE:
# CustomerServiceApplication.java
```

### Verify Running
```
Console should show:
Customer Service running on port 9091...
```

---

## FeignClient — Communication with Login Service

Customer Service uses **OpenFeign** to call Login Service. This replaces JPA relationship annotations in microservice architecture.

### How it works

```
Traditional Monolith:
@ManyToOne
private User user;   ← direct JPA reference

Microservice approach:
private Long userId;   ← just stores the ID

When user details needed:
loginFeignClient.getUserById(userId)   ← HTTP call to Login Service
```

### Registration Flow (Option B — Single Call)

```
POST /customer/addCustomer
        ↓
Check customers table — email duplicate? → 409 STOP
        ↓ not duplicate
Call Login Service POST /login/addUser via FeignClient
        ↓
  ┌─────────────────────────────────────────────────┐
  │ 201 → new user created → get new userId         │
  ├─────────────────────────────────────────────────┤
  │ 409 → email exists in Login Service →           │
  │       GET /login/getUserByEmail → get userId    │
  │       create customer with existing userId ✅   │
  ├─────────────────────────────────────────────────┤
  │ other error → Login Service down → 503          │
  └─────────────────────────────────────────────────┘
        ↓
Save customer with userId
        ↓
Return 201 Created
```

---

## REST API Endpoints

### Base URL
```
http://localhost:9091
```

### 1. Register Customer (Single Call)
```
POST /customer/addCustomer
Content-Type: application/json

Request Body:
{
  "firstName": "John",
  "lastName": "Doe",
  "mobileNumber": "9876543210",
  "email": "john@gmail.com",
  "password": "pass123",
  "role": "CUSTOMER",
  "city": "Mumbai",
  "pincode": "400001"
}

Note:
  email + password + role → sent to Login Service via FeignClient
  firstName + lastName + mobileNumber + city + pincode → saved in Customer Service

Success Response: 201 Created
{
  "customerId": 1,
  "firstName": "John",
  "lastName": "Doe",
  "mobileNumber": "9876543210",
  "email": "john@gmail.com",
  "city": "Mumbai",
  "pincode": "400001",
  "userId": 1
}

Error Responses:
409 Conflict            → Customer already registered with this email
503 Service Unavailable → Login Service is down or returned an error
```

### 2. Get Customer By ID
```
GET /customer/getCustomer/{customerId}

Example: GET /customer/getCustomer/1

Success Response: 200 OK
{
  "customerId": 1,
  "firstName": "John",
  "lastName": "Doe",
  "mobileNumber": "9876543210",
  "email": "john@gmail.com",
  "city": "Mumbai",
  "pincode": "400001",
  "userId": 1
}

Error Response:
404 Not Found → Customer not found with ID: 1
```

### 3. Get All Customers
```
GET /customer/getAllCustomers

Success Response: 200 OK
[
  { "customerId": 1, "firstName": "John", "city": "Mumbai", ... },
  { "customerId": 2, "firstName": "Priya", "city": "Delhi", ... }
]

Note: Admin use case — returns all registered customers
```

### 4. Get Customers By City
```
GET /customer/getByCity/{city}

Example: GET /customer/getByCity/Mumbai

Success Response: 200 OK
[
  { "customerId": 1, "firstName": "John", "city": "Mumbai", ... },
  { "customerId": 3, "firstName": "Rahul", "city": "Mumbai", ... }
]

Error Response:
404 Not Found → No customers found in city: Mumbai
```

### 5. Update Customer
```
PUT /customer/updateCustomer
Content-Type: application/json

Request Body:
{
  "customerId": 1,
  "firstName": "Johnny",
  "lastName": "Doe",
  "mobileNumber": "9999999999",
  "email": "john@gmail.com",
  "city": "Bangalore",
  "pincode": "560001",
  "userId": 1
}

Note: customerId is REQUIRED in body for update to work
      email and password updates must be done in Login Service
      This endpoint only updates profile details

Success Response: 200 OK
{
  "customerId": 1,
  "firstName": "Johnny",
  "city": "Bangalore",
  ...
}

Error Response:
404 Not Found → Customer not found with ID: 999
```

### 6. Delete Customer
```
DELETE /customer/removeCustomer/{customerId}

Example: DELETE /customer/removeCustomer/1

Success Response: 200 OK
{
  "customerId": 1,
  "firstName": "John",
  ...
}

Error Response:
404 Not Found → Customer not found with ID: 999

Note: This only deletes the customer profile from Customer Service.
      The User record in Login Service is NOT deleted automatically.
      Login Service removeUser must be called separately if needed.
```

---

## Exception Handling

All exceptions are handled globally by `GlobalExceptionHandler.java`

| Exception | HTTP Status | When Thrown |
|---|---|---|
| CustomerNotFoundException | 404 Not Found | customerId or city not found |
| CustomerAlreadyExistsException | 409 Conflict | Email already registered as customer |
| LoginServiceException | 503 Service Unavailable | Login Service down or returned error |
| IllegalArgumentException | 400 Bad Request | Invalid input data |

---

## Admin vs Customer Access

| Operation | Admin | Customer |
|---|---|---|
| Register (addCustomer) | YES | YES |
| View own profile (getCustomer) | YES | YES (own only) |
| View all customers (getAllCustomers) | YES | NO |
| Filter by city (getByCity) | YES | NO |
| Update profile (updateCustomer) | YES | YES (own only) |
| Delete account (removeCustomer) | YES | YES (own only) |

---

## Relationship with Login Service

```
Login Service (port 9090)          Customer Service (port 9091)
─────────────────────────          ──────────────────────────────
users table                        customers table
───────────                        ───────────────
userId (PK) ←──────────────────── userId (stored as plain Long)
email                              customerId (PK)
password (BCrypt)                  firstName, lastName
role                               mobileNumber, email
                                   city, pincode
```

> The `userId` in customers table is NOT a JPA foreign key.
> It is just a number that says "this customer belongs to that user".
> To get user details, Customer Service calls Login Service via FeignClient.

---

## Postman Test Collection — Quick Reference

| # | Method | Endpoint | Body | Expected |
|---|---|---|---|---|
| 1 | POST | /customer/addCustomer | John Mumbai | 201 |
| 2 | POST | /customer/addCustomer | Priya Delhi | 201 |
| 3 | POST | /customer/addCustomer | Rahul Mumbai | 201 |
| 4 | POST | /customer/addCustomer | John again | 409 |
| 5 | POST | /customer/addCustomer | orphan email | 201 |
| 6 | POST | /customer/addCustomer | Login down | 503 |
| 7 | GET | /customer/getCustomer/1 | none | 200 |
| 8 | GET | /customer/getCustomer/999 | none | 404 |
| 9 | GET | /customer/getAllCustomers | none | 200 |
| 10 | GET | /customer/getByCity/Mumbai | none | 200 |
| 11 | GET | /customer/getByCity/Kolkata | none | 404 |
| 12 | PUT | /customer/updateCustomer | customerId 1 | 200 |
| 13 | PUT | /customer/updateCustomer | customerId 999 | 404 |
| 14 | DELETE | /customer/removeCustomer/3 | none | 200 |
| 15 | DELETE | /customer/removeCustomer/999 | none | 404 |

---

## Important Notes

1. **Always start Login Service first** — Customer Service depends on it for registration
2. **Same database** — Both services use `ecommerce` database but different tables
3. **No JPA relationship annotations** across services — microservice principle
4. **Single registration call** — One POST to Customer Service creates both User and Customer
5. **Inconsistent state handled** — If email exists in Login Service but not in Customer Service, Customer Service reuses the existing userId instead of failing

---

## Mentor
Mr. Ramkumar Sir — Capgemini Training

## Project
Sprint 1 — Team 6 — Online Shopping Application Microservices