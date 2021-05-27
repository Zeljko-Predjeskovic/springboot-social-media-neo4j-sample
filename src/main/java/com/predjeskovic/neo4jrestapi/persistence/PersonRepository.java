package com.predjeskovic.neo4jrestapi.persistence;

import com.predjeskovic.neo4jrestapi.domain.PersonNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PersonRepository extends Neo4jRepository<PersonNode,Long> {

    @Query("MATCH (n:Person) RETURN n")
    List<PersonNode> findAllPeople(); //Relations werden nicht mitgenommen

    PersonNode findByUsername(String username);

    Optional<PersonNode> findOneByUsername(String username);

    @Query("MATCH (n:Person {username: $username}) RETURN n")
    PersonNode findByUsernameCustom(String username);

    void deleteById(Long id);

}
