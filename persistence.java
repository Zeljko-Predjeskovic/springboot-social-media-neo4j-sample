/**
 * # Persistence
 *
 * The persistence is the cut between the database and the project.
 *
 *
 *
 */



@Repository
public interface PersonRepository extends Neo4jRepository<PersonNode,Long> {

    PersonNode findByUsername(String username);

    Optional<PersonNode> findOneByUsername(String username);

    /**
     * You can also make your own custom query:
     */
    @Query("MATCH (n:Person {username: $username}) RETURN n")
    PersonNode findByUsernameCustom(String username);

    void deleteById(Long id);

}

/**
 * ### Neo4j Cypher queries
 *
 * A great guide to learn cypher query language: https://neo4j.com/developer/cypher/
 *
 * Cypher query is a query langua for graphs. It is pretty simple and also fast.
 *
 * Query examples:
 *
 *      $ MATCH (n) RETURN n
 *
 * this one shows you alle the Nodes
 *
 * ---
 *
 *      $ MATCH (n)-[r]->(m) RETURN n,r,m
 *
 * shows all nodes with its relations
 *
 * ---
 *
 *      $ MATCH (n) RETURN n
 *
 * shows 25 nodes even if you have more.
 *
 * ---
 *
 *       $ CREATE (n:Person {name:"Laura"}) RETURN n
 *
 * creates a node name person with a property name.
 *
 * ---
 *
 *       $ MATCH (n:Person {name:"Laura"}) SET n.age=20 RETURN n
 *
 * or with WHERE
 *
 *       $ MATCH (n:Person) WHERE n.name="Laura" SET n.age=20 RETURN n
 *
 * finds person with the given name and updates it with a new age.
 *
 * ---
 *
 *       $ MATCH (n:Person {name:"Laura"}) REMOVE n
 *
 * deletes person with the given name.
 *
 * ---
 *
 *        $ MATCH (n:Person {name:"Laura"}), (m:Person {name:"Zeljko"}) MARGE (n)-[r:FRIENDS]->(b)
 *
 * creates a relation betweern two people.
 *
 *
 *
 *
 */
