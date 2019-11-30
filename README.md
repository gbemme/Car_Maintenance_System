# Encentral backend  test

## Task Description
You should be able to start the example application by running the following commands in the root of the project

1. mvn install
2. cd service-gateway
3. sbt run

which starts a webserver on port 9000 (http://localhost:9000) and serves SwaggerUI on http://localhost:9000/docs?url=http://localhost:9000/api-docs.json

The project is based on a small web service which uses the following technologies:

* Java 1.8
* Play Framework
* Database H2 (In-Memory)
* Maven
* Sbt




You should be aware of the following conventions while you are working on this exercise:


 * All new entities should have an ID/Primary key of the type String.
 * The architecture of the web service is built with the following components:
    * The binder project contains the Guice Dependency Injection, that ties all the api and implementation together
    * The commons project contains Utilities, DTOs etc to be used accross all the modules
    * The entities project contains the database domain objects
    * The service-endpoint project provisions the whole project for REST access
    * The service-gateway project contains the play framework using sbt sitting on top of all other projects to handle request and response.
    * The user-management-api and user-management-impl projects contain a sample project for user management, if need be, other projects can be created.
 * TestDrivenDevelopment is a good choice, but it's up to you how you are testing your code.

When you run mvn install, it builds all projects above except  `service-gateway`
and when you sbt run it will use all the libraries built with maven and run  `service-gateway`

## Note
In case you have issues seeing your lates changes in sbt, clear your sbt cache likely found in ` ~/.ivy2/cache/com.encentral.test_project/`

After completing the challenge, please upload the project into a public repository (Github/Bitbucket) and send us the link.

---


## Task 1
 * Write a new Controller for maintaining cars (CRUD).
   * Decide on your own how the methods should look like.
   * Entity Car: Should have at least the following characteristics: license_plate, seat_count, convertible, rating, engine_type (electric, gas, ...)
   * Entity Manufacturer: Decide on your own if you will use a new table or just a string column in the car table.
 * Extend the DriverController to enable drivers to select a car they are driving with.
 * Extend the DriverController to enable drivers to deselect a car.
 * Extend the JpaDriver to map the selected car to the driver.
 * You can add sample data when loading your application by populating this script: service-gateway/conf/META-INF/load_script.sql

---


## Task 2
First come first serve: A car can be selected by exactly one ONLINE Driver. If a second driver tries to select a already used car you should throw a CarAlreadyInUseException.

---


## Task 3
Imagine a driver management frontend that is used internally by Encentral employees to create and edit driver related data. For a new search functionality, we need an endpoint to search for drivers. It should be possible to search for drivers by their attributes (username, online_status) as well as car characteristics (license plate, rating, etc).

* implement a new endpoint for searching or extend an existing one
* driver/car attributes as input parameters
* return list of drivers

---


## Task 4 (optional)
This task is _voluntarily_, if you can't get enough of hacking tech challenges, implement security.
Secure the API so that authentication is needed to access it. The details are up to you.

Please include instructions how to authenticate/login, so that we can test the endpoints you implemented!

---

You have 7 days to complete your test, in case you need more time, send us a message. 


Good luck!
❤️ Encentral

