FROM  openjdk:11
EXPOSE 8087
ADD /target/transaction-service-0.0.1-SNAPSHOT.jar transaction-service.jar
ENTRYPOINT ["java", "-jar", "transaction-service.jar"]