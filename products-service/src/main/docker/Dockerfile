FROM java:8
ADD products-1.0.jar productservice.jar
EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","productservice.jar"]

#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE
#ADD ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-Djava.dosecurity.egd=file:/dev/./urandom","-jar","/app.jar"]