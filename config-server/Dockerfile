FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar config-server.jar
ENTRYPOINT ["java", "-jar", "config-server.jar"]