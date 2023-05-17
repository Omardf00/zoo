FROM openjdk
WORKDIR /app
COPY target/zoo.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]