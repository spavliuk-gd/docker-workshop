ARG ARCHIVE_FILE_NAME='application.jar'
ARG GRADLE_IMAGE_TAG=6.7-jdk11
ARG JRE_IMAGE_TAG=11-jre

### Build
FROM gradle:${GRADLE_IMAGE_TAG} AS BUILD
WORKDIR /app

ARG ARCHIVE_FILE_NAME

COPY build.gradle settings.gradle ./

#caching dependencies
RUN env ARCHIVE_FILE_NAME=${ARCHIVE_FILE_NAME} gradle clean build --no-daemon -x :test || true

COPY . .

RUN env ARCHIVE_FILE_NAME=${ARCHIVE_FILE_NAME} gradle clean build --no-daemon -x :test

### Deploy
FROM openjdk:${JRE_IMAGE_TAG}

ARG ARCHIVE_FILE_NAME
ENV ARCHIVE_FILE_NAME=${ARCHIVE_FILE_NAME}

WORKDIR /app

COPY --from=BUILD /app/build/libs/${ARCHIVE_FILE_NAME} /app/${ARCHIVE_FILE_NAME}

CMD java -jar ${ARCHIVE_FILE_NAME}
