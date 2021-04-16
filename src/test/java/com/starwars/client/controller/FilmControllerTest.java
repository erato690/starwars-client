package com.starwars.client.controller;

import com.starwars.client.exception.InformationNotFound;
import com.starwars.client.model.Film;
import com.starwars.client.service.FilmService;
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
public class FilmControllerTest {

    @InjectMocks
    private FilmController filmController;

    @Mock
    private FilmService filmService;


    @Test(expected = InformationNotFound.class)
    public void findFilmByQueryNotFound() throws Exception {

        Mockito.when(filmService.findByQuery(any(), any())).thenThrow(new InformationNotFound());
        filmController.findFilmByQuery(List.of("teste:teste"));
    }

    @Test(expected = NullPointerException.class)
    public void findFilmByQueryNull() throws Exception {

        filmController.findFilmByQuery(null);
    }

    @Test
    public void findFilmByQuery() throws Exception {

        Mockito.when(filmService.findByQuery(any(), any())).thenReturn(List.of(new Film()));
        List listReturn = filmController.findFilmByQuery(List.of("teste:teste"));

        Assertions.assertNotNull(listReturn);
        Assertions.assertFalse(listReturn.isEmpty());
    }

    @Test(expected = InformationNotFound.class)
    public void findFilmAllNotFound() throws Exception {

        Mockito.when(filmService.findAllWithLimit(any())).thenThrow(new InformationNotFound());
        filmController.findAllFilm();
    }

    @Test
    public void findFilmAll() throws Exception {

        Mockito.when(filmService.findAllWithLimit(any())).thenReturn(List.of(new Film()));
        List listReturn = filmController.findAllFilm();

        Assertions.assertNotNull(listReturn);
        Assertions.assertFalse(listReturn.isEmpty());
    }

}
