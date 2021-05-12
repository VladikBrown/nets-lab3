FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} front.jar
ENTRYPOINT ["java", "-jar", "front.jar"]