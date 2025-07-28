FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy project files
COPY java/src/main/java/com/example/App.java ./App.java

# Compile the Java file
RUN mkdir out && javac App.java -d out

# Expose port for HTTP server
EXPOSE 8080

# Run the HTTP server
CMD ["java", "-cp", "out", "com.example.App"]
