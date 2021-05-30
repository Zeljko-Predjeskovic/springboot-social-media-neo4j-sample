package com.predjeskovic.neo4jrestapi.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;

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

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @GetMapping("/myLogin")
    public String myLogin(){
        return "login.html";
    }



}
