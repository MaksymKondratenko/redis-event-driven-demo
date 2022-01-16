FROM openjdk:18-jdk-alpine
COPY target/challenge-service-*.jar /challenge-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /challenge-service.jar $SPRING_PROPERTY_OVERRIDE
