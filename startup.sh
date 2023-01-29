# script to get dev environment up and running

#First run vault and set the default secrets for mongo etc
./start-vault.sh

# package app to compile any changes
mvn package -Dspring.profiles.active=docker
sleep 1

# build docker image
docker build -t example-app:latest .

sleep 1
# start docker compose stack
docker compose up
