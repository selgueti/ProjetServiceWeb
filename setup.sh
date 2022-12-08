#!/bin/bash

#cd rmi
#./gradlew build
java -jar rmi/bike/build/libs/BikeServer-0.1.0.jar &
java -jar rmi/user/build/libs/UserServer-0.1.0.jar &

#cd ../spring
cd spring

mvn package
java -jar target/spring-mvc-1.0-SNAPSHOT.jar &
sleep 5
firefox http://localhost:8081/login
