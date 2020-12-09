package com.softwaretest.retrogameshop.services;

import com.softwaretest.retrogameshop.models.Game;
import com.softwaretest.retrogameshop.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainInformationServiceImpl implements MainInformationService{

    private final GameRepository gameRepository;
    private final double AFA = 0.27;
    public MainInformationServiceImpl(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game addNewGame(Game game){
        game.setPrice(game.getPrice()+(int)(game.getPrice()*AFA));
        return gameRepository.save(game);
    }

}
