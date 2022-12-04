#!/bin/bash

cd rmi
./gradlew build

gnome-terminal -- java -jar bike/build/libs/BikeServer-0.1.0.jar
gnome-terminal -- java -jar user/build/libs/UserServer-0.1.0.jar
