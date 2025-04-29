# Job Listing API

A simple RESTful API for job postings, built with Spring Boot and secured with JWT. This project is designed as a practical demo for learning Spring Security, JWT authentication, and Swagger integration.

---

## 🚀 Features

- User Registration & Login (JWT-based)
- Token-based Authentication with Spring Security
- Public and Secured Endpoints
- Job CRUD operations (secured)
- In-memory H2 Database
- Swagger UI for testing APIs

---

## 🛠️ Technologies Used

- **Java 17**
- **Spring Boot 3**
- **Spring Security**
- **JWT (via jjwt)**
- **Spring Data JPA**
- **H2 Database**
- **Swagger/OpenAPI (springdoc-openapi)**

---

## 🔐 Authentication

Authentication is handled using **JWT**:

- After successful login (`/api/auth/login`), a JWT token is returned.
- Include this token in the `Authorization` header for protected endpoints:
- Swagger UI supports JWT via the **Authorize** button.

---

## 🔧 How to Run

1. **Clone the repository**
 ```bash
 git clone https://github.com/ducdat2793/job-listing-api.git
 cd job-listing-api
 mvn spring-boot:run
```
Access Swagger UI
Visit: http://localhost:8080/swagger-ui/index.html
