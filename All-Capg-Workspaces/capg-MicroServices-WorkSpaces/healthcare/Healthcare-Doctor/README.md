# Doctor Service – Setup and Usage Guide

## Overview

Doctor Service manages **doctor information** such as specialization, hospital details and contact information.

---

# Steps to Create Doctor Service

## 1. Create Spring Boot Project

Create a Spring Boot project with the following dependencies:

- Spring Web
- Spring Data JPA
- MySQL Driver
- Eureka Discovery Client

---

## 2. Configure `application.yml`

Example configuration:

```yaml
spring:
  application:
    name: DOCTOR-SERVICE

server:
  port: 9002

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

---

## 3. Create Doctor Entity

Example:

```java
@Entity
public class Doctor {

    @Id
    private int doctorId;
    private String name;
    private String specialization;
    private String hospital;

}
```

---

## 4. Available APIs

| Method | Endpoint | Description |
|------|------|------|
POST | `/doctor/add` | Add doctor |
GET | `/doctor/getall` | Get all doctors |
GET | `/doctor/get/{id}` | Get doctor by id |
PUT | `/doctor/update/{id}` | Update doctor |
DELETE | `/doctor/delete/{id}` | Delete doctor |

---

## 5. Run the Service

Start the **Doctor Service**.

It will automatically register with **Eureka Server**.

---

# Access APIs via Gateway

Example:

```
http://localhost:8989/doctor/getall
```