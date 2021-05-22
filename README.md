# Springboot Application with Neo4J 

## Sources

Spring: https://spring.io/guides/gs/accessing-data-neo4j/

Neo4J: https://neo4j.com/developer/spring-data-neo4j/

## Start the app

    git clone https://github.com/Zeljko-Predjeskovic/springboot-social-media.git

    cd springboot-social-media

    mvn clean 

    mvn install

Define your Neo4j connection in src/main/resources/application.properties

    spring.data.neo4j.uri=bolt://localhost:7687 // your connection path
    spring.data.neo4j.username=neo4j            // database username
    spring.data.neo4j.password=secret           // database password

The value written in this example is the default connection. You actually don't have to write anything if you
use a default connection. Notice that Neo4j uses a [Bolt](https://en.wikipedia.org/wiki/Bolt_(network_protocol)) network protocol to connect. It will not except a http 
connection.

## NoSql Graph Database Overview

- why neo4j
- fast queries
- relations
- have properties
- good analytics


### Example of a social media schema
![graph](./images/graphDia.png)