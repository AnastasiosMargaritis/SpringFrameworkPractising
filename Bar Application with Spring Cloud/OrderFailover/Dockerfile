FROM java:8
ADD target/failover-mcss.jar failover-mcss.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "failover-mcss.jar"]