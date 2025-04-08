# 🔨 Build Stage
FROM maven:3.8.6-eclipse-temurin-17 AS builder

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN ./mvnw dependency:go-offline

COPY src ./src
RUN ./mvnw clean package -DskipTests

# 🚀 Runtime Stage
FROM openjdk:17-slim

WORKDIR /app
COPY --from=builder /app/target/BookStore-1.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
