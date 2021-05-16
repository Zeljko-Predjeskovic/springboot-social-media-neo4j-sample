package com.predjeskovic.neo4jrestapi.Persistence;

import com.predjeskovic.neo4jrestapi.Domain.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface PersonReporitory extends Neo4jRepository<Person,Long> {

    Person findByLastName(String Lastname);

}
