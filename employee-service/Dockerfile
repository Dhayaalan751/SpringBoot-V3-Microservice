FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar employee-service.jar
ENTRYPOINT ["java", "-jar", "employee-service.jar"]