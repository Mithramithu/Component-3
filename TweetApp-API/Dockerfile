FROM openjdk:8
VOLUME /tmp
ADD target/tweetapp-api.jar tweetapp-api.jar
ENTRYPOINT ["java","-jar","/tweetapp-api.jar"]