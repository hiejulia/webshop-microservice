FROM java:8
MAINTAINER Hien Nguyen <hienminhnguyen711@gmail.com>
ADD products-1.0.jar productservice.jar
EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","productservice.jar"]

#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE
#ADD ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-Djava.dosecurity.egd=file:/dev/./urandom","-jar","/app.jar"]





#
#RUN apk add --update curl && \
#    rm -rf /var/cache/apk/*
#
#ADD ./build/libs/product-catalog-microservice-0.0.1-SNAPSHOT.jar /app/
#CMD ["java", \
#"-Dcom.sun.management.jmxremote", \
#"-Dcom.sun.management.jmxremote.port=4444", \
#"-Dcom.sun.management.jmxremote.local.only=false", \
#"-Dcom.sun.management.jmxremote.authenticate=false", \
#"-Dcom.sun.management.jmxremote.ssl=false", \
#"-Xmx1024m", "-jar", "/app/product-catalog-microservice-0.0.1-SNAPSHOT.jar"]
#
#EXPOSE 9001
#EXPOSE 4444