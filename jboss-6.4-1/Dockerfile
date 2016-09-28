### Set the base image from Fedora
FROM jboss/base-jdk:7

### File Author / Maintainer
MAINTAINER "Babatunde Adeyemi" "me@tundeadeyemi.com"

### Install EAP 6.4
ADD installs/jboss-eap-6.4.zip /tmp/jboss-eap-6.4.zip
RUN unzip /tmp/jboss-eap-6.4.zip

### Set environment
ENV JBOSS_HOME /opt/jboss/jboss-eap-6.4

### Create EAP user
RUN $JBOSS_HOME/bin/add_user.sh admin admin123! --silent

### Configure EAP
RUN echo "JAVA_OPTS=\"\$JAVA_OPTS -Djboss.bind.address=0.0.0.0 -Djboss.bind.address.management=0.0.0.0\"" >> $JBOSS_HOME/bin/standalone.conf

### Open ports
EXPOSE 8080 9990 9999

### Start EAP
ENTRYPOINT $JBOSS_HOME/bin/standalone.sh -c standalone-full.xml