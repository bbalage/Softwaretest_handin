package com.softwaretest.retrogameshop.repositories;

import com.softwaretest.retrogameshop.models.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private GameRepository gameRepository;

    @Test
    public void addPlainGame(){
        Game game = new Game("Doom", 1993, "Action, horror");
        System.out.println("It works!");
        gameRepository.save(game);
        //game.setGenre("Romantic");
        List<Game> games = gameRepository.findAll();
        assert games.get(0).getTitle().equals(game.getTitle());
        assert games.get(0).getGenre().equals(game.getGenre());
        assert games.get(0).getReleaseYear().equals(game.getReleaseYear());
        assert games.size() == 1;
    }
}
