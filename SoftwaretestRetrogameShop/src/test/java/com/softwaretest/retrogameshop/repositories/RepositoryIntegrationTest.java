package com.softwaretest.retrogameshop.repositories;

import com.softwaretest.retrogameshop.models.Customer;
import com.softwaretest.retrogameshop.models.Game;
import com.softwaretest.retrogameshop.repositories.GameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void addPlainGame(){
        Game game = new Game("Doom", 1993, "Action, horror", 3000);
        gameRepository.save(game);
        //game.setGenre("Romantic");
        List<Game> games = gameRepository.findAll();
        assert games.get(0).getTitle().equals(game.getTitle());
        assert games.get(0).getGenre().equals(game.getGenre());
        assert games.get(0).getReleaseYear().equals(game.getReleaseYear());
        assert games.size() == 1;
    }

    @Test
    public void addPlainCustomers(){
        Customer customer1 = new Customer("Bolyki Balázs", "Ózd", "+36303083030");
        Customer customer2 = new Customer("Alex Twin", "Iceland", "+36301234567");
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        List<Customer> customers = customerRepository.findAll();
        assert customers.size() == 2;
        assert customers.get(0).getName().equals(customer1.getName()) || customers.get(1).getName().equals(customer1.getName());
    }

    @Test
    public void addRelationship(){
        Game game1 = new Game("Doom", 1993, "Action, horror", 3000);
        Game game2 = new Game("Pacman", 1980, "Skill", 500);
        Customer customer1 = new Customer("Bolyki Balázs", "Ózd", "+36303083030");
        Customer customer2 = new Customer("Alex Twin", "Iceland", "+36301234567");
        List<Game> purchases = new ArrayList<>();
        purchases.add(game1);
        customer1.setPurchases(purchases);
        gameRepository.save(game1);
        gameRepository.save(game2);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        List<Game> games = gameRepository.findGamesWithPurchaser();
        assert games.size() == 1;
        assert games.get(0).getTitle() == game1.getTitle();
    }
}
