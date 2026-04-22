This project is related to  Automated an E commerance Website(Swags Lab).In this project I used to automation a E commerance Website uing Selenuim and TestnG.

#Tech Stack used:
 1 Selenuim WebDriver
 2 TestNg
 3 J unit
I will validate the Login Page covering all test cases relate to login Page.
# Some of  Positive test cases are:
 Valid username and password → Successful login
 User redirected to dashboard/home page
 Session created after login

#Negative Test Cases are:
 Invalid username and password
 Empty username field
 Empty password field
 Incorrect credentials error message validation
 
#Some Edges are
Locked or Blocked Username
Very long input values
Case sensitivity check (Uppercase/Lowercase)

#Features:
Run tests on multiple browsers (Chrome, Firefox, Edge)
Test on different operating systems
Parallel test execution

#How to Run the Project
Clone the repository
Open in Eclipse / IntelliJ
Configure Maven dependencies
Add Sauce Labs credentials (username & access key)
Run test classes or TestNG file

#Validation Points
Login button functionality
Error message display
URL validation after login
Page load verification
Element visibility checks


# Selenium E-Commerce Automation Project

## 🔧 Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven

---

## 🔐 Login Module
- Valid login test
- Invalid login test
- Locked user validation
- Error message validation

---

## 🛍️ Product Page Validation

I automated and validated the product page functionality of the SauceDemo website.

### ✔ Validations Performed:
- Verified successful navigation to Products page after login
- Validated total number of products displayed
- Checked product names are visible and not empty
- Validated product prices:
    - Price is displayed
    - Correct format ($XX.XX)
    - Price value is greater than 0
- Verified product images are displayed
- Validated "Add to Cart" button visibility
- Tested product details navigation:
    - Clicked each product
    - Verified correct product details page opens
- Validated product descriptions are present
- Checked sorting functionality (if implemented)

---

#Future Enhancements
- Add to Cart functionality
- Remove from Cart
- Checkout process automation
- Page Object Model (POM) implementation
- Explicit waits for stability
- Data-driven testing

---

#How to Run
1. Clone the repository
2. Open in IntelliJ IDEA
3. Run TestNG test classes