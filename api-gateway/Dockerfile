FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar api-gateway.jar
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]