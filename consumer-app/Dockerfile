ARG VER=21
ARG FLAVOR=noble
ARG BASE_REPO=ghcr.io/ihudak

ARG JAR_FILE=build/libs/*.jar

FROM eclipse-temurin:${VER}-jdk-${FLAVOR}
MAINTAINER dynatrace.com

#COPY --from=pae32231.dev.dynatracelabs.com/linux/oneagent-codemodules-musl:java / /
#ENV LD_PRELOAD="/opt/dynatrace/oneagent/agent/lib64/liboneagentproc.so"
RUN mkdir -p /opt/app
COPY build/libs/consumer-app.jar /opt/app/app.jar
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"
ENV DOCKER_VER="1.7.3"
ENV SERVICE_FULL_NAME=ActiveMQ-Consumer-App

ENTRYPOINT export OTEL_SERVICE_NAME="$SERVICE_FULL_NAME" && \
           ls -la /opt/app && \
           sleep 180 && \
           java -Dotel.service.name=$SERVICE_FULL_NAME -jar /opt/app/app.jar

EXPOSE 8080
EXPOSE 5005
