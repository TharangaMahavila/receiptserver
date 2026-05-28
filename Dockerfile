# Use Gradle + JDK 21 image
FROM gradle:8.7-jdk21 AS build

WORKDIR /app

# Copy project files
COPY . .

# Build jar
RUN gradle clean build --no-daemon

# Runtime image
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]