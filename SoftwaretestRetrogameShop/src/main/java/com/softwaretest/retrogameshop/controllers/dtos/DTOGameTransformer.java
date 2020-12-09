package com.softwaretest.retrogameshop.controllers.dtos;

import com.softwaretest.retrogameshop.models.Customer;
import com.softwaretest.retrogameshop.models.Game;
import com.softwaretest.retrogameshop.services.MainInformationService;

import java.util.ArrayList;
import java.util.List;

public class DTOGameTransformer {

    public static Game transformDTOGameToGame(DTOGame dtoGame){
        Game game = new Game(
                dtoGame.getTitle(),
                dtoGame.getReleaseYear(),
                dtoGame.getGenre(),
                dtoGame.getPrice()
        );
        return game;
    }

    public static DTOGame transformGameToDTOGame(Game game){
        List<Long> foreignIds = new ArrayList<Long>();
        for(Customer customer : game.getPurchases()){
            foreignIds.add(customer.getId());
        }
        DTOGame dtoGame = new DTOGame(
                game.getId(),
                game.getTitle(),
                game.getReleaseYear(),
                game.getGenre(),
                game.getPrice(),
                foreignIds
        );
        return dtoGame;
    }
}
