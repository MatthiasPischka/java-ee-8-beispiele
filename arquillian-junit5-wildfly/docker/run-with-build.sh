#!/bin/bash

# Baue per Maven
mvn clean package -DskipTests -f ../pom.xml

# Starte jetzt den Container
sh run.sh