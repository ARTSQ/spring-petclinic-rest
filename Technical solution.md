

# API Test Automation Documentation

## Technical Solution Selection for API Test Automation

### Overview
The chosen technical solution for API test automation leverages Kotlin and Spring Boot, providing a robust and scalable framework for testing RESTful APIs. This setup ensures high maintainability, readability, and ease of integration with CI/CD pipelines.

### Key Technologies and Libraries
#### Kotlin
A modern programming language, working on JVM

[Official website](https://kotlinlang.org/)

**Pros:**
* providing concise syntax that improves readability
* enhanced safety features
* fully interoperable with Java
* imroved support of functional programming
* popular language for Android development 

**Cons:**
* some differences with Java may lead to collisions with java-based external libraries behavior.

#### JUnit5
Widely used testing framework for unit and integration testing in Java and Kotlin.

[Official website](https://junit.org/junit5/docs/snapshot/user-guide/)

**Pros:**
* most popular framework on Java, easy to find case study and  QA automation engeneers with corresponding knoweledge
* most popular framework with developers, which simplifies QA/Dev interaction
* built-in syntax for parametrized and parallel tests
#### RestAssured:
Library for testing and validating REST APIs in Java, providing a domain-specific language for writing tests.

[Official website](https://rest-assured.io/)

**Pros:**
* simple syntax that allows to ad-hoc/prototype tests for new endpoints
* gherkin syntax (give/when/then) leaves room for migration on BDD
* built-in serialization/deserialization
* open-source
** Cons:**
* crude implementation of some methods
* some collisions with Kotlin (e.g. not accounting Kotlin generics)

#### Maven: 
Build automation tool used for project management and comprehension, primarily used in Java projects.

[Official website](https://maven.apache.org/)

**Pros**
* simple xml syntax
* more reliable support in Intellij IDEA
* supported by GitHub Actions CI/CD

#### Allure Report (Allure)
A framework designed to create test execution reports in complex yet convenient and practical form

[Official website](https://allurereport.org/)

**Pros:**
* visual reports
* supports both static and live reports
* supports many test frameworks, includint non-Java based.
* seemless migration to Allure TestOps (paid)
**Cons**
* requires annotations migration to support descriptions

## Architecture of the Test Automation Framework

### High-Level Architecture
The test automation framework is designed to be modular and extensible, following a layered architecture pattern. The main components of the architecture include:

1. **Test Data Layer**: Defines data classes and data providers for generating test data.
2. **Page Interface Layer**: Contains interfaces defining actions that can be performed on API endpoints.
3. **Page Actions Layer**: Implements the interfaces and encapsulates the logic for interacting with API endpoints.
4. **Test Cases Layer**: Contains the actual test cases that utilize the page actions to perform API operations and validate responses.
5. **Utilities Layer**: Provides common utility methods and validation logic used across the framework.

###  Layered Architecture Diagram
||
|--|
|Test Cases Layer|
||
| Page Actions Layer |
||
|Page Interface Layer|
||
|Test Data Layer|
||
|Utilities Layer|
||

## Component Description

### Test Data Layer

-   **Data Classes**: Represent the structure of test data used in tests.
    
    -   **OwnerForTests**: Defines the properties and methods for creating and managing owner test data.
    -   **PetForTests**: Defines the properties and methods for creating and managing pet test data.
    -   **PetTypeForTests**: Defines the properties and methods for creating and managing pet type test data.
    -   **VisitForTests**: Defines the properties and methods for creating and managing visit test data.
-   **Data Providers**: Provide different sets of test data for executing tests.
    
    -   **OwnersTestDataProviders**: Contains methods to provide various owner data sets for tests.
    -   **PetTestDataProviders**: Contains methods to provide various pet data sets for tests.

### Page Interface Layer

-   **Interfaces**: Define the contract for actions that can be performed on API endpoints.
    -   **GeneralPageInterface**: A base interface defining common actions applicable to all endpoints.
    -   **OwnerActionsInterface**: Defines actions specific to the owner endpoint, such as creating, updating, and deleting owners.
    -   **PetTypesActionsInterface**: Defines actions specific to the pet types endpoint, such as creating, updating, and deleting pet types.

### Page Actions Layer

-   **Classes**: Implement the interfaces and contain the actual logic for interacting with the endpoints.
    -   **OwnerEndpointActions**: Implements `OwnerActionsInterface`, encapsulating logic for interacting with the owner endpoint. Methods include createOwner, updateOwner, deleteOwner, etc.
    -   **PetTypesEndpointActions**: Implements `PetTypesActionsInterface`, encapsulating logic for interacting with the pet types endpoint. Methods include createPetType, updatePetType, deletePetType, etc.

### Test Cases Layer

-   **Test Classes**: Contain the actual test cases that utilize the page actions to perform API operations and validate responses.
    -   **OwnerEndpointTests**: Contains test cases for testing the owner endpoint. Each test case prepares test data, performs actions using `OwnerEndpointActions`, and validates the responses. For example, test cases may include tests for creating an owner, updating an owner, and deleting an owner.

### Utilities Layer

-   **Utility Classes**: Provide common utility methods and validation logic used across the framework.
    -   **utilMethods**: Contains general-purpose utility methods that are used across various tests and actions.
    -   **Validators**: Contains methods for validating API responses against expected results. For example, it includes methods to validate owner responses, pet responses, and other entity responses.



## Design Patterns Adopted in the Solution

### 1. Page Object Pattern
The framework adopts the Page Object pattern, a popular design pattern for test automation. It helps in creating an abstraction layer for the API endpoints, encapsulating the interaction logic within dedicated classes. This pattern improves code reusability and maintainability.

- **Page Interfaces**: Define the contract for actions that can be performed on API endpoints.
- **Page Actions**: Implement the interfaces and contain the actual logic for interacting with the endpoints.

### 2. Data-Driven Testing
The framework supports data-driven testing by utilizing data providers and test data classes. This pattern allows the same test logic to be executed with different sets of input data, enhancing test coverage and reducing redundancy.

- **Data Classes**: Represent the structure of test data.
- **Data Providers**: Provide different sets of test data for executing tests.

### 3. Factory Pattern
The Factory pattern is used for creating instances of test data classes and other components, promoting loose coupling and enhancing test flexibility.

### 4. Singleton Pattern
Singleton pattern is used in utility classes to ensure there is only one instance of a particular utility, providing a global point of access to common methods.

### Example Test Case Structure
A typical test case in the `OwnerEndpointTests` class would follow these steps:
1. Prepare test data using data providers.
2. Perform API actions using page actions.
3. Validate the API response using utility methods.

### Sample Test Case
```kotlin
@Test
fun testCreateOwner() {
    // Step 1: Prepare test data
    val ownerData = OwnersTestDataProviders.getOwnerData()

    // Step 2: Perform API action
    val response = OwnerEndpointActions.createOwner(ownerData)

    // Step 3: Validate response
    Validators.validateOwnerResponse(response, ownerData)
}
```

This structure ensures that the tests are easy to read, maintain, and extend, providing a solid foundation for API test automation.

## Conclusion
The selected technical solution and architecture provide a robust, scalable, and maintainable framework for API test automation. By leveraging design patterns such as Page Object, Data-Driven Testing, Factory, and Singleton, the framework promotes best practices and ensures high-quality test coverage.
