FROM java:8-jre
ADD ./target/docker-note-service.jar docker-note-service.jar
EXPOSE 9300
ENTRYPOINT ["java","-jar","docker-note-service.jar"]