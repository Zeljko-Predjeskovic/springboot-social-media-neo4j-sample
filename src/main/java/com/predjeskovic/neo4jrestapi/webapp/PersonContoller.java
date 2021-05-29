package com.predjeskovic.neo4jrestapi.webapp;

import com.predjeskovic.neo4jrestapi.service.PersonNodeDto;
import com.predjeskovic.neo4jrestapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/people")
public class PersonContoller {

    private final PersonService personService;

    @Autowired
    public PersonContoller(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String people(Model model) {
        model.addAttribute("peopleList",personService.findAll());
        return "person/people.html";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("person", new PersonNodeDto());
        return "person/create.html";
    }

    @PostMapping("/create")
    public String creatAction(@ModelAttribute PersonNodeDto person, Model model){
        personService.insert(person);
        return "redirect:/web/people";
    }

}
