package com.softwaretest.retrogameshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String hello(){
        return "hello";
    }

    @GetMapping("/allGames")
    public String listGames(Model model){

        return "allGames";
    }
}
