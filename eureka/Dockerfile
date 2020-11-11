ARG JRE_IMAGE_TAG=11-jre

FROM openjdk:${JRE_IMAGE_TAG}

WORKDIR /app

COPY build/libs/eureka-0.0.1-SNAPSHOT.jar /app/application.jar

CMD java -jar application.jar
