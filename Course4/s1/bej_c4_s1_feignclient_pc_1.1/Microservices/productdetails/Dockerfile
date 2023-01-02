FROM openjdk:latest

WORKDIR usr/lib

ENV MONGO_DATABASE=backend
ENV MONGO_URL=mongodb://localhost:27017/

ADD ./target/productdetails-0.0.1-SNAPSHOT.jar /usr/lib/productdetails-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","productdetails-0.0.1-SNAPSHOT.jar"]
