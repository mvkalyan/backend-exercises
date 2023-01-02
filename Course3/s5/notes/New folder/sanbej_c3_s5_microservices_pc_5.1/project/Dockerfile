#docker image for java 11
FROM openjdk:latest
#Reffering to working Directory of your image

WORKDIR usr/lib

#copy paste database name and mongodb url from application.resources

ENV MONGO_DATABASE=backend
ENV MONGO_URL=mongodb://localhost:27017/

#copy executable file and put it your working directory
#add source destination
ADD ./target/project-0.0.1-SNAPSHOT.jar usr/lib/project-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","usr/lib/project-0.0.1-SNAPSHOT.jar"]