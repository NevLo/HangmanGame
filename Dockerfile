FROM ubuntu:latest

RUN apt update

WORKDIR /usr/src/app

COPY . .

CMD [ "java","-jar", "Hangman.jar"]
