FROM openjdk:17 AS openjdk

FROM maven:3.8-openjdk AS build

WORKDIR /app/work/
COPY pom.xml ./
COPY src ./src

RUN --mount=type=cache,target=/root/.m2  mvn clean package -Dmaven.test.skip

FROM openjdk
COPY --from=build /app/work/target/*-exec.jar /app/work/app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/work/app.jar"]