FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=lab2-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} back.jar
ENTRYPOINT ["java", "-jar", "back.jar"]