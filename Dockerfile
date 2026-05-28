# Use official Java runtime
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Give permission to gradlew
RUN chmod +x gradlew

# Build the project inside container
RUN ./gradlew clean build

# Expose Spring Boot port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "build/libs/app.jar"]