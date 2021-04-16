package com.starwars.client.service;

import com.starwars.client.exception.InformationNotFound;
import com.starwars.client.model.Film;
import com.starwars.client.proxy.StarWarsProxy;
import com.starwars.client.repository.FilmRepository;
import com.starwars.client.utils.StarWarsDataUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class FilmServiceTest {

    @Mock
    private StarWarsProxy starWarsProxy;

    @Mock
    private BaseStarWarsService baseStarWarsServiceTest;

    @InjectMocks
    private FilmService filmService;

    @Mock
    private FilmRepository filmRepository;

    @Before
    public void setup() {
        org.springframework.test.util.ReflectionTestUtils.setField(filmService, "film", "/films");
    }


    @Test
    public void loadBaseWithTwoCallApi(){

        Mockito.when(starWarsProxy.getEntityByPage(any(),any()))
                .thenReturn(StarWarsDataUtils.jsonFilmsNextPage())
                .thenReturn(StarWarsDataUtils.jsonFilmsOnePage());

        CompletableFuture<Void> completableFuture =  filmService.loadBaseFromService();

        Mockito.verify(filmRepository,times(2)).saveAll(any());
        Assert.isTrue(completableFuture.isDone(),"O job não terminou corretamente");
    }

    @Test
    public void loadBaseWithOneCallApi(){

        Mockito.when(starWarsProxy.getEntityByPage(any(),any()))
                .thenReturn(StarWarsDataUtils.jsonFilmsOnePage());

        CompletableFuture<Void> completableFuture =  filmService.loadBaseFromService();

        Mockito.verify(filmRepository,times(1)).saveAll(any());
        Assert.isTrue(completableFuture.isDone(),"O job não terminou corretamente");

    }

    @Test
    public void loadBaseError(){

        Mockito.when(starWarsProxy.getEntityByPage(any(),any()))
                .thenReturn("StarWarsDataUtils.jsonStarShipNextPage()");

        CompletableFuture<Void> completableFuture = filmService.loadBaseFromService();
        Assert.isTrue(completableFuture.isCompletedExceptionally(),"Eita... era para dar error!");
        Mockito.verify(filmRepository,times(0)).saveAll(any());

    }




}
