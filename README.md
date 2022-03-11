# aspire-automation-assignment-Ivan
Automation Test Assignment For Aspire 

## Tools And Libraries

This assignment uses the below frameworks / libraries:

* **Java 11**: the programming language
* **TestNG**: test framework
* **Selenium WebDriver**: the web browser automation tool
* **AssertJ**: assertion library
* **Allure Report**: test report library
* **Faker**: data generation
* **Log4J2**: logging tool
* **WebDriverManager**: initialize browser driver management tool
* **Owner**: handle *.properties files tool

## Execution

For test running in local, please do as below steps:

**Pre-conditions:**
1. Clone repo as https://github.com/nguyendankha/aspire-automation-assignment.git
2. Open IDE and reload Maven dependencies for loading/downloading all needed libraries

**Steps:**
1. Go to **src/test/resources/execute/** folder
2. Right-click on **local.xml** file
3. Select **Run ...** setting

After test run finished, use the Terminal/cmd to check the report:
1. Open **Terminal / cmd** program
2. Go to the {path/of/your/project}:
`cd {path/of/of/your/project}`
3. Type the command: `mvn allure:serve`

## Assignment architecture

* **Page Object Model** pattern
* **Execution types**: There are **local** and **remote** target modes (grid selenium)
* **BaseTest**: Setup and tear down for the tests
* **TestListener**: Log and report
* **Log**: Log during test runtime
* **Configuration**: Use Owner to handle properties files for general data
* **Data Factory**: Data manipulation for testing
