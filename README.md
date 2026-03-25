**A scalable backend service for an e-commerce platform built using Spring Boot. This project demonstrates a clean layered architecture, use of DTO patterns, and robust exception handling to simulate a production-ready backend system.**

**Tech Stack:**
Backend: Spring Boot (Java)
Database: MySQL
ORM: Spring Data JPA / Hibernate
Build Tool: Maven
Testing: JUnit, Mockito

**Architecture:**
This project follows a layered architecture to ensure separation of concerns, scalability, and maintainability:

Controller → Service → Repository → Database
Controller Layer: Handles HTTP requests and responses
Service Layer: Contains business logic
Repository Layer: Interacts with the database using JPA
DTO Layer: Decouples API contracts from internal data models

**Features:**
RESTful APIs for product management
Clean separation using layered architecture
DTO-based request/response handling
Centralized exception handling
Database integration with MySQL
Unit testing with JUnit and Mockito

**Setup & Run Locally**
Prerequisites:
Java 17+
Maven
MySQL
