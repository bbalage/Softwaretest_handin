package com.softwaretest.retrogameshop.controllers.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softwaretest.retrogameshop.controllers.dtos.DTOGame;
import com.softwaretest.retrogameshop.services.MainInformationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MainRestController.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MainRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MainInformationServiceImpl mainInformationService;

    //Test if HTTP request sent matches what the controller expects
    @Test
    public void httpSyntaxCheckOnAllGamesTest() throws Exception{
        mockMvc.perform(get("/rest/all-games")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    //Test if data is serialized as expected.
    @Test
    public void serializationCheckOnAddNewGame() throws Exception{
        DTOGame dtoGame = new DTOGame("Super Mario", 1985, "Adventure");
        mockMvc.perform(post("/rest/add-game")
                .with(user("n5if3v").roles("USER"))
                .with(csrf())
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(dtoGame)))
                .andExpect(status().isUnprocessableEntity());
    }

    //Test if invalid data is refused with the expected error code.
    @Test
    public void serializationCheckValidationOfAddNewGame() throws Exception{
        DTOGame dtoGame = new DTOGame(null, 1985, "Adventure");
        mockMvc.perform(post("/rest/add-game")
                .with(user("n5if3v").roles("USER"))
                .with(csrf())
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(dtoGame)))
                .andExpect(status().isBadRequest());
    }

    /*@Test
    public void businessLogicCalled() throws Exception{
        DTOGame dtoGame = new DTOGame("Super Mario", 1985, "Adventure");
        mockMvc.perform(post("/rest/add-game")
                .with(user("n5if3v").roles("USER"))
                .with(csrf())
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(dtoGame)))
                .andExpect(status().isUnprocessableEntity());

        ArgumentCaptor<DTOGame> dtoGameCaptor = ArgumentCaptor.forClass(DTOGame.class);
        verify(mainInformationService, times(1))
                .addNewGame(dtoGameCaptor.capture());
    }*/
}
