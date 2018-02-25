FROM anapsix/alpine-java:8_jdk_unlimited
MAINTAINER Venkata Ravuri <venkat@nikhu.com>

RUN apk add --update curl && \
    rm -rf /var/cache/apk/*

ADD ./build/libs/cart-microservice-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx1024m", "-jar", "/app/cart-microservice-0.0.1-SNAPSHOT.jar"]

EXPOSE 9002





#VOLUME /tmp
#ADD *.jar app.jar
#RUN sh -c 'touch /app.jar'
#EXPOSE 8080
#ENV JAVA_OPTS=""
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]