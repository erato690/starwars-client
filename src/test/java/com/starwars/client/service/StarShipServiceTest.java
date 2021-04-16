package com.starwars.client.service;

import com.starwars.client.proxy.StarWarsProxy;
import com.starwars.client.repository.StarShipRepository;
import com.starwars.client.utils.StarWarsDataUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;

import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class StarShipServiceTest {

    @Mock
    private StarWarsProxy starShipProxy;

    @InjectMocks
    private StarShipService starShipService;

    @Mock
    private StarShipRepository starShipRepository;

    @Before
    public void setup() {
        org.springframework.test.util.ReflectionTestUtils.setField(starShipService, "starShipUrl", "/starship");
    }


    @Test
    public void loadBaseWithTwoCallApi(){

        Mockito.when(starShipProxy.getEntityByPage(any(),any()))
                .thenReturn(StarWarsDataUtils.jsonStarShipNextPage())
                .thenReturn(StarWarsDataUtils.jsonStarShipOnePage());

        starShipService.loadBaseFromService();

        Mockito.verify(starShipRepository,times(2)).saveAll(any());
    }

    @Test
    public void loadBaseWithOneCallApi(){

        Mockito.when(starShipProxy.getEntityByPage(any(),any()))
                .thenReturn(StarWarsDataUtils.jsonStarShipOnePage());

        starShipService.loadBaseFromService();

        Mockito.verify(starShipRepository,times(1)).saveAll(any());

    }

    @Test
    public void loadBaseError(){

        Mockito.when(starShipProxy.getEntityByPage(any(),any()))
                .thenReturn("StarWarsDataUtils.jsonStarShipNextPage()");

        CompletableFuture<Void>  completableFuture = starShipService.loadBaseFromService();
        Assert.isTrue(completableFuture.isCompletedExceptionally(),"Eita... era para dar error!");

    }
}
