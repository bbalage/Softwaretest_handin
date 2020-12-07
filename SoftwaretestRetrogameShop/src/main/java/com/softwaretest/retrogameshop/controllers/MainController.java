package com.softwaretest.retrogameshop.controllers;

import com.softwaretest.retrogameshop.models.Game;
import com.softwaretest.retrogameshop.services.MainInformationService;
import com.softwaretest.retrogameshop.services.MainInformationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    private final MainInformationServiceImpl mainInformationService;

    public MainController(MainInformationServiceImpl mainInformationService){
        this.mainInformationService = mainInformationService;
    }

    @RequestMapping("/")
    public String hello(){
        return "hello";
    }

    @GetMapping("/allGames")
    public String listGames(Model model){
        List<Game> games = mainInformationService.getAllGames();
        model.addAttribute("games", games);
        return "allGames";
    }
}
