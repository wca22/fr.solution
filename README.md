API to register user(french adult) and see details on an user by 


***Configuration*** 
*MySQL*
Create the schema with the name of "air"

*local.properties**
Go to the directory "fr.solution\air-webservice\src\main\resources"
Open the file name "application-local.properties", edit the values of "username" and "password" to correspond to your informations



***Build & run***
Open in a terminal (Unix) or PowerShell(MS-DOS) the following directory "fr.solution"
Go to the directory air-core by running the command "cd air-core" then run the command "./mvnw install -DskipTests"
Go to the directory air-service by running the command "cd .." then "cd air-service", finally run the command "./mvnw spring-boot:run"


*Postman*
Import and try the samples on the collection name "air" in the following directory "fr.solution"
Caution! You could have errors for the 6 first use of POST method because of the database
