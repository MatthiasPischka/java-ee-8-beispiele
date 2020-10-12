#!/bin/bash

# Ausführungsverzechnis wechseln
cd ..

# Zuvor erstellten Container löschen, wenn vorhanden
docker rm wildfly-primefaces-schnellstart --force
# Image inklusive Deployment bauen
docker build -t wildfly-primefaces-schnellstart -f docker/Dockerfile .
# Container starten
docker run -p 8080:8080 --name wildfly-primefaces-schnellstart wildfly-primefaces-schnellstart
