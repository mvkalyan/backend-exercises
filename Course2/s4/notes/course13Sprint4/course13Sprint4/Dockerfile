#docker image for java 11
FROM openjdk
#Reffering to working Directory of your image

WORKDIR usr/lib

#copy paste database name and mongodb url from application.resources

ENV MONGO_DATABASE=wave30
ENV MONGO_URL=mongodb://localhost:27017/wave30

#copy executable file and put it your working directory
#add source destination
ADD ./target/course13Sprint4-0.0.1-SNAPSHOT.jar usr/lib/course13Sprint4-0.0.1-SNAPSHOT.jar



ENTRYPOINT["java","-jar","course13Sprint4.0.0.1-SNAPSHOT.jar"]

