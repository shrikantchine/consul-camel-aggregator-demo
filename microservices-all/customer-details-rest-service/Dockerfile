FROM openjdk:8-jdk-alpine

MAINTAINER Shrikant Chine

VOLUME /tmp

# Add Spring Boot app.jar to Container
ADD "target/customer-details-rest-service-1.0.jar" app.jar

ENV JAVA_OPTS=""

# Fire up our Spring Boot app by default
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]