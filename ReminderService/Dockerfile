FROM java:8-jre
ADD ./target/docker-reminder-service.jar docker-reminder-service.jar
EXPOSE 9500
ENTRYPOINT ["java","-jar","docker-reminder-service.jar"]