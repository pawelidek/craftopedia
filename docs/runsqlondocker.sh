#!/bin/sh
docker run -p 0.0.0.0:3306:3306 --name craftopedia -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=craftopedia -d mysql