# A template multi-module Spring project to kick-start other projects

## A few basic things

### What's included:

#### a multi-module maven starter project 4 packages 

- rest adapter package using spring-starter-rest
- database adapter package using spring-starter-mongo
- hashicorp vault integration
- docker-compose containerised stack ready to go

Run `startup.sh` to start everything up. This will start a vault container and expose 
it on port 8200, then package the service jar file. This jar file is then copied onto a 
openJDK17 docker image. 