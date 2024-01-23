FROM maven:3.8-eclipse-temurin-17-alpine
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]