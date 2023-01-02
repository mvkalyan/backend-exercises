FROM openjdk:latest

WORKDIR user/lib

EXPOSE 8082

ADD ./target/UserAuthenticationService-0.0.1-SNAPSHOT.jar /user/lib/UserAuthenticationService-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","UserAuthenticationService-0.0.1-SNAPSHOT.jar"]
