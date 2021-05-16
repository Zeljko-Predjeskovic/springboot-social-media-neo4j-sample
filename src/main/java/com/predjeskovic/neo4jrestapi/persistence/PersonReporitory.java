package com.predjeskovic.neo4jrestapi.persistence;

import com.predjeskovic.neo4jrestapi.domain.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface PersonReporitory extends Neo4jRepository<Person,Long> {

    Person findByLastName(String Lastname);

}
