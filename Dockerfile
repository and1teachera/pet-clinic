FROM openjdk:21-slim
LABEL authors="angel"

ARG JAR_FILE=pet-clinic-web/target/pet-clinic-web-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} pet-clinic-web-0.0.1-SNAPSHOT.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/pet-clinic-web-0.0.1-SNAPSHOT.jar"]
