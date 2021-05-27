package com.predjeskovic.neo4jrestapi.presentation;

import com.predjeskovic.neo4jrestapi.service.PersonNodeDto;
import com.predjeskovic.neo4jrestapi.service.PersonService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PersonController.PERSON_ROUTE)
public class PersonController {

    public static final String PERSON_ROUTE = "/people";

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonNodeDto> findAll(){
        return personService.findAll();
    }

    @GetMapping("/{username}")
    public PersonNodeDto findOne(@PathVariable @NonNull String username){
        return  personService.findOne(username);
    }


}
