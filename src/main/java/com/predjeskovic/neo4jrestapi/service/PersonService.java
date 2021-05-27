package com.predjeskovic.neo4jrestapi.service;

import com.predjeskovic.neo4jrestapi.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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

    public PersonNodeDto findOne(String username){
        return personRepository.findOneByUsername(username)
                .map(PersonNodeDto::fromPersonNode)
                .orElse(null);
    }

    public PersonNodeDto insert(PersonNodeDto personDto){
        var person = Optional.ofNullable(personDto)
                .map(PersonNodeDto::toPersonNode)
                .map(personRepository::save)
                .map(PersonNodeDto::fromPersonNode)
                .orElse(null);

        return person;
    }

    public PersonNodeDto replace(String username, PersonNodeDto personDto){
        var updatedPerson = Optional.ofNullable(username)
                .flatMap(it -> personRepository.findOneByUsername(it))
                .map(person -> personDto.mergeWith(person))
                .map(personRepository::save)
                .map(PersonNodeDto::fromPersonNode)
                .orElse(null);

        return updatedPerson;
    }

    public  void delete (String username){
        var person = personRepository.findOneByUsername(username);
        personRepository.deleteById(person.get().getId());
    }
}
