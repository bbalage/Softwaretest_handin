package com.softwaretest.retrogameshop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softwaretest.retrogameshop.controllers.dtos.DTOGame;
import com.softwaretest.retrogameshop.models.Game;
import com.softwaretest.retrogameshop.repositories.GameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RetroGameShopApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GameRepository gameRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void addNewGameWorksThroughAllLayers() throws Exception{
        DTOGame dtoGame = new DTOGame("Pacman", 1980, "Skill", 500);

        mockMvc.perform(post("/rest/add-game")
                .with(user("n5if3v").roles("USER"))
                .with(csrf())
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(dtoGame)))
                .andExpect(status().isOk());

        List<Game> games = gameRepository.findAll();
        assert games.size() == 1;
        Game game = games.get(0);
        assert game.getTitle().equals(dtoGame.getTitle());
        assert game.getReleaseYear().equals(dtoGame.getReleaseYear());
        assert game.getGenre().equals(dtoGame.getGenre());
    }

}
