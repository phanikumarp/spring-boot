#!/bin/bash

#/usr/bin/update-alternatives --install /usr/bin/java java /usr/lib/jvm/java-7-openjdk-amd64/jre/bin/java 1
#/usr/bin/update-alternatives --set java /usr/lib/jvm/java-7-openjdk-amd64/jre/bin/java

# check for Java installation
#if type java; then
 # echo $(java -version 2>&1 | awk -F '"' '/version/ {print $2}')
 #else
  #  echo "Java not found"
   # exit 1
#fi

echo "Creating group: spring-boot group"
/usr/sbin/groupadd -f -r spring-boot 2> /dev/null || :

echo "Creating user: spring-boot user"
/usr/sbin/useradd -r -m -c "spring-boot user" spring-boot -g spring-boot 2> /dev/null || :
