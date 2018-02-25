#!/usr/bin/env bash

# The env var are set up by Dockerfile

java -Djava.security.egd=file:/dev/urandon -Dspring.profiles.active=docker -jar ${APP_JAR_NAME}-${APP_JAR_VERSION}.jar