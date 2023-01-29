CONTAINER_NAME=vault-dev
PASSWORD=password
VAULT_ADDR=http://localhost
VAULT_PORT=8200

# remove existing instances
docker rm -f "$CONTAINER_NAME"

# start container
docker run --cap-add=IPC_LOCK \
-p 8200:8200 \
-d \
--name "$CONTAINER_NAME" \
-e VAULT_DEV_ROOT_TOKEN_ID="$PASSWORD" \
-e VAULT_DEV_LISTEN_ADDRESS=0.0.0.0:"$VAULT_PORT" \
-e VAULT_ADDR="$VAULT_ADDR":"$VAULT_PORT" \
vault:latest

sleep 2
# add some default secrets for mongo
docker exec "$CONTAINER_NAME" vault login "$PASSWORD"

docker exec "$CONTAINER_NAME" vault secrets enable -version=2 -path=example kv

docker exec "$CONTAINER_NAME" vault kv put example/example-app/docker \
mongo.host="adhoc-mongo" \
mongo.port="27017" \
