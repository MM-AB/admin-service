# Admin microservice

## Prerequisites

Create network **rsonetwork** if there is none:

```bash
docker network create rsonetwork
```

Install MongoDB and start MongoDB server with:
```bash
mongod
```

Clean install Maven package:
```bash
mvn clean install
```


## Build and run Docker containers

Building **admin-service** container:
```bash
docker build -t admin-service .
```

Run mongo:
```bash
docker run --name=mongo --rm --network=rsonetwork mongo
```

Run app:
```bash
docker run --name=admin-service --rm --network=rsonetwork -p 8080:8080 -e MONGO_USER_URL=MONGO_URL=mongodb://mongo:27017/users admin-service
```

## Rename Docker image and push to repository

Rename image:
```bash
docker tag admin-service rsoreg.azurecr.io/admin-service:**tag**
```

Push to repositorty:
```bash
docker push rsoreg.azurecr.io/admin-service:**tag**
```
