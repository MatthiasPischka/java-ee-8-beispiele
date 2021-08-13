# java-ee-8-beispiele
Beispiele zu Java EE 8
* **arquillian-junit5-wildfly:** Arquillian mit JUnit 5 im WildFly Remote Server
* **jsf2.3-keycloak:** JSF 2.3 Anwendung, abgesichert durch Keycloak SSO
* **primefaces-schnellstart:** JSF 2.3 Anwendung mit PrimeFaces 8.0

## Ausführen
Alle in diesem Multi-Maven-Projekt untergebrachten Beispiele
müssen auf einem Application-Server ausgeführt werden. 

Um die Ausführung möglichst einfach zu gestalten, enthält jedes Modul Shell-Scripte, die das benötigte Artefakt bauen
 und anschließend per Docker bereitstellen.
 
 ### Vorbedingungen
 * Docker ist auf der Ausführungsplattform installiert, der Daemon ist gestartet und per Konsole (docker) erreichbar
 * Maven ist auf der Ausführungsplattform installiert und per Konsole ausführbar (mvn)
 
 ### Vorbereitung
 * Das gesamte Projekt (java-ee-8-beispiele) per git clonen
 
 ### Starten
 Das jeweilige Beispiel kann per Shell-Skript gestartet werden:
 * **<beispiel-modul>/docker/run-with-build.sh:** Baut das Artefakt, erzeugt das Docker Image inklusive Artefakt und startet
  den Container
 * **<beispiel-modul>/docker/run.sh:** Erzeugt das Docker Image inklusive Artefakt und startet den Container
 
 ### Alternative
 Selbstverständlich kann jedes Beispiel-Artefakt auf herkömmlichem Weg über Maven gebaut und anschließend auf einen
  beliebigen Java EE 8 fähigen Application-Server installiert werden.
