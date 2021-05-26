package com.predjeskovic.neo4jrestapi.service;

import com.predjeskovic.neo4jrestapi.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service @Transactional
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonNodeDto> findAll(){
        return StreamSupport.stream(personRepository.findAll().spliterator(), false)
                .map(PersonNodeDto::fromPersonNode)
                .collect(Collectors.toList());
    }
}
