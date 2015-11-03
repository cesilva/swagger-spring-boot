Please follow the following instructions to run this example.

Building the Project.
====================

Pre-requisites
--------------
JDK 1.8.x
Maven 2 or higher
java_home and m2_home has been set.

Steps:
------
1 - download and unzip the project.
2 - Go to the project home directory and run
    execute unit tests - $mvn clean package or $mvn clean package -Punit-test
    execute integration tests - $mvn clean package -Pintegration-test

Running the application.
========================
$mvn clean spring-boot:run


=======================================================================================
------------------------------------
Swagger 
------------------------------------
Once the application is up and running, please follow the following steps to get the API Documentation.

Get the call the restful end point of API docs
    http://localhost:8080/api-docs
    
To get the graphical view of the API, call the following end point
    http://localhost:8080/index.html
        Once the page is loaded, type following in the text box.
            http://localhost:8080/api-docs
            
            
   