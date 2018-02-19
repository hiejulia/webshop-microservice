FROM frolvlad/alpine-oraclejdk8:slim
ADD config-server.jar /usr/local/config-server/
WORKDIR /usr/local/config-server/
CMD ["java", "-Xms512m", "-Xmx1g", "-jar", "config-server.jar"]