FROM openjdk

WORKDIR usr/lib

ENV MONGO_DATABASE=backend
ENV MONGO_URL=mongodb://localhost:27017/backend

ADD ./target/course13Sprint4-0.0.1-SNAPSHOT.jar course13Sprint4-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","course13Sprint4-0.0.1-SNAPSHOT.jar"]