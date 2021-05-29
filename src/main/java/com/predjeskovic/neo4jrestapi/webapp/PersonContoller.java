package com.predjeskovic.neo4jrestapi.webapp;

import com.predjeskovic.neo4jrestapi.service.PersonNodeDto;
import com.predjeskovic.neo4jrestapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("reqPerson", new PersonNodeDto());
        return "person/people.html";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("person", new PersonNodeDto());
        return "person/create.html";
    }

    @PostMapping("/create")
    public String creatAction(@ModelAttribute PersonNodeDto person){
        personService.insert(person);
        return "redirect:/web/people";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(value = "username") String username,Model model){
        PersonNodeDto person = personService.findOne(username);
        model.addAttribute("person",person);
        return "person/detail.html";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value = "username") String username, Model model){
        PersonNodeDto person = personService.findOne(username);
        model.addAttribute("person", person);
        model.addAttribute("newPerson", new PersonNodeDto());
        return "person/edit.html";
    }

    @PostMapping("/edit")
    public String editAction(@RequestParam(value = "OldUsername") String username,
                             @ModelAttribute PersonNodeDto person){
        personService.replace(username,person);
        return "redirect:/web/people";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "username") String username,Model model){
        PersonNodeDto person = personService.findOne(username);
        model.addAttribute("person", person);
        return "person/delete.html";
    }

    @GetMapping ("/deleteAction")
    public String deleteAction(@RequestParam(value = "username") String username){
        personService.delete(username);
        return "redirect:/web/people";
    }
}
