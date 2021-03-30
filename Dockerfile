#RUN WAR WITH JETTY MAVEN PLUGIN
FROM maven:3.6.3-adoptopenjdk-8
COPY ApplicationCore/src/ BankingUtilities/ApplicationCore/src/
COPY ApplicationCore/target/ BankingUtilities/ApplicationCore/target/
COPY ApplicationCore/pom.xml BankingUtilities/ApplicationCore/pom.xml
COPY ConsoleUI/src/ BankingUtilities/ConsoleUI/src/
COPY ConsoleUI/target/ BankingUtilities/ConsoleUI/target/
COPY ConsoleUI/pom.xml BankingUtilities/ConsoleUI/pom.xml
COPY Webservice/src/ BankingUtilities/Webservice/src/
COPY Webservice/target/ BankingUtilities/Webservice/target/
COPY Webservice/pom.xml BankingUtilities/Webservice/pom.xml
COPY pom.xml BankingUtilities/pom.xml
RUN mvn -f BankingUtilities/ clean install
CMD mvn -f BankingUtilities/Webservice clean install jetty:run-war

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