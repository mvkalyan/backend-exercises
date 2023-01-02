FROM openjdk:latest

WORKDIR usr/src

ENV MONGO_URI=mongodb://localhost:27017/product

ADD ./target/UserMovieService-0.0.1-SNAPSHOT.jar /usr/src/UserMovieService-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","UserMovieService-0.0.1-SNAPSHOT.jar"]
