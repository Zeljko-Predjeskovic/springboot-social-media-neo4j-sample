FROM adoptopenjdk/openjdk16:jdk-16.0.1_9
EXPOSE 8080
ADD target/social-media-rest-api-0.0.1-SNAPSHOT.jar social-media.jar
ENTRYPOINT ["java","--enable-preview","-jar","/social-media.jar"]