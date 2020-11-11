FROM gradle:6.7-jdk11 AS BUILD
WORKDIR /app

COPY build.gradle settings.gradle ./
RUN gradle build -x :bootJar -x test --continue

COPY . .

RUN gradle build -x :test

FROM openjdk:11-jre

WORKDIR /app

COPY --from=BUILD /app/build/libs/feedservice-0.0.1-SNAPSHOT.jar /app/application.jar

CMD ["java", "-jar", "application.jar"]
