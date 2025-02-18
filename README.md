# Spring Boot Application - Order Dashboard

This is a Spring Boot application that implements a login page using Spring Security and displays a dashboard with order
details after successful authentication. The application uses MySQL as the database and follows the MVC pattern.

## Features

Login Page: Authenticates users using Spring Security.

Dashboard: Displays order details, a logout button, and the username of the logged-in user.

Database: Uses MySQL for storing user and order data.

## Prerequisites

* Java 17
* MySQL
* Maven

## Installation and Execution Instructions

1. Clone the Project
   First, get the project files by cloning the repository. In your terminal (or Git Bash), run:

   `git clone https://github.com/yourusername/order-dashboard-app.git`

   `cd order-dashboard-app`
2. Set Up MySQL Database
   You need a MySQL database to store user and order information.

   Create the database: Open MySQL and run this command:

   `CREATE DATABASE qnrprojectdb;`
   `USE qnrprojectdb;`

   Import the schema: Run the database_schema.sql file to create and populate the necessary tables. You can do this from
   MySQL Workbench or command-line:

   `SOURCE /path/to/database_schema.sql;`
3. Configure the Application

   Update the application.properties file with your MySQL database credentials:

   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/qnrprojectdb
   spring.datasource.username=tester
   spring.datasource.password=1234
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```
4. Build and Run the Application
   ```
   mvn clean install
   mvn spring-boot:run
   ```
5. Access the Application

   Open your browser and go to http://localhost:8080.

   Log in using one of the hardcoded users (e.g., valia / 1234).

   After successful login, you will be redirected to the dashboard, where you can see the order details and your
   username.
