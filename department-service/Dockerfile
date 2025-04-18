FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar department-service.jar
ENTRYPOINT ["java", "-jar", "department-service.jar"]