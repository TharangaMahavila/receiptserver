# Use JDK 21 image
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copy project files
COPY . .

# Make wrapper executable
RUN chmod +x ./gradlew

# Build jar
RUN ./gradlew clean build --no-daemon

# Runtime image
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]