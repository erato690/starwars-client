package com.starwars.client.controller;

import com.starwars.client.exception.InformationNotFound;
import com.starwars.client.model.Starship;
import com.starwars.client.model.Starship;
import com.starwars.client.service.StarShipService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class StarShipControllerTest {

    @InjectMocks
    private StarShipController starShipController;

    @Mock
    private StarShipService starShipService;


    @Test(expected = InformationNotFound.class)
    public void findStarShipByQueryNotFound() throws Exception {

        Mockito.when(starShipService.findByQuery(any(), any())).thenThrow(new InformationNotFound());
        starShipController.findStarShipByQuery(List.of("teste:teste"));
    }

    @Test(expected = NullPointerException.class)
    public void findStarShipByQueryNull() throws Exception {

        starShipController.findStarShipByQuery(null);
    }

    @Test
    public void findStarShipByQuery() throws Exception {

        Mockito.when(starShipService.findByQuery(any(), any())).thenReturn(List.of(new Starship()));
        List listReturn = starShipController.findStarShipByQuery(List.of("teste:teste"));

        Assertions.assertNotNull(listReturn);
        Assertions.assertFalse(listReturn.isEmpty());
    }

    @Test(expected = InformationNotFound.class)
    public void findStarshipAllNotFound() throws Exception {

        Mockito.when(starShipService.findAllWithLimit(any())).thenThrow(new InformationNotFound());
        starShipController.findAllStarShip();
    }

    @Test
    public void findStarshipAll() throws Exception {

        Mockito.when(starShipService.findAllWithLimit(any())).thenReturn(List.of(new Starship()));
        List listReturn = starShipController.findAllStarShip();

        Assertions.assertNotNull(listReturn);
        Assertions.assertFalse(listReturn.isEmpty());
    }

}
