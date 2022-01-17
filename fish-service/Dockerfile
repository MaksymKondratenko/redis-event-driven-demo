FROM openjdk:18-jdk-alpine
COPY target/fish-service-*.jar /fish-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /fish-service.jar $SPRING_PROPERTY_OVERRIDE
