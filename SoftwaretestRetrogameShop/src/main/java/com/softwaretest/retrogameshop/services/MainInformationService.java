package com.softwaretest.retrogameshop.services;

import com.softwaretest.retrogameshop.exceptions.RecordWasAlreadyInRepository;
import com.softwaretest.retrogameshop.models.Game;

import java.util.List;

public interface MainInformationService {

    public List<Game> getAllGames();
    public Game addNewGame(Game game);
}
