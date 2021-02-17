# Build
ARG REGISTRY=docker.io
FROM ${REGISTRY}/maven:3.6.3-jdk-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Package
FROM ${REGISTRY}/openjdk:11-jre-slim
COPY --from=build /home/app/target/employee-api.jar /home/app/employee-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/app/employee-api.jar"]