### Use latest jboss/base-jdk:8 image as the base
FROM jboss/base-jdk:7

### File Author / Maintainer
MAINTAINER "Babatunde Adeyemi" "me@tundeadeyemi.com"

### Set environment variables
ENV JBOSS_HOME /opt/jboss/jboss-eap-6.4

### Set deployment directory
ENV DEPLOYMENT_DIR $JBOSS_HOME/standalone/deployments/

### Add the JBoss distribution to /opt/jboss/, and make jboss it the owner of the
### extracted tar content

### Install EAP 6.4
ADD installs/jboss-eap-6.4.zip /tmp/jboss-eap-6.4.zip

RUN cp /tmp/jboss-eap-6.4.zip $HOME

RUN cd $HOME \ 
	&& unzip jboss-eap-6.4.zip \ 
	&& rm $HOME/jboss-eap-6.4.zip

### Ensure signals are forwarded to the JVM process correctly for graceful shutdown
ENV LAUNCH_JBOSS_IN_BACKGROUND true

### Create EAP user
RUN $JBOSS_HOME/bin/add-user.sh admin admin123! --silent

### Configure EAP
RUN echo "JAVA_OPTS=\"\$JAVA_OPTS -Djboss.bind.address=0.0.0.0 -Djboss.bind.address.management=0.0.0.0\"" >> $JBOSS_HOME/bin/standalone.conf

### Open ports
EXPOSE 8080 9990 9999

### Start EAP
ENTRYPOINT $JBOSS_HOME/bin/standalone.sh -c standalone-full.xml