FROM openjdk:latest
WORKDIR user/lib
EXPOSE 8084
ADD ./target/jwt-0.0.1-SNAPSHOT.jar /user/lib/jwt-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","jwt-0.0.1-SNAPSHOT.jar"]