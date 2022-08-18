# HWA-Project

Coverage: 85.9%

This product is an OOP based full-stack web application that allows you to apply CRUD functionality to a locally-hosted, persistent database through a pre-made website.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them

```
You will need JRE 8 or above installed - https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
You will need MySQL Workbench to hold the persistent database locally - https://dev.mysql.com/downloads/workbench
Any Browser
```

### Installing

On the repository, click on the ( <> Code ) tab in the top left

```
<> Code
```

Then click on the ( Code ) buttom next to the green "Use template" button

```
Code
```
Then download this as a zip file to a location of your choosing

```
Download ZIP
```

Extract the .zip file. 

Then open your terminal from the root folder and run the following:
```
java -jar StarterProject-0.0.1-SNAPSHOT.jar
```
You can press TAB at any time to auto complete the command.

## Running the tests

To run your own tests, you would need to open the project inside an IDE, such as eclipse, and run the src/test/java package as a JUNIT Test

### Integration Test

The integration test is used to ensure each layer of the application communicates and functions as intended.
e.g Controllers -> Services -> Repos -> Services -> Repos
```
src/test/java/com/qa/main/controllers/DriverControllerIntegrationTest.java
```

### Unit Tests

These tests are done to ensure each individual method is acting as intended by mocking the connection to different parts of the API.
e.g in the DriverServiceUnitTest, the connection is mocked using Mockito; when service.create is invoked, a hard-coded entity is returned instead of calling the repo.
```
src/test/java/com/qa/main/services/DriverServiceUnitTest.java
src/test/java/com/qa/main/services/DriverControllerUnitTest.java
```



## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [SpringBoot](https://spring.io/projects/spring-boot) - API Framework

## Authors

* **Michael King** - *Created this product*- [MichaelKing](https://github.com/MichaelKing674)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

