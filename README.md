# SauceLabAutomation

## Selenium Web Automation Framework

A Java-based web UI automation framework built using Selenium WebDriver, Java, TestNG, Maven, and the Page Object Model (POM) to automate and validate an end-to-end purchase workflow on the SauceDemo application.

The framework follows a structured Page Object Model architecture, separating test logic from page-specific locators and actions to improve code readability, maintainability, and reusability. The automated flow covers the complete customer journey, including login, inventory/product validation, product selection, sorting, adding products to the cart, cart validation, checkout, order confirmation, and logout.

TestNG is used as the test execution and assertion framework, while Maven manages project dependencies and build configuration. Test execution data is externalized through an Excel file, allowing login credentials and test data to be maintained separately from the test code. Application and browser-related configuration is managed through a properties file, reducing hardcoded configuration values.

The framework also incorporates explicit waits and JavaScript execution where required to improve interaction reliability with dynamic UI elements. A BaseTest class handles WebDriver setup and teardown, while dedicated page classes encapsulate the functionality of individual application pages such as Login, Inventory, Cart, Checkout, Checkout Overview, and Checkout Complete.

For reporting, the project integrates ExtentReports to generate an HTML-based execution report. A TestNG Listener is implemented to capture test execution status and integrate test results with the Extent report. Test execution activities are additionally logged using TestNG Reporter logs, providing visibility into individual automation steps.

The project is structured as a Maven-based automation framework and includes TestNG suite configuration, external test data, configuration management, reporting, screenshots, and documentation, making it suitable as a practical demonstration of QA automation and Selenium framework development.

---

## Application Under Test

**SauceDemo**

https://www.saucedemo.com/

The automation covers a complete shopping workflow from login to successful order completion.

---

## Tech Stack

* **Programming Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **Design Pattern:** Page Object Model (POM)
* **Page Object Implementation:** PageFactory
* **Test Data:** Excel using Apache POI
* **Configuration:** Properties file
* **Reporting:** ExtentReports
* **Test Execution Listener:** TestNG Listener
* **IDE:** Eclipse
* **Version Control:** Git / GitHub

---

## Automated End-to-End Flow

The framework automates the following flow:

```text
Launch SauceDemo
      ↓
Verify Login Page
      ↓
Read Login Credentials from Excel
      ↓
Login
      ↓
Verify Inventory Page
      ↓
Verify Product Sorting Options
      ↓
Apply Price Filter
      ↓
Add Selected Products to Cart
      ↓
Open Shopping Cart
      ↓
Verify Cart
      ↓
Proceed to Checkout
      ↓
Enter Customer Information
      ↓
Continue to Checkout Overview
      ↓
Verify Product Details
      ↓
Verify Product Prices
      ↓
Verify Payment Information
      ↓
Verify Item Total
      ↓
Verify Tax
      ↓
Verify Final Total
      ↓
Finish Order
      ↓
Verify Order Completion
      ↓
Verify Thank You Message
      ↓
Verify Order Confirmation
      ↓
Verify Confirmation Image
      ↓
Return to Products
      ↓
Logout 
      ↓
Return to Login 
```

---

## Framework Features

### 1. Page Object Model

Each major page of the application is represented by a separate Page Object class.

This keeps:

* Locators
* Page-specific actions
* Page validations

separate from the test class.

### 2. PageFactory

Selenium PageFactory is used to initialize page elements using `@FindBy`.

Example:

```java
@FindBy(id = "login-button")
private WebElement loginButton;
```

### 3. TestNG

TestNG is used for:

* Test execution
* Assertions
* Test lifecycle management
* Test listeners

The framework uses `@BeforeMethod` and `@AfterMethod` for browser setup and teardown.

### 4. Configuration Management

Application and test configuration values are maintained in:

```text
src/test/resources/config.properties
```

A `ConfigReader` utility is used to read configuration values during test execution.

### 5. Excel Test Data

Login test data is maintained in:

```text
src/test/resources/loginData.xlsx
```

The `ExcelReader` utility reads the username and password from the Excel file.

### 6. ExtentReports

ExtentReports is integrated to generate an HTML execution report.

The report contains:

* Test name
* Test execution status
* Execution logs
* Test information

Generated reports are stored locally under:

```text
reports/
```

### 7. TestNG Listener

A custom TestNG listener is used to integrate TestNG execution with ExtentReports.

The listener handles:

* Test start
* Test success
* Test failure
* Test skip
* Report flushing

The listener is registered with the test class using TestNG's `@Listeners` annotation.

---

## Project Structure

```text
SauceLabAutomation
│
├── src
│   │
│   ├── main
│   │   └── java
│   │       │
│   │       ├── base
│   │       │   └── BaseTest.java
│   │       │
│   │       ├── pages
│   │       │   ├── LoginPage.java
│   │       │   ├── InventoryPage.java
│   │       │   ├── CartPage.java
│   │       │   ├── CheckoutPage.java
│   │       │   ├── CheckoutOverviewPage.java
│   │       │   └── CheckoutCompletePage.java
│   │       │
│   │       └── utils
│   │           ├── ConfigReader.java
│   │           └── ExcelReader.java
│   │
│   └── test
│       │
│       ├── java
│       │   │
│       │   ├── listener
│       │   │   └── TestListener.java
│       │   │
│       │   ├── test
│       │   │   └── EndToEndTest.java
│       │   │
│       │   └── utils
│       │       ├── ExtentLogger.java
│       │       └── ExtentReportManager.java
│       │
│       └── resources
│           ├── config.properties
│           └── loginData.xlsx
│
├── testng.xml
├── pom.xml
├── .gitignore
└── README.md
```

---

## Page Objects

| Page                   | Responsibility                                 |
| ---------------------- | ---------------------------------------------- |
| `LoginPage`            | Login page validation and login actions        |
| `InventoryPage`        | Product page, filtering, menu and cart actions |
| `CartPage`             | Cart validation and checkout navigation        |
| `CheckoutPage`         | Customer information and checkout navigation   |
| `CheckoutOverviewPage` | Order summary and total validations            |
| `CheckoutCompletePage` | Order completion validation                    |

---

## Test Data

The login data is maintained separately from the test logic using Excel.

Example data structure:

| USER                    | PASSWORD     |
| ----------------------- | ------------ |
| standard_user           | secret_sauce |
| locked_out_user         | secret_sauce |
| problem_user            | secret_sauce |
| performance_glitch_user | secret_sauce |
| error_user              | secret_sauce |
| visual_user             | secret_sauce |

The current end-to-end test uses the `standard_user` credentials.

---

## Test Execution

### Using Eclipse

1. Import the project into Eclipse as a Maven project.
2. Make sure Maven dependencies are downloaded.
3. Right-click `EndToEndTest.java`.
4. Select **Run As → TestNG Test**.

### Using Maven

From the project root directory:

```bash
mvn clean test
```

---

## Browser Configuration

The browser can be configured through:

```text
src/test/resources/config.properties
```

Example:

```properties
browser=chrome
url=https://www.saucedemo.com/
```

The framework currently supports Chrome and Edge through the browser configuration.

---

## Reporting

After test execution, ExtentReports generates an HTML report under:


```text
reports/ExtentReport.html
```

Generated reports are excluded from version control through `.gitignore`.

---
## 📊 Test Reports

<img width="1092" height="1605" alt="TestNG Report with Logs" src="https://github.com/user-attachments/assets/34ebcc45-0c38-4c6e-be1d-2073739ec9ad" />
<img width="1092" height="1034" alt="Extent Automation Test Report" src="https://github.com/user-attachments/assets/18b1b86a-7775-4e42-8717-0b6047c97926" />

## Git Ignore

The project excludes generated and IDE-specific files such as:

```text
target/
reports/
screenshots/
test-output/
.classpath
.project
.settings/
.idea/
```

This keeps the GitHub repository focused on the actual framework source code and project resources.

---

## Future Enhancements

Possible future improvements include:

* Failure screenshot integration with ExtentReports
* More comprehensive negative test scenarios
* Additional data-driven test cases
* Parallel test execution
* Improved reusable wait utilities
* Cross-browser execution through Maven/TestNG configuration
* CI/CD integration using GitHub Actions
* Additional reporting enhancements

---

## Learning Objective

This project was created as a practical QA Automation project to strengthen hands-on knowledge of:

* Selenium WebDriver
* Java
* TestNG
* Page Object Model
* PageFactory
* Maven
* Apache POI
* Configuration management
* Test listeners
* ExtentReports
* Git and GitHub

The framework is designed with a simple and maintainable structure while demonstrating commonly used automation testing practices.

---

## Author

**Monika Rani Bilung**

QA Engineer | Manual Testing | Selenium Automation

GitHub: [Monika0015git](https://github.com/Monika0015git)

LinkedIn: [Monika Rani Bilung](https://linkedin.com/in/monika-b-060201274)




