FROM amazoncorretto:17
WORKDIR /app
COPY target/serv-1.0.0.jar /app/app.jar
EXPOSE 9090
CMD ["java", "-jar", "app.jar"]