ARG VER=21
ARG FLAVOR=noble

FROM eclipse-temurin:${VER}-jdk-${FLAVOR}
MAINTAINER dynatrace.com

ARG BASE_REPO=ghcr.io/ihudak
RUN mkdir -p /opt/app
ARG JAR_FILE=build/libs/producer-app.jar
COPY ${JAR_FILE} /opt/app/app.jar
RUN ls -la /opt/app
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"
ENV DOCKER_VER="1.7.3"
ENV SERVICE_FULL_NAME=ActiveMQ-Producer-App

ENTRYPOINT export OTEL_SERVICE_NAME="$SERVICE_FULL_NAME" && \
           java -Dotel.service.name=$SERVICE_FULL_NAME -jar /opt/app/app.jar

EXPOSE 8080
EXPOSE 5005
