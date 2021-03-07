#!/usr/bin/env bash

gradle clean -x test build

docker build --no-cache -t xingdaba/xingdaba-resource .

docker tag xingdaba/xingdaba-resource hub.c.163.com/riyuexingchenace/xingdaba/xingdaba-resource:latest

docker push hub.c.163.com/riyuexingchenace/xingdaba/xingdaba-resource:latest
