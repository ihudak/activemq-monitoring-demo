#!/bin/bash
#export NS=boostrore

kubectl apply -f namespace.yaml
kubectl apply -f configmap.yaml
kubectl apply -f secret.yaml

kubectl apply -f activemq.yaml
read -t 30 -p "Wait till the actibemq gets up..."
echo

kubectl apply -f consumer.yaml
read -t 30 -p "Wait till the consumer gets up..."
echo
kubectl apply -f producer.yaml
kubectl apply -f ingress.yaml
