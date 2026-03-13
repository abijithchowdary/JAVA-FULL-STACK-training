# Appointment Service – Setup and Usage Guide

## Overview

Appointment Service handles booking appointments between patients and doctors.

It communicates with:

- Patient Service
- Doctor Service

using **Feign Clients**.

---

# Steps to Create Appointment Service

## 1. Create Spring Boot Project

Create a Spring Boot project with the following dependencies:

- Spring Web
- Spring Data JPA
- MySQL Driver
- Eureka Discovery Client
- OpenFeign

---

## 2. Enable Feign Clients

Main application class example:

```java
@SpringBootApplication
@EnableFeignClients
public class AppointmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppointmentServiceApplication.class, args);
    }

}
```

---

## 3. Configure `application.yml`

Example configuration:

```yaml
spring:
  application:
    name: APPOINTMENT-SERVICE

server:
  port: 9003

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

---

## 4. Book Appointment API

Endpoint:

```
POST /appointment/book
```

Example request:

```json
{
  "appointmentId": 1,
  "patientId": 1,
  "doctorId": 101,
  "appointmentDate": "2026-03-20"
}
```

---

## 5. Response (DTO)

The response contains:

- Appointment details
- Patient details
- Doctor details
- Booking status

Example response:

```json
{
  "appointment": {},
  "patient": {},
  "doctor": {},
  "bookingStatus": "BOOKED SUCCESSFULLY"
}
```

---

# Architecture Overview

Client → API Gateway → Appointment Service → Patient & Doctor Services

Appointment Service aggregates data from multiple services using **Feign Clients**.