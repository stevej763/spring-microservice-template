# script to get dev environment up and running

#First run vault and set the default secrets for mongo etc
./start-vault.sh

# package app to compile any changes
mvn package -Dspring.profiles.active=docker -DskipTests=true

# build docker image
docker build -t example-app:latest .
docker build -t example-lb -f loadBalancer/Dockerfile .

# start docker compose stack
docker compose up
