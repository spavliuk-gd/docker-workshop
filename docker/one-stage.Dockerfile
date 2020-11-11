ARG JRE_IMAGE_TAG=11-jre

FROM openjdk:${JRE_IMAGE_TAG}

ARG ARCHIVE_FILENAME_PATH

WORKDIR /app

COPY build/libs/feedservice-0.0.1-SNAPSHOT.jar /app/application.jar

CMD java -jar application.jar
