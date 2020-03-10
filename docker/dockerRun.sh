#!/bin/bash
docker stop rabbit
sleep 5
docker run -d --rm --name rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
