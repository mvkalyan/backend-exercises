FROM openjdk

WORKDIR usr/lib

ENV MONGO_DATABASE=backend
ENV MONGO_URL=mongodb://localhost:27017/backend

ADD ./target/productdetails-0.0.1-SNAPSHOT.jar productdetails-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","productdetails-0.0.1-SNAPSHOT.jar"]