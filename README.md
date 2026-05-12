# Online Learning Platform

## Overview

The Online Learning Platform is a full-stack web application built using Java, Spring Boot, Thymeleaf, Maven, and H2/MySQL database. The platform allows users to browse courses, enroll in courses, track lesson progress, and manage learning activities through an interactive interface.

This project demonstrates backend development, frontend integration, MVC architecture, database handling, and RESTful application design.

---

## Features

### User Features
- User registration and login
- Browse available courses
- View course details
- Enroll in courses
- Access lessons
- Track lesson completion progress
- Responsive user interface

### Admin Features
- Manage courses
- Manage lessons
- View enrollments
- Seed demo data automatically

---

## Technologies Used

### Backend
- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Maven

### Frontend
- HTML5
- CSS3
- Thymeleaf
- Bootstrap

### Database
- H2 Database
- MySQL (Optional)

### Tools & Platforms
- VS Code
- Git
- GitHub
- Maven
- Postman

---

## Project Structure

```text
Online-Learning-Platform/
│
├── src/main/java/learning/
│   ├── controller/
│   ├── model/
│   ├── repository/
│   ├── service/
│   └── LearningPlatformApplication.java
│
├── src/main/resources/
│   ├── templates/
│   ├── static/
│   └── application.properties
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

## Installation & Setup

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/Online-Learning-Platform.git
```

---

### 2. Open Project in VS Code

```text
File → Open Folder
```

Select the project folder.

---

### 3. Open Terminal

Shortcut:

```bash
Ctrl + `
```

---

### 4. Build the Project

```bash
mvn clean install
```

---

### 5. Run the Application

```bash
mvn spring-boot:run
```

---

### 6. Open in Browser

```text
http://localhost:8080
```

---

## Database Configuration

### H2 Database

Default H2 configuration is present inside:

```text
src/main/resources/application.properties
```

### Access H2 Console

```text
http://localhost:8080/h2-console
```

---

## GitHub Setup

### Initialize Git

```bash
git init
```

### Add Files

```bash
git add .
```

### Commit Changes

```bash
git commit -m "Initial Commit"
```

### Connect GitHub Repository

```bash
git remote add origin https://github.com/your-username/Online-Learning-Platform.git
```

### Push to GitHub

```bash
git branch -M main
git push -u origin main
```

---

## Main Controllers

| Controller | Purpose |
|---|---|
| AuthController | Handles login and authentication |
| CourseController | Manages courses |
| LessonController | Handles lessons |
| EnrollmentController | Manages enrollments |
| AdminController | Admin operations |
| PageController | Handles web pages/navigation |

---

## Main Models

- User
- Course
- Lesson
- Enrollment
- LessonCompletion

---

## Future Enhancements

- JWT Authentication
- Role-based authorization
- Video lesson support
- Payment integration
- Certificate generation
- Docker deployment
- Cloud hosting
- Unit and integration testing

---

## Screenshots

Add screenshots of:
- Home page
- Course page
- Dashboard
- Enrollment page
- Admin panel

---

## Author

**Shreyas Dorigol**

GitHub: https://github.com/

---

## License

This project is licensed under the MIT License.
