FROM java:8
VOLUME /tmp
ADD spring-boot-swagger.jar spring-swagger.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-swagger.jar"]