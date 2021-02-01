#!/bin/bash

NAME="arquillian-junit5-wildfly"

# Ausführungsverzechnis wechseln
cd ..

# Zuvor erstellten Container löschen, wenn vorhanden
docker rm $NAME --force
# Image inklusive Deployment bauen
docker build -t $NAME -f docker/Dockerfile .
# Container starten
docker run -p 8080:8080 -p 9990:9990 --name $NAME $NAME
