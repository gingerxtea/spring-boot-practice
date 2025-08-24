FROM eclipse-temurin:21-jdk-alpine AS build
COPY . /app
WORKDIR /app
RUN ./mvnw package -DskipTests

FROM openjdk:21-slim
COPY --from=build /app/target/my-application.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]