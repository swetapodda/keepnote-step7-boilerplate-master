FROM java:8-jre
ADD target/docker-category-service.jar docker-category-service.jar
EXPOSE 9400
ENTRYPOINT ["java","-jar","docker-category-service.jar"]