

## Overview
### Introduction
 The purpose of this test automation strategy is to define and communicate the overall direction, objectives and approach for the creation of a new test automation framework for Petclinic application.

Logistical details such as exact dates, estimated costs and tools will be defined in the Planning phase.
### Target audience
This document is designed and relevant for:

-   **Quality Assurance (QA) Team:**
    -   **Interest:** Detailed test plans, test cases, and results to ensure thorough testing of the API.
-   **Test Automation Engineers:**
    -   **Interest:** Guidelines on the automation strategy, tools, and frameworks to be used.
-   **Development Team:**
    -   **Interest:** Understanding of the test coverage, types of tests being performed, and any issues identified.

 

### Assumptions
#### Blackbox approach
Due to time restriction, lack of proper development cycle and overall trial nature of general goal this strategy assumes that application is tested in blackbox mode.

Upon expantion of scope, introduction of fullscale development process or change in general goal this strategy is a subject to revision
#### Reader's high competence in Quality Assurance
This strategy document is written and outlined with assumption that target audience is familiar with QA practices, vocabulary and methods. Thus glossary and some detailed explanations may be ommited.
In case of document's audience expansion this strategy is a subject to revision
#### Single actor team
Due to time restriction and the fact that test analyst and automated tests developer are the same person, some details of test documentation may be ommited for sake of efficiency.
However, certain level of transparency for any newcoming person with basic knoweledge of context is mandatory.

### Risks

|Description| Severity |Probability |Mitigation|
|--|--|--|--|
| Current resourse is limited to a single QA Automation.<br> This sets"bus-factor" of a project to 1.0<br>Any process interruption may significatnly impact implementation | Critical | Medium | In case of conditions preventing full task execution, reduce scope of automation.<br>In case of severe delay project presentation/release delay should be negotiated with management |
| Relatively low experience of "team" with API testing in non-predetermined framework may lead to stuttering in integration of technologies with each other.| Medium|Medium|Regular evaluation of current state of progress<br>Encourage usage of available case study provided by IT community<br>Fallback on simplified approach/implementation/architecture|

## **1. Design Phase**

### 1.1 Testing scope and objectives:

#### Scope:
The testing will be performed on Petclinic application's "owners" endpoint which supports the following functionalities:
   * **Pet owners management**: Operations related to creating, updating, and deleting pet owner records.
	* **Operations for managing pets** in relation to their owners, such as adding or removing pets from an owner's profile.
	* **Pet's visits management**:Handling of operations related to pet visits, including scheduling and viewing visit details.
#### Out of scope
* Other application endpoints
* Error handling for some scenarios (due to blackbox nature of testing approach)

#### Objectives:

* **Validate API Functionality:** Ensure that all operations related to pet owners, pets, and visits work as intended and produce expected results.
*   **Validate API Security:** Verify that the API is secure, with proper authentication and authorization mechanisms in place to protect data and operations.
*   **Establish Test Automation Framework:** Set up a foundational architecture for automated testing to streamline future test automation efforts.
*   **Reduce Test Cycle Time:** Optimize testing processes to shorten the time required to complete test cycles.
*   **Increase Test Coverage:** Enhance the breadth of testing to cover more scenarios, edge cases, and functionalities.
*   **Reduce Regression Defects:** Aim to minimize the number of defects that occur in production due to changes or updates by improving test coverage and reliability.
*   **Validate Application Performance (Optional):** Assess performance aspects of the API, such as response times and throughput, subject to time constraints.
*  **Skill and approach demonstration:** assuming trial nature of general goal, main objective of automation testing is to demonstrate API automation and framework architecture skills.

### 1.2 Understanding the API Specification
#### Review Documentation:

*   **Available Documentation:** The primary source of documentation includes the Swagger representation of the API and a basic description of the application's data structure.
*   **Documentation Gaps:** During the review, it is essential to identify and document any gaps or limitations in the available documentation that could impede the design of comprehensive test cases. This includes:
    -   **Missing Endpoint Details:** Information about some endpoints or operations may be incomplete.
    -   **Insufficient Request/Response Details:** Lack of clarity on request parameters, response formats, or error handling.
    -   **Unclear Business Logic:** Limited understanding of how certain features are expected to work based on the documentation alone.
 * 

### 1.3 Test Cases Design

**Objective:** To create a structured approach for designing test cases that comprehensively validate the API’s functionality, performance, and security.

#### 1.3.1 Test Case Categories

-   **Functional Test Cases:**
    
    -   **Purpose:** Ensure that the API performs its intended operations correctly.
    -   **Examples:**
        -   **Create Operation:** Validate `POST /owners` to add a new pet owner.
        -   **Read Operation:** Verify `GET /owners/{id}` retrieves the correct pet owner details.
        -   **Update Operation:** Check `PUT /owners/{id}` for updating pet owner information.
        -   **Delete Operation:** Confirm `DELETE /owners/{id}` correctly removes a pet owner.
-   **Boundary Test Cases:**
    
    -   **Purpose:** Test the API’s behavior at the limits of acceptable input values.
    -   **Examples:**
        -   **Maximum Field Length:** Submit a request with the maximum allowed length for text fields.
        -   **Edge Values:** Test numeric fields with boundary values (e.g., `0`, `9999`).
-   **Negative Test Cases:**
    
    -   **Purpose:** Ensure the API handles invalid inputs and operations gracefully.
    -   **Examples:**
        -   **Invalid Data:** Send a request with incorrect data types (e.g., text where a number is expected).
        -   **Unauthorized Access:** Attempt to access restricted endpoints without proper authentication.
-   **Performance Test Cases:**
    
    -   **Purpose:** Assess the API’s performance under various conditions.
    -   **Examples:**
        -   **Load Testing:** Simulate high traffic to evaluate the API’s response times and stability.
        -   **Stress Testing:** Determine the API’s limits by pushing it beyond typical usage patterns.
-   **Security Test Cases:**
    
    -   **Purpose:** Validate the API’s security mechanisms and data protection.
    -   **Examples:**
        -   **Authentication:** Test access control mechanisms to ensure unauthorized users cannot access protected resources.

#### 1.3.2 Test Case Design Process

-   **Identify Test Scenarios:**
    
    -   Use API documentation as well as general personal day-to-day user expeience and QA expertise (a.k.a. "common sence") to outline the scenarios that need testing.
-   **Test Description:**
    
    -   Clearly outline business steps for each test case,.
-   **Determine Expected Results:**
    
    -   Specify what the expected outcome should be for each test case to validate successful execution.

#### 1.3.3 Test Case Documentation**

-   **Format:**
    
    -   Use a standardized format for documenting test cases. Include fields such as Test Case ID, Description, Preconditions Setup, Verifications , Expected and Results, and Actual Results.
    - Classical form of steps can be ommited due to single-action nature of API testing

### 1.4 Choise of Testing Tools and Frameworks

**Objective:** To select and integrate the appropriate tools and frameworks for  API testing automation

#### 1.4.1 Criteria for Selection

-   **Compatibility:**    
    -   Selected tools and frameworks are compatible with the Kotlin programming language and the Maven build system.
-   **Ease of Use:**    
    -   Tools are user-friendly for the development and QA teams, including ease of setup and use.
-   **Integration Capabilities:**    
    -   Tools should be relatively easy to integrate with each other and with CI/CD pipelines.
-   **Support and Community:**    
    -   High level of support available for each tool, including documentation, community forums, and customer support.
-   **Cost:**    
    -   Due to nature of the project, selection of tools is limited to opensource/long trial/demo versions.

#### 1.4.2 Selected Tools and Frameworks

-   **Testing Framework:**    
    -   **Name:** JUnit
    -   **Description:** JUnit is a widely used testing framework for Java and Kotlin that provides annotations and assertions for writing unit tests.

-   **API Testing Tools:**
    
    -   **Name:** Rest-Assured
    -   **Description:** Rest-Assured is a Java-based library used for testing RESTful APIs with a simple and expressive syntax.

-   **Build Tool:**
    
    -   **Name:** Maven
    -   **Description:** Maven is a build automation tool used for managing project dependencies, building projects, and running tests.

-   **Reporting Tool:**
    
    -   **Name:** Allure Reporting
    -   **Description:** Allure Reporting is a flexible and customizable test report tool that provides detailed and visually appealing reports, advanced statistics and has a potential for manual-to-automated tests integration

-   **Continuous Integration/Continuous Deployment (CI/CD) Tool:**
    
    -   **Name:** GitHub Actions
    -   **Description:** GitHub Actions is a CI/CD tool that automates workflows directly from GitHub repositories, including building, testing, and deploying code.

#### 1.4.3 Integration and Setup

-   **CI/CD Integration:**
    
    -   **Description:** Integrate GitHub Actions to automate the build, test, and deployment processes.
    -   **Steps:**
        -   **Create Workflows:** Set up GitHub Actions workflows to automatically trigger builds and tests on code commits and pull requests.
        -   **Configure Actions:** Use predefined actions or custom scripts to run Maven builds, execute JUnit tests, and generate Allure reports.
        -   **Publish Results:** Configure workflows to upload Allure reports as artifacts and deploy them to a reporting server or make them accessible from GitHub.
-   **Version Control Integration:**
    
    -   **Description:** Utilize GitHub Actions to ensure that tests are run as part of the CI pipeline.
    -   **Steps:**
        -   **Set Up Triggers:** Configure triggers for GitHub Actions to run tests on specific events such as code pushes or pull requests.
        -   **Test Reporting:** Integrate Allure reporting into the pipeline to capture and publish test results.

#### 1.4.4 Test data management
Due to blackbox approach of this project, no test data management and/or mocking is available on server side.
Thus all test data is managed as part of test code
*(Please refer to test framework architecture document)*

## 2. Planning

### 2.1 Project Timeline

**Objective:** Define the key milestones and timelines for the implementation of the test automation framework for the Petclinic application.

#### 2.1.1 Milestones

| Milestone | Description | Target Date |
|-----------|-------------|-------------|
| Project Kickoff | Initial meeting to discuss project objectives, scope, and timeline. | N/A |
| Requirements Gathering | Collect and document all necessary information regarding API endpoints and functionalities to be tested. | Day 1 |
| Automation tools selection | Research options for API test automation tools and chose most suitable ones | Day 1 |
| Test Case Design | Create and document detailed test cases for functional, boundary, negative, performance, and security testing. | Day 2 |
| Tool and Framework Setup | Install and configure selected tools and frameworks (JUnit, Rest-Assured, Maven, Allure Reporting). | Day 2-3 |
| Happy Path Test Script Development | Develop basic automated test scripts based on the designed test cases for POC | Day 3 |
| Framework implementation | Crude arcitecture implementation of a framework| Day 3-4 |
| Test Script and Framework Extention | Further develop automated test scripts based on the designed test cases. Deepen and  | Day 4-6 |
| Reporting | Generate and review test reports using Allure Reporting. | Day 6-7 |
| CI/CD integration | Configure CI/CD pipepline | Day 7* |
| Review and Feedback | Conduct a review session to discuss the results and gather feedback. | Day 8 |
| Performance testing setup| Integrate performance testing tool with existing framework|-|
| Performance testing pipeline| Configure additional pipeline/criteria to include performance testing|-|
| Final Adjustments | Make necessary adjustments based on feedback and review results. | - |
| Project Closure/Support Phase |  | - |

### 2.2 Resource Allocation

**Objective:** Identify and allocate necessary resources to ensure the successful execution of the project.

#### 2.2.1 Team Members

*Not applicable*

#### 2.2.2 Tools and Infrastructure

| Tool/Infrastructure | Description | Responsibility |
|---------------------|-------------|----------------|
| JUnit | Testing framework for writing and running tests. | QA Automation Engineer |
| Rest-Assured | Library for testing RESTful APIs. | QA Automation Engineer |
| Maven | Build automation tool. | QA Automation Engineer |
| Allure Reporting | Tool for generating test reports. | QA Automation Engineer |
| GitHub Actions | CI/CD tool for automating workflows. | QA Automation Engineer |

### 2.3 Communication Plan

Not applicable

### 2.4 Budget Estimation

Not applicable

### 2.5 Quality Assurance Plan

**Objective:** Define the measures and metrics to ensure the quality of the test automation framework and the testing process.

#### 2.5.1 Quality Metrics

| Metric | Description | Target |
|--------|-------------|--------|
| Test Coverage | Percentage of API functionalities covered by automated tests. | > 90% |
| Defect Detection Rate | Number of defects identified through automated testing. | > 95% |
| Test Execution Time | Average time to execute automated tests. | < TBD |
| Test Script Reusability | Percentage of test scripts that can be reused for future testing. | > 80% |
| Performance Degradation Detection| Number of identified performance degradations| TBD|

**Note:** this section shows only approximation of target state. Current scope is too small for extrapolation

### 2.6 Contingency Plan

**Objective:** Define a contingency plan to address potential project challenges and ensure successful completion.

#### 2.7.1 Contingency Actions

| Challenge | Contingency Action |
|-----------|--------------------|
| Resource Unavailability | Reduce project scope or extend project timelines. |
| Tool/Framework Issues | Evaluate alternative tools or frameworks and switch if necessary.<br>
Fallback on custom implementations |
| Major Defects Found Late | *Not applicable for project* |
| Scope Creep | *Not applicable for project* |

This detailed planning phase will help ensure that the test automation strategy for the Petclinic application is executed smoothly, with clear milestones, resource allocation, risk management, and communication plans in place.



