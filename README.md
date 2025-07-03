# Incubyte Automation Assessment - Magento Sign-Up & Login Flow

## 🚀 Objective
This project is part of the selection process for the **Software Developer in Testing** role at **Incubyte**. It automates the **sign-up and login functionality** for the website:

🔗 [https://magento.softwaretestingboard.com/](https://magento.softwaretestingboard.com/)

---

## 🧪 Tech Stack & Frameworks
- **Java**
- **Selenium WebDriver**
- **Cucumber (BDD Framework)**
- **JUnit**
- **Page Object Model (POM) Design Pattern**
- **Maven** for build management

---

## 📂 Project Structure

MagentoAutomation/
│
├── src/
│ ├── main/
│ │ └── java/pages/ → Page classes (POM)
│ ├── test/
│ │ ├── java/stepdefinitions/ → Cucumber Step Definitions
│ │ ├── java/features/ → .feature files (BDD)
│ │ └── java/runners/ → Test runner classes
│
├── pom.xml → Maven dependencies
├── README.md → You're reading it :)
├── test-cases.xlsx → Manual test cases
├── screenshots/ → Screenshots of test execution
└── target/html-report → HTML test report


---

## ✅ Features Automated

- Create an account with valid credentials
- Validate mandatory fields (e.g., email, password)
- Check password mismatch error
- Sign in with the newly created account
- Error validation for incorrect credentials
- Forgot Password link clickability check

---

## 🧾 Test Cases

Test cases are documented in:  
📄 [`test-cases.xlsx`](./test-cases.xlsx)

Each test case includes:
- Test Scenario
- Steps
- Expected Result
- Actual Result
- Status (Pass/Fail)

---

## 🖼️ Proof of Execution

Screenshots are available inside the `screenshots/` folder.  
✔️ Includes successful registration  
✔️ Login confirmation  
✔️ Validation error messages

---

## ▶️ How to Run

### Prerequisites
- Java 17+
- Maven
- Chrome + compatible ChromeDriver

### Run Tests via Maven:
```bash
mvn clean test
