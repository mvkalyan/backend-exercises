FROM openjdk:latest
WORKDIR usr/lib
EXPOSE 8085
ADD ./target/authUserService-0.0.1-SNAPSHOT.jar /usr/lib/authUserService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","authUserService-0.0.1-SNAPSHOT.jar"]