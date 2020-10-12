#!/bin/bash

# Baue per Maven
mvn clean package -f ../pom.xml

# Starte jetzt den Container
sh run.sh