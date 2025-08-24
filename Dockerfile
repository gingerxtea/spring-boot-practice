FROM eclipse-temurin:21-jdk-alpine AS build
COPY . /app
WORKDIR /app
RUN chmod 777 mvnw
RUN ./mvnw package -DskipTests

FROM openjdk:21-slim
COPY --from=build /app/target/start-project-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]