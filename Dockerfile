FROM openjdk:latest
WORKDIR /app
VOLUME /tmp
ARG JAR_FILE=target/rpg-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /app/rpg-app.jar
ENTRYPOINT ["java", "-jar", "rpg-app.jar"]
