FROM java:8
ADD target/eureka-mcss.jar docker-eureka-mcss.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "docker-eureka-mcss.jar"]