## Redis Event Driven Demo application

This app is to test and demonstrate the event-driven application using Redis.

`fish-service` (handles operations on fish, produces event once fish is lured)

`challenge-service` (subscribes to 'lured fish' event and adds up some score points to a challenge score)

Services are runnable as a jar with embedded container, 
or for more convenience as Dockerized images can be deployed to Kubernetes cluster/node.
Project contains a Redis cluster deployable to Kubernetes.

### Runbook
As a prerequisite you will need:
1) Java RE
2) Docker
3) Kubernetes set up in any form.
Minikube or one provided by Docker Desktop is enough.

#### Run Redis pod
1) `cd` to root project directory (Kubernetes resorces declarations are there)
2) install redis server and CLI on K8s:

`kubectl apply -f redis-k8s-deployment.yaml`
3) check the `NodePort` exposed:

`kubectl get service redis-service -o jsonpath={.spec.ports[0].nodePort}`
4) check the kube DNS alias

`kubectl cluster-info`

5) in `application.yaml`s replace the hostname and port number with respective values.
6) in case you want to run the app against your Cloud Redis instance and you need to authenticate,
feel free to set the client password as well.

#### Run Fish service
1) `cd` to root project directory (Dockerfile is there)
2) Build the docker image of the app

`docker build -t fish-app:0.1 fish-service/`
3) install the app on K8s

`kubectl apply -f fish-service/fish-k8s-deployment.yaml`
4) check the `NodePort` exposed:

`kubectl get service fish-service -o jsonpath={.spec.ports[0].nodePort}`
5) check the kube DNS alias

`kubectl cluster-info`

6) try it out

Create a fish:
```
curl --location --request POST 'http://<kube_DNS_alias>:<node_port>/fish' \
--header 'Content-Type: application/json' \
--data-raw '{
   "id": "first",
    "kind": "old one",
    "length": 0.130,
    "weight": 0.4
}'
```
Read all fish:
```
curl --location --request GET 'http://<kube_DNS_alias>:<node_port>/fish'
```

#### Run Challenge service
1) `cd` to root project directory (Dockerfile is there)
2) Build the docker image of the app

`docker build -t challenge-app:0.1 challenge-service/`
3) install the app on K8s

`kubectl apply -f challenge-service/challenge-k8s-deployment.yaml`
4) check the `NodePort` exposed:

`kubectl get service challenge-service -o jsonpath={.spec.ports[0].nodePort}`
5) check the kube DNS alias

`kubectl cluster-info`

6) try it out

```
Read all challenge:
```
curl --location --request GET 'http://<kube_DNS_alias>:<node_port>/challenge'
```