# Use Temurin JDK 17 for building the app
FROM eclipse-temurin:17-jdk AS build

# Set the working directory
WORKDIR /app

# Copy Gradle files
COPY build.gradle settings.gradle /app/
COPY gradle /app/gradle
COPY gradlew /app/

# Ensure the Gradle wrapper is executable
RUN chmod +x /app/gradlew

# Download dependencies
RUN ./gradlew dependencies --no-daemon

# Copy source code and build the app
COPY . /app
RUN ./gradlew clean build -x test

# Use minimal JRE for the final image
FROM eclipse-temurin:17-jre AS runtime

WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the Spring Boot app port
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
