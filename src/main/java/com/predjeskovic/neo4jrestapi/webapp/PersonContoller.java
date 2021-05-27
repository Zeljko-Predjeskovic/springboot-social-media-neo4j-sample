package com.predjeskovic.neo4jrestapi.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class PersonContoller {

    @RequestMapping("/people")
    public String people(Model modes) {
        return "person/people.html";
    }

}
