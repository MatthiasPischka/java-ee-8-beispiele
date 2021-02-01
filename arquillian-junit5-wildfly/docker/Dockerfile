FROM jboss/wildfly:21.0.1.Final
MAINTAINER Matthias Pischka

ENV WILDFLY_HOME /opt/jboss/wildfly

ADD ./target/arquillian-junit5-wildfly.war $JBOSS_HOME/standalone/deployments/

RUN cd $WILDFLY_HOME \
# Admin-User anlegen
&& bin/add-user.sh admin admin1234 --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

EXPOSE 8080
EXPOSE 9990