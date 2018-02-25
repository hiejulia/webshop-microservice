FROM openjdk:8-jdk-alpine
MAINTAINER Hien Nguyen <hienminhnguyen711@gmail.com>
# Keep consistent with build.gradle
ENV APP_JAR_NAME config-server
ENV APP_JAR_VERSION 0.0.1
#VOLUME /tmp
#ARG JAR_FILE
#ADD ${JAR_FILE} app.jar
ADD config-server.jar /usr/local/config-server/
WORKDIR /usr/local/config-server/
CMD ["java", "-Xms512m", "-Xmx1g", "-jar", "config-server.jar"]
#ENTRYPOINT ["java","-Djava.dosecurity.egd=file:/dev/./urandom","-jar","/app.jar"]




# RUN apk add --update curl && \
#     rm -rf /var/cache/apk/*

# ADD ./build/libs/configuration-microservice-0.0.1-SNAPSHOT.jar /app/
# CMD ["java", "-Xmx200m", "-jar", "/app/configuration-microservice-0.0.1-SNAPSHOT.jar"]

# EXPOSE 8002


# ---------------------------------------------------------

#
#
## Install curl, bash and mysql-client to check if DB is up
#RUN apk --update add curl bash mysql-client && \
#	rm -rf /var/cache/apk/*
#
#RUN mkdir /app
#
#ADD ${APP_JAR_NAME}-${APP_JAR_VERSION}.jar /app/
#ADD run.sh /app/
#RUN chmod +x /app/run.sh
#
#WORKDIR /app
#
#EXPOSE 8888
#
#ENTRYPOINT ["/bin/bash","-c"]
#CMD ["/app/run.sh"]