package com.predjeskovic.socialmedia.webapp;

import com.predjeskovic.socialmedia.service.PersonNodeDto;
import com.predjeskovic.socialmedia.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/people")
public class WebPersonController {

    private final PersonService personService;

    @Autowired
    public WebPersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String people(Model model) {
        model.addAttribute("peopleList",personService.findAll());
        model.addAttribute("reqPerson", new PersonNodeDto());
        return "person/people";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("person", new PersonNodeDto());
        return "person/create";
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
        return "person/detail";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value = "username") String username, Model model){
        PersonNodeDto person = personService.findOne(username);
        model.addAttribute("person", person);
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
