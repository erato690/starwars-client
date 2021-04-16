package com.starwars.client.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.starwars.client.exception.InformationNotFound;
import com.starwars.client.exception.StarWarsException;
import com.starwars.client.model.Film;
import com.starwars.client.model.StarWarsApiReturn;
import com.starwars.client.model.Starship;
import com.starwars.client.proxy.StarWarsProxy;
import com.starwars.client.repository.StarWarsCustomRepository;
import com.starwars.client.utils.StarWarsDataUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;


@RunWith(MockitoJUnitRunner.class)
public class BaseStarWarsServiceTest {

    @Mock
    private StarWarsProxy starWarsProxy;

    @Spy
    private BaseStarWarsService baseStarWarsService;

    @Mock
    private StarWarsCustomRepository starWarsCustomRepository;

    @Before
    public void setup(){
        org.springframework.test.util.ReflectionTestUtils.setField(baseStarWarsService, "starWarsProxy", starWarsProxy);
        org.springframework.test.util.ReflectionTestUtils.setField(baseStarWarsService, "starWarsCustomRepository", starWarsCustomRepository);
    }

    @Test
    public void findFilmNextPage() {

        Mockito.when(starWarsProxy.getEntityByPage(any(), any()))
                .thenReturn(StarWarsDataUtils.jsonFilmsNextPage())
                .thenReturn(StarWarsDataUtils.jsonFilmsOnePage());

        StarWarsApiReturn<Film> film = baseStarWarsService.getPageable(1, "/films", new TypeReference<StarWarsApiReturn<Film>>() {
        });

        Assert.notNull(film, "erro na conversão do json no objeto de consulta");
        Assert.notNull(film.getResults(), "erro na conversão do json no objeto de filme");
        Assert.notEmpty(film.getResults(), "Não retornou nenhuma filme");
    }

    @Test
    public void findFilmOnePage() {

        Mockito.when(starWarsProxy.getEntityByPage(any(), any())).thenReturn(StarWarsDataUtils.jsonFilmsOnePage());

        StarWarsApiReturn<Film> film = baseStarWarsService.getPageable(1, "/films", new TypeReference<StarWarsApiReturn<Film>>() {
        });

        Assert.notNull(film, "erro na conversão do json no objeto de consulta");
        Assert.notNull(film.getResults(), "erro na conversão do json no objeto de filme");
        Assert.notEmpty(film.getResults(), "Não retornou nenhuma filme");
    }

    @Test(expected = StarWarsException.class)
    public void findFilmParseError() {
        Mockito.when(starWarsProxy.getEntityByPage(any(), any())).thenReturn("StarWarsDataUtils.jsonStarShipNextPage()");
        baseStarWarsService.getPageable(1, "/films", new TypeReference<StarWarsApiReturn<Film>>() {
        });
    }


    @Test
    public void finStarShipNextPage() {

        Mockito.when(starWarsProxy.getEntityByPage(any(), any()))
                .thenReturn(StarWarsDataUtils.jsonStarShipNextPage())
                .thenReturn(StarWarsDataUtils.jsonStarShipOnePage());

        StarWarsApiReturn<Starship> starShip = baseStarWarsService.getPageable(1, "/starship", new TypeReference<StarWarsApiReturn<Starship>>() {
        });

        Assert.notNull(starShip, "erro na conversão do json no objeto de consulta");
        Assert.notNull(starShip.getResults(), "erro na conversão do json no objeto de nave");
        Assert.notEmpty(starShip.getResults(), "Não retornou nenhuma nave");
    }

    @Test
    public void findStarShipOnePage() {

        Mockito.when(starWarsProxy.getEntityByPage(any(), any())).thenReturn(StarWarsDataUtils.jsonStarShipOnePage());

        StarWarsApiReturn<Starship> starShip = baseStarWarsService.getPageable(1, "/starship", new TypeReference<StarWarsApiReturn<Starship>>() {
        });

        Assert.notNull(starShip, "erro na conversão do json no objeto de consulta");
        Assert.notNull(starShip.getResults(), "erro na conversão do json no objeto de nave");
        Assert.notEmpty(starShip.getResults(), "Não retornou nenhuma nave");
    }

    @Test(expected = StarWarsException.class)
    public void findStarShipParseError() {
        Mockito.when(starWarsProxy.getEntityByPage(any(), any())).thenReturn("StarWarsDataUtils.jsonStarShipNextPage()");
        baseStarWarsService.getPageable(1, "/starship", new TypeReference<StarWarsApiReturn<Starship>>() {
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByQueryNullQueryParam(){
        baseStarWarsService.findByQuery(null,Film.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByQueryNullQueryClass(){
        baseStarWarsService.findByQuery(List.of(),null);
    }

    @Test
    public void findByQueryFilm(){

        Mockito.when(starWarsCustomRepository.findByQuery(any(),any())).thenReturn(List.of());

        baseStarWarsService.findByQuery(List.of("teste=teste"),Film.class);

        Mockito.verify(starWarsCustomRepository,times(1)).findByQuery(any(),any());
    }

    @Test(expected = InformationNotFound.class)
    public void findByQueryNotFound(){

        Mockito.when(starWarsCustomRepository.findByQuery(any(),any())).thenThrow( new InformationNotFound(""));

        baseStarWarsService.findByQuery(List.of("teste=teste"),Film.class);
    }



    @Test
    public void findByAllWithLimit(){

        Mockito.when(starWarsCustomRepository.findAllWithLimit(any())).thenReturn(List.of());

        baseStarWarsService.findAllWithLimit(Film.class);

        Mockito.verify(starWarsCustomRepository,times(1)).findAllWithLimit(any());
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByAllWithLimitNullClass(){

        baseStarWarsService.findAllWithLimit(null);

        Mockito.verify(starWarsCustomRepository,times(0)).findAllWithLimit(any());
    }

    @Test(expected = InformationNotFound.class)
    public void findByAllWithLimitNotFound(){

        Mockito.when(starWarsCustomRepository.findAllWithLimit(any())).thenThrow( new InformationNotFound(""));

        baseStarWarsService.findAllWithLimit(Film.class);

        Mockito.verify(starWarsCustomRepository,times(0)).findAllWithLimit(any());
    }




}
