FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar organization-service.jar
ENTRYPOINT ["java", "-jar", "organization-service.jar"]