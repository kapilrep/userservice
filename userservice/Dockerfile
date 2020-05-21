FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} userservice-docker.jar
ENTRYPOINT ["java","-jar","userservice-docker.jar"]