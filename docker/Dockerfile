FROM maven:3.8-eclipse-temurin-17-alpine

EXPOSE 8081

ENV APP_HOME /usr/src/app

COPY target/springmvc-0.0.1-SNAPSHOT.jar $APP_HOME/app.jar

WORKDIR $APP_HOME

ENTRYPOINT exec java -jar app.jar