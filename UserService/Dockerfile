FROM java:8-jre
ADD ./target/docker-user-service.jar docker-user-service.jar
EXPOSE 9200
ENTRYPOINT ["java","-jar","docker-user-service.jar"]