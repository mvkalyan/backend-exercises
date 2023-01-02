FROM openjdk

WORKDIR usr/lib

ENV MONGO_DATABASE=backend
ENV MONGO_URL=mongodb://localhost:27017/backend

ADD ./target/apigateway-0.0.1-SNAPSHOT.jar apigateway-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","apigateway-0.0.1-SNAPSHOT.jar"]