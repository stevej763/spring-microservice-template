FROM openjdk:17
WORKDIR /app
ARG JAR_FILE=service/target/service-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker" ,"-jar","app.jar"]