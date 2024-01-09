#Dockerfile
FROM openjdk:17-alpine
WORKDIR /usr/src/application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
EXPOSE 8080
CMD ["java", "-jar", "application.jar"]