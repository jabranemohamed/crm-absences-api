FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} absence-api.jar
ENTRYPOINT ["java","-jar","/absence-api.jar"]