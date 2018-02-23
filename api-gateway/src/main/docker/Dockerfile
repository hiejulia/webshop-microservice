FROM java:8
MAINTAINER Hien Nguyen <hienminhnguyen711@gmail.com>
ADD gateway-1.0.jar gateway.jar
EXPOSE 8086
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","gateway.jar"]

#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE
#ADD ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-Djava.dosecurity.egd=file:/dev/./urandom","-jar","/app.jar"]





#
#RUN apk add --update curl && \
#    rm -rf /var/cache/apk/*
#
#ADD ./build/libs/gateway-microservice-0.0.1-SNAPSHOT.jar /app/
#CMD ["java", "-Xmx1024m", "-jar", "/app/gateway-microservice-0.0.1-SNAPSHOT.jar"]

