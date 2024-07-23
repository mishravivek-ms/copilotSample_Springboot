---
page_type: sample
languages:
- java
products:
- Azure Spring Apps
- Azure Database for PostgresSQL
- Azure Cache for Redis
- Azure Active Directory
description: "Deploy Microservice Apps to Azure"
urlFragment: "acme-fitness-store"
---

# Creating a Copilot Demo for Java Springboot Project

Open IntelliJ and download the Java Springboot Project. Add the following dependencies.
* Spring Web.
* Lombok
* JPA
* H2 Database

## Update an Application.property file

Promt will be:

* Prompt: #create a H2 database connection details
* Prompt: #create a connection for JPA and sql
* Prompt: #create a configuration for H2 console

## Create an Entity File

Promt will be:

* Prompt: create a Entity class called Tutorial  with the following attributes: id, title, description, published. Make sure ID as a primary key and auto increment.
* Prompt: use lombok to generate getters and setters. use tostring method to print the object.
* Prompt: create a constructor that takes all the properties as arguments
* Prompt: make table name as "tutorials"
* Prompt: import jakarta.persistence.*;
* Add Column name on top of each fields like "@Column(name ="

## Create Repository file 

Promt will be:

* Prompt: //Create a Interface named TutorialRepository that extends JpaRepository and has a generic type of Tutorial and Long.
* Use CopilotChat for create a methods. Name findByPublished and findByTitleContaining


## Create Controller file 

Promt will be:
* //Create a class named TutorialController that is annotated with @RestController and @RequestMapping with a value of /api.
* //Create a method that returns a list of tutorials by published status
* //Create a method that returns a list of tutorials by title containing a keyword


## Create a POSTMAN request and send request. 
* {
    "title": "PYTHON",
    "description": "PYTHON` BOOK",
    "published": true
}
