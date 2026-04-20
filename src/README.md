# Selenium Login Page Automation Testing

## 📌 Project Overview

This project focuses on automated testing of a Login Page using Selenium WebDriver.
It validates different user scenarios including valid login, invalid login, edge cases, and cross-browser testing using Sauce Labs.

---

## 🚀 Features Covered

* Login functionality validation
* Positive and negative test cases
* Edge case testing
* Cross-browser testing using Sauce Labs
* Automated test execution

---

## 🛠️ Technologies Used

* Java
* Selenium WebDriver
* TestNG / JUnit
* Maven
* Sauce Labs (Cloud Testing Platform)

---

## 🔐 Test Scenarios

### ✅ Positive Test Cases

* Valid username and password → Successful login
* User redirected to dashboard/home page
* Session created after login

### ❌ Negative Test Cases

* Invalid username and password
* Empty username field
* Empty password field
* Incorrect credentials error message validation

---

## ⚠️ Edge Cases

* Username with special characters
* Password with maximum length
* SQL Injection attempt (e.g., ' OR '1'='1)
* Very long input values
* Case sensitivity check (Uppercase/Lowercase)
* Multiple failed login attempts

---

## 🌐 Sauce Labs Integration

This project uses Sauce Labs for cloud-based cross-browser testing.

### ✔ Features:

* Run tests on multiple browsers (Chrome, Firefox, Edge)
* Test on different operating systems
* Parallel test execution

---

## ▶️ How to Run the Project

1. Clone the repository
2. Open in Eclipse / IntelliJ
3. Configure Maven dependencies
4. Add Sauce Labs credentials (username & access key)
5. Run test classes or TestNG file

---

## 📂 Project Structure

* `test/` → Test scripts
* `pages/` → Page Object Model classes
* `utils/` → Utility classes
* `resources/` → Config files

---

## 📊 Validation Points

* Login button functionality
* Error message display
* URL validation after login
* Page load verification
* Element visibility checks

---

## 🔄 API / Backend Validation (Optional)

Login API can also be tested using Postman for response validation.

---

## 👤 Author

Deepak Kumar
