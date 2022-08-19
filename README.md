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

Done!

## Using the application

Step 1: Running the .jar file from the root folder.
```
java -jar StarterProject-0.0.1-SNAPSHOT.jar
```
You can press TAB at any time to auto complete the command.
![image](https://user-images.githubusercontent.com/107991354/185516160-390de13f-67e9-4e23-8735-c4d91c67f78f.png)

Once the application is running the terminal should look like this:
![image](https://user-images.githubusercontent.com/107991354/185516398-a9d9e436-4725-4c1c-a265-1cac3ca428c9.png)

Step 2:
Go into a browser of your choice and type the following into your url bar:
```
localhost:8080
```
You should land on the front-end, like so:
![image](https://user-images.githubusercontent.com/107991354/185516496-0fc2384a-3cf8-429b-8a5b-1a9a88506cd9.png)

If you get an error, the port may be different. Check here in the log to check which port the application is running on:
![image](https://user-images.githubusercontent.com/107991354/185516618-4acf195f-7130-48cc-a069-a7427a00faa3.png)


## Running the tests

To run your own tests, you would need to open the project inside an IDE, such as eclipse, and run the src/test/java package as a JUNIT Test

### Integration Test

The integration test is used to ensure each layer of the application communicates and functions as intended.
e.g Controllers -> Services -> Repos -> Services -> Repos
```
src/test/java/com/qa/main/controllers/DriverControllerIntegrationTest.java
```
![image](https://user-images.githubusercontent.com/107991354/185516776-caca2d23-7bf5-44ee-b393-86578eafe98c.png)

### Unit Tests

These tests are done to ensure each individual method is acting as intended by mocking the connection to different parts of the API.
e.g in the DriverServiceUnitTest, the connection is mocked using Mockito; when service.create is invoked, a hard-coded entity is returned instead of calling the repo.
```
src/test/java/com/qa/main/services/DriverServiceUnitTest.java
src/test/java/com/qa/main/services/DriverControllerUnitTest.java
```
![image](https://user-images.githubusercontent.com/107991354/185516812-41124c8f-e208-4179-aeb7-7da534f7396d.png)
![image](https://user-images.githubusercontent.com/107991354/185516836-d510f43f-49d8-48a8-80c9-456da9ac83d4.png)

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [SpringBoot](https://spring.io/projects/spring-boot) - API Framework

## Authors

* **Michael King** - *Created this product*- [MichaelKing](https://github.com/MichaelKing674)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

