# Springboot kafka consumer
## Install Kafka :

```
$ brew update 
$ brew cask install java
$ brew install kafka
```

## Start Zookeeper:
```
$ zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties
```

## Start Kafka:
```
$ kafka-server-start /usr/local/etc/kafka/server.properties
```

## To fix this issue, we need to change the server.properties file.
```
$ vim /usr/local/etc/kafka/server.properties

Here uncomment the server settings and update the value from
listeners=PLAINTEXT://:9092
```

and restart the server and it will work great.

## Create Kafka Topic:
```
$ kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
```

## Initialize Producer console:
```
$ kafka-console-producer --broker-list localhost:9092 --topic test
>send first message
```

## Initialize Consumer console:
```
$ kafka-console-consumer --bootstrap-server localhost:9092 --topic test --from-beginning
```