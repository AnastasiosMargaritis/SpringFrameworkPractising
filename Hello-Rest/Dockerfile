FROM openjdk:8
ADD target/docker-spring-boot.jar hello-rest.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "hello-rest.jar"]