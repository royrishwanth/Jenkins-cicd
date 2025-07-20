FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy source files
COPY java/src/main/java/com/example/App.java ./App.java

# Compile App.java
RUN mkdir out && javac App.java -d out

# Run the compiled class
CMD ["java", "-cp", "out", "com.example.App"]
