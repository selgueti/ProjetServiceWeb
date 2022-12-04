#!/bin/bash

cd rmi
./gradlew build

gnome-terminal -- java -jar bike/build/libs/BikeServer-0.1.0.jar
gnome-terminal -- java -jar user/build/libs/UserServer-0.1.0.jar

cd ../spring
mvn package
gnome-terminal -- java -jar target/spring-mvc-1.0-SNAPSHOT.jar
sleep 5
firefox http://localhost:8081/login