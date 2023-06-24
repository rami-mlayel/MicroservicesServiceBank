FROM  openjdk:11
EXPOSE 8083
ADD /target/loan-service-0.0.1-SNAPSHOT.jar loan-service.jar
ENTRYPOINT ["java", "-jar", "loan-service.jar"]