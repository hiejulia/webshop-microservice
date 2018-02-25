#!/usr/bin/env bash

set -e
#set -x

# Add clean build start option 

declare -a services=("config-server","api-gateway","order-service")
# Echo 
# docker-compose rm && true


echo "::Step 1/2 building jars"

services_to_build=("${services[@]}" )

if ["$*" != ""] ; then 
    services_to_build=("$@")
fi

for i in "${services_to_build[@]}"
do 
    echo "Building $i"
    cd $i 
    ./gradlew clean
    ./gradlew build    
    cd .. 
done 

echo "::Starting containers"
docker-compose up --build 

# set +x