FROM openjdk:8
ADD target/SpringBootJwt.jar SpringBootJwt.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "SpringBootJwt.jar"]