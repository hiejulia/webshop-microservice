FROM java:8
ADD gateway-1.0.jar gateway.jar
EXPOSE 8086
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","gateway.jar"]

#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE
#ADD ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-Djava.dosecurity.egd=file:/dev/./urandom","-jar","/app.jar"]