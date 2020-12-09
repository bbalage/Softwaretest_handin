package com.softwaretest.retrogameshop.services;

import com.softwaretest.retrogameshop.exceptions.RecordWasAlreadyInRepository;
import com.softwaretest.retrogameshop.models.Game;
import com.softwaretest.retrogameshop.repositories.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;


public class MainInformationServiceTest {

    private GameRepository gameRepository = Mockito.mock(GameRepository.class);

    private MainInformationServiceImpl mainInformationService;

    @BeforeEach
    public void createService(){
        this.mainInformationService = new MainInformationServiceImpl(gameRepository);
    }

    @Test
    public void savingNewGamesWork() {
        Game game = new Game("Doom 3", 2004, "Horror", 4000);
        when(gameRepository.save(any(Game.class))).then(returnsFirstArg());
        Game savedGame = mainInformationService.addNewGame(game);
        assertThat(savedGame.getPrice().equals(game.getPrice()+game.getPrice()*0.27));
        assertThat(savedGame.getGenre().equals(game.getGenre()));
        assertThat(savedGame.getReleaseYear().equals(game.getReleaseYear()));
        assertThat(savedGame.getTitle().equals(game.getTitle()));
    }
}
