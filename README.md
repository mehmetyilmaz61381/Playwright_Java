# Playwright Java Test Automation Framework

This project is a Java-based end-to-end test automation framework that utilizes [Microsoft Playwright](https://playwright.dev/java/docs/intro) for browser automation, [TestNG](https://testng.org/doc/) for test orchestration, and [ExtentReports](https://extentreports.com/) for detailed HTML test reporting.

## 🎯 Purpose

The framework is designed to automate the login functionality of a sample web application (OrangeHRM Demo) and to generate clear, visual reports of the test execution.

---

## 🚀 Technologies Used

| Technology      | Description                                         |
|----------------|-----------------------------------------------------|
| Java 22         | Primary programming language                        |
| Maven           | Build and dependency management tool                |
| Playwright      | Modern browser automation framework                 |
| TestNG          | Testing framework for managing test cases           |
| ExtentReports   | Tool for generating rich HTML test reports          |

---

## 📁 Project Structure

src/

├── base / → Test setup and teardown logic

├── pages / → Page Object Model classes

├── tests / → Test case implementations

├── utils / → Utilities (reporting, screenshots)

---


📊 Reporting

After the tests finish, a detailed test report is generated at:

test-output/ExtentReport.html


The report includes passed, failed, and skipped tests.

Screenshots are automatically captured and attached for failed tests.


🖼️ Screenshots

For any failed test case, a screenshot will be saved to:

test-output/screenshots/


Screenshots are also linked in the HTML report. 


