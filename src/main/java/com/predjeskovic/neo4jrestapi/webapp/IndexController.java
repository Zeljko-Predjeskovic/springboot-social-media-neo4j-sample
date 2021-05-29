package com.predjeskovic.neo4jrestapi.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        return "index.html";
    }

    @GetMapping("/start")
    public String getStarted(Model model) {
        return "start.html";
    }


}
