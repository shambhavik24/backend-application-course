FROM eclipse-temurin:17

LABEL maintainer="shambhavik24"

WORKDIR /app

COPY target/courses-backend-application-0.0.1-SNAPSHOT.jar /app/courses-backend-application.jar

ENTRYPOINT ["java", "-jar", "courses-backend-application.jar"]
