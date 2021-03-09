FROM openjdk:12-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
ARG CREDS=src/main/resources/auth-key.json
COPY ${JAR_FILE} app.jar
COPY ${CREDS} creds.json
ENV GOOGLE_APPLICATION_CREDENTIALS=/creds.json
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]