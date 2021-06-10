package com.predjeskovic.socialmedia.service;

import com.predjeskovic.socialmedia.exceptions.PersonServiceException;
import com.predjeskovic.socialmedia.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service @Transactional(rollbackFor = PersonServiceException.class)
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

    public PersonNodeDto findOne(String username) {
        if(username==null || username.isEmpty()){
            throw new PersonServiceException("Username cannot be null or empty!!");
        }
        else{
            try {
                return personRepository.findOneByUsername(username)
                        .map(PersonNodeDto::fromPersonNode)
                        .orElse(null);
            }
            catch (Exception e){
                throw new PersonServiceException("User could not be found.",e);
            }
        }
    }

    public PersonNodeDto findOneByEmail(String email) {
        if(email==null || email.isEmpty()){
            throw new PersonServiceException("Email cannot be null or empty!!");
        }
        else{
            try {
                return personRepository.findOneByUsername(email)
                        .map(PersonNodeDto::fromPersonNode)
                        .orElse(null);
            }
            catch (Exception e){
                throw new PersonServiceException("Email could not be found.",e);
            }
        }
    }

    public PersonNodeDto insert(PersonNodeDto personDto){
        if(findOne(personDto.getUsername())!=null || findOneByEmail(personDto.getEmail())!=null){
            throw new PersonServiceException("User or email already exists!!");
        }
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
