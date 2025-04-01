FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/banco-digital-padrao-camadas.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar", "banco-digital-padrao-camadas.jar"]
