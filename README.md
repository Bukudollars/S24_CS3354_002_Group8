# S24_CS3354_002_Group8
Spring 24 CS 3354 Section 2 Group 8 Project

Run "java -jar API-0.0.1-SNAPSHOT.jar" 
The JAR file is found in API\build\libs\

API Enpoints:

GET /users
return list of users

POST /users
curl -X POST localhost:8080/users -H 'Content-type:application/json' -d '{"username": "new username", "password": "new password"}