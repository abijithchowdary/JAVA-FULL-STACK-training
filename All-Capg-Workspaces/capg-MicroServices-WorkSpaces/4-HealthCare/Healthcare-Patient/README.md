# Patient Service – Setup and Usage Guide

## Overview

Patient Service manages **patient information** in the Healthcare system.

It provides REST APIs for performing CRUD operations on patient records.

---

# Steps to Create Patient Service

## 1. Create Spring Boot Project

Create a **Spring Boot Starter Project** with the following dependencies:

- Spring Web
- Spring Data JPA
- MySQL Driver
- Eureka Discovery Client

---

## 2. Configure `application.yml`

Place the configuration file in:

```
src/main/resources
```

Example configuration:

```yaml
spring:
  application:
    name: PATIENT-SERVICE

server:
  port: 9001

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

---

## 3. Create Patient Entity

Example:

```java
@Entity
public class Patient {

    @Id
    private int patientId;
    private String name;
    private String email;
    private long phone;

}
```

---

## 4. Create REST APIs

Available APIs:

| Method | Endpoint | Description |
|------|------|------|
POST | `/patient/add` | Add patient |
GET | `/patient/getall` | Get all patients |
GET | `/patient/get/{id}` | Get patient by id |
PUT | `/patient/update/{id}` | Update patient |
DELETE | `/patient/delete/{id}` | Delete patient |

---

## 5. Run the Service

Start the **Patient Service**.

It will automatically register with **Eureka Server**.

---

# Access APIs via Gateway

Example:

```
http://localhost:8989/patient/getall
```