FROM openjdk:13
ADD target/endpoint-info.jar endpoint-info.jar
EXPOSE 9091
ENTRYPOINT ["java", "-jar", "endpoint-info.jar"]
