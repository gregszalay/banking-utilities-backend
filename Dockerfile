#RUN WAR WITH JETTY MAVEN PLUGIN
FROM maven:3.6.3-adoptopenjdk-8
COPY application-core/src/ banking-utilities-backend/application-core/src/
COPY application-core/target/ banking-utilities-backend/application-core/target/
COPY application-core/pom.xml banking-utilities-backend/application-core/pom.xml
COPY console-ui/src/ banking-utilities-backend/console-ui/src/
COPY console-ui/target/ banking-utilities-backend/console-ui/target/
COPY console-ui/pom.xml banking-utilities-backend/console-ui/pom.xml
COPY webservice/src/ banking-utilities-backend/webservice/src/
COPY webservice/target/ banking-utilities-backend/webservice/target/
COPY webservice/pom.xml banking-utilities-backend/webservice/pom.xml
COPY pom.xml banking-utilities-backend/pom.xml
RUN mvn -f banking-utilities-backend/ clean install
CMD mvn -f banking-utilities-backend/Webservice clean install jetty:run-war

#DEPLOY WAR ON TOMCAT SERVER (experimental)
#FROM tomcat:8.0-jre8
#FROM tomcat:8.5.64-jdk8-adoptopenjdk-hotspot
#COPY ApplicationCore/target/ApplicationCore*.jar /usr/local/tomcat/webapps/
#COPY Webservice/target/Webservice*.war /usr/local/tomcat/webapps/
#EXPOSE 8080
#CMD ["catalina.sh", "run"]

#DEPLOY WAR ON JETTY SERVER (experimental)
#FROM jetty:9.4.38-jre8-slim
#COPY ApplicationCore/target/ApplicationCore*.jar $JETTY_BASE/webapps/
#COPY target/Webservice*.war $JETTY_BASE/webapps/
#EXPOSE 8080
#CMD $JETTY_BASE/webapps java -jar $JETTY_HOME/start.jar --add-to-start=http,deploy
##CMD $JETTY_BASE/webapps java -jar $JETTY_HOME/start.jar --add-module=http,deploy
#CMD $JETTY_BASE/webapps java -jar $JETTY_HOME/start.jar