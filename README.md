# 📌 Rest Assured Learning Plan

## 🔹 What is Rest Assured?
- A **Java-based library** for automating **REST API testing**.
- Allows sending HTTP requests (GET, POST, PUT, DELETE, etc.) and validating responses.
- Works well with **JUnit/TestNG**, **Maven/Gradle**, and UI testing tools like Selenium.

---

## 🔹 Difficulty & Timeline
- **Difficulty**: Low-to-moderate (if you know Java & TestNG).
- **Learning Time**:
  - Basics: 1–2 weeks
  - Advanced usage: ~1 month

---

## 🔹 Learning Roadmap

### ✅ Week 1 – Basics
- **Pre-requisites**:
  - Java basics (OOP, exceptions, collections)
  - TestNG or JUnit basics
  - REST API fundamentals (methods, JSON, status codes)
- **Setup**:
  - Install Java + Maven/Gradle
  - Add Rest Assured dependency
  - Verify setup with a simple GET request
- **First Steps**:
  - Perform GET, POST, PUT, DELETE requests
  - Validate status codes, headers, and JSON response fields

---

### ✅ Week 2 – Intermediate
- **Assertions & Validations**:
  - Use Hamcrest matchers (`equalTo`, `hasItems`, etc.)
  - JSONPath for extracting response values
- **Authentication**:
  - Basic auth, OAuth2, Bearer tokens
- **Data-Driven Tests**:
  - Read data from JSON or Excel
  - Use TestNG `@DataProvider` with Rest Assured

---

### ✅ Week 3 – Advanced
- **Serialization & Deserialization**:
  - Convert JSON to Java POJOs and vice versa (Jackson/Gson)
- **Framework Integration**:
  - Combine Rest Assured with TestNG
  - Add logging & reporting (Allure, Extent Reports)
- **Reusable Framework**:
  - Create `BaseTest` for common setup (base URI, authentication)
  - Build utilities for request/response handling

---

### ✅ Week 4 – Real-World Practice
- Automate APIs from:
  - [Swagger Petstore](https://petstore.swagger.io/)
  - [Reqres](https://reqres.in/)
  - [JSONPlaceholder](https://jsonplaceholder.typicode.com/)
  - GitHub REST API / OpenWeather API
- Add tests to a mini-framework with reporting
- Practice API mocking using Postman Mock Server or WireMock

---

## 🔹 Resources

### 📘 Documentation
- [Official Rest Assured Docs](https://rest-assured.io/)
- [Baeldung Rest Assured Tutorials](https://www.baeldung.com/rest-assured-tutorial)

### 🎥 Courses
- Udemy:
  - *API Testing with Rest Assured* – Rahul Shetty
  - *REST Assured Java API Testing for Beginners* – Pramod Dutta

### 🧑‍💻 Practice APIs
- [Swagger Petstore](https://petstore.swagger.io/)
- [Reqres](https://reqres.in/)
- [JSONPlaceholder](https://jsonplaceholder.typicode.com/)

---

## ✅ Summary
- Rest Assured is beginner-friendly for Java testers.
- Follow the **4-week roadmap** to gain confidence.
- Build a mini-framework to showcase skills in interviews/projects.
