# Spring Boot To-Do List REST API
A simple and robust RESTful API for managing a to-do list, built from scratch using the Spring Boot framework. This project serves as a practical demonstration of core backend development concepts, including creating REST controllers, handling CRUD operations, and interacting with a database using Spring Data JPA.

## Features
* Create: Add new to-do items to the list.

* Read: Retrieve a complete list of all to-do items or a single item by its unique ID.

* Update: Modify the details of an existing to-do item, such as its title or completion status.

* Delete: Remove a to-do item from the list.

## Technologies Used
* **Java 17:** The core programming language.

* **Spring Boot 3:** The primary application framework for building the REST API.

* **Spring Web:** For creating RESTful endpoints (@RestController).

* **Spring Data JPA:** To simplify database interactions and repository management.

* **H2 Database:** An in-memory database, perfect for development and testing.

* **Maven:** For project dependency management and build automation.

## Prerequisites
* Before you begin, ensure you have the following installed on your local machine:

* Java Development Kit (JDK) 17 or later

* Apache Maven

* An IDE like Eclipse or IntelliJ IDEA

* Postman for testing the API endpoints.

## How to Run Locally
#### 1. Clone the repository:

```bash
git clone [https://github.com/YourUsername/spring-boot-todo-api.git](https://github.com/YourUsername/spring-boot-todo-api.git)
```

*(Replace **YourUsername** with your actual **GitHub username**)*

#### 2. Navigate to the project directory:
```
cd spring-boot-todo-api
```

#### 3. Run the application using Maven:
```
mvn spring-boot:run
```
4. The application will start on `http://localhost:8080`. You can access the H2 database console in your browser at `http://localhost:8080/h2-console` (use jdbc:h2:mem:tododb for the JDBC URL).

### API Endpoints Guide
Here is a detailed guide to all the available API endpoints.

#### 1. Get All To-Do Items
**Method:** `GET`
```
URL: /api/todos
```
**Description:** Retrieves a list of all to-do items.

**Success Response (200 OK):**
```
[
    {
        "id": 1,
        "title": "Finish the project README",
        "completed": false
    },
    {
        "id": 2,
        "title": "Push code to GitHub",
        "completed": true
    }
]
```
#### 2. Get a Single To-Do Item
**Method:** `GET`
```
URL: /api/todos/{id}
```
**Description:** Retrieves a single to-do item by its ID.

**Success Response (200 OK):**
```
{
    "id": 1,
    "title": "Finish the project README",
    "completed": false
}
```
#### 3. Create a New To-Do Item
**Method:** `POST`
```
URL: /api/todos
```
**Description:** Adds a new to-do item to the database.

**Request Body:**
```
{
    "title": "Test the API with Postman",
    "completed": false
}
```
**Success Response (200 OK):**
```
{
    "id": 3,
    "title": "Test the API with Postman",
    "completed": false
}
```
#### 4. Update an Existing To-Do Item
**Method:** `PUT`
```
URL: /api/todos/{id}
```
**Description:** Updates the details of an existing to-do item.

**Request Body:**
```
{
    "title": "Test the API with Postman and document it",
    "completed": true
}
```
**Success Response (200 OK):**
```
{
    "id": 3,
    "title": "Test the API with Postman and document it",
    "completed": true
}
```
#### 5. Delete a To-Do Item
**Method:** `DELETE`

**URL:** `/api/todos/{id}`

**Description:** Deletes a to-do item from the database.

**Success Response (204 No Content):** The response body will be empty.
