package com.softwaretest.retrogameshop.controllers.rest;

import com.softwaretest.retrogameshop.controllers.dtos.DTOGame;
import com.softwaretest.retrogameshop.controllers.dtos.DTOGameTransformer;
import com.softwaretest.retrogameshop.models.Game;
import com.softwaretest.retrogameshop.services.MainInformationService;
import com.softwaretest.retrogameshop.services.MainInformationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainRestController {

    private final MainInformationServiceImpl mainInformationService;

    public MainRestController(MainInformationServiceImpl mainInformationService){
        this.mainInformationService = mainInformationService;
    }

    @GetMapping("/rest/all-games")
    public ResponseEntity<List<DTOGame>> getAllGames(){
        List<Game> games = mainInformationService.getAllGames();
        List<DTOGame> dtoGames = new ArrayList<>();
        for(Game game : games){
            dtoGames.add(DTOGameTransformer.transformGameToDTOGame(game));
        }
        if(games == null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(dtoGames);
        }
    }

    @PostMapping("rest/add-game")
    public ResponseEntity<Game> addNewGame(DTOGame dtoGame){
        Game game = DTOGameTransformer.transformDTOGameToGame(dtoGame);
        Game recordedGame = mainInformationService.addNewGame(game);
        if(recordedGame == null){
            return ResponseEntity.unprocessableEntity().build();
        }
        else{
            return ResponseEntity.ok(recordedGame);
        }
    }
}
