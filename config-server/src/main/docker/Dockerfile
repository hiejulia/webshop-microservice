FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE
#ADD ${JAR_FILE} app.jar
ADD config-server.jar /usr/local/config-server/
WORKDIR /usr/local/config-server/
CMD ["java", "-Xms512m", "-Xmx1g", "-jar", "config-server.jar"]
#ENTRYPOINT ["java","-Djava.dosecurity.egd=file:/dev/./urandom","-jar","/app.jar"]



