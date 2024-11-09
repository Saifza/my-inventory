# My Inventory Management System

This is an inventory management system developed using Java Spring Boot for the backend, with three frontend options: plain HTML, Bootstrap-styled HTML, and a React application. The project includes REST API endpoints for managing inventory and features real-time updates through WebSocket.

## Features

- **Backend**: Java Spring Boot
  - RESTful API endpoints for CRUD operations on inventory products
  - Real-time inventory updates using WebSocket for subscribers
  - Error handling with custom exceptions
- **Frontend Options**:
  - Plain HTML interface
  - Bootstrap-styled HTML interface for a more polished UI
  - React frontend with Bootstrap styling for a modern single-page application experience

## Project Structure

```plaintext

my-inventory
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.inventory.my_inventory
│   │   │       ├── MyInventoryApplication.java
│   │   │       ├── configuration
│   │   │       │   ├── WebConfig.java
│   │   │       │   └── WebSocketConfig.java
│   │   │       ├── controller
│   │   │       │   ├── DashboardControllerBootstrap.java
│   │   │       │   ├── InventoryController.java
│   │   │       │   └── ProductController.java
│   │   │       ├── entity
│   │   │       │   └── Product.java
│   │   │       ├── exception
│   │   │       │   └── ResourceNotFoundException.java
│   │   │       ├── repository
│   │   │       │   └── ProductRepository.java
│   │   │       ├── service
│   │   │       │   └── ProductService.java
│   │   │       └── security
│   │   │           └── (any security configurations if present)
│   ├── main
│   │   └── resources
│   │       ├── static
│   │       │   └── dashboard.html
│   │       ├── templates
│   │       │   ├── dashboard_bootstrap.html
│   │       │   └── dashboard.html
│   │       ├── application.properties
│   │       ├── data.sql
│   │       └── schema.sql
│   ├── test
│   │   └── java
├── inventory-frontend (React Frontend)
│   ├── node_modules
│   ├── public
│   └── src
│       ├── components
│       │   ├── App.css
│       │   ├── App.js
│       │   └── other components
│       ├── index.css
│       └── index.js
├── target
├── pom.xml
└── README.md

## Getting Started

### Prerequisites

Java (version 17 or above)
Maven for dependency management
Node.js and npm for the React frontend

Installation
1. Clone the repository:

* git clone https://github.com/your-username/my-inventory.git
* cd my-inventory

2. Backend Setup:

* Run mvn clean install to install dependencies.
* Configure your database settings in src/main/resources/application.properties.

3.Database Setup:

* Database schema and initial data are handled in schema.sql and data.sql, respectively.
* When you start the application, these scripts will automatically populate the database.

4. Frontend Setup:

*For the React frontend, navigate to inventory-frontend:

cd inventory-frontend
npm install
npm start

 Usage

1. Start the Spring Boot application:
mvn spring-boot:run

2. Access different frontends:

* Plain HTML: http://localhost:8080/dashboard.html
* Bootstrap HTML: http://localhost:8080/dashboard_bootstrap.html
* React: http://localhost:3000

 Dockerization (Optional)

You can build the Docker image without a Dockerfile by using the Spring Boot build-image plugin in pom.xml. To do this:
mvn spring-boot:build-image -Dspring-boot.build-image.imageName=my-inventory:latest

 API Endpoints

* GET /api/products: List all products
* POST /api/products: Add a new product
* PUT /api/products/{id}: Update a product
* DELETE /api/products/{id}: Delete a product

 

 License
This project is licensed under the MIT License.