package com.softwaretest.retrogameshop.services;

import com.softwaretest.retrogameshop.exceptions.RecordWasAlreadyInRepository;
import com.softwaretest.retrogameshop.models.Game;
import com.softwaretest.retrogameshop.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainInformationServiceImpl implements MainInformationService{

    private final GameRepository gameRepository;

    public MainInformationServiceImpl(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game addNewGame(Game game){
        return gameRepository.save(game);
    }

}
