package com.starwars.client.controller;

import com.starwars.client.exception.SingleLoadRequestAsync;
import com.starwars.client.service.FilmService;
import com.starwars.client.service.StarShipService;
import com.starwars.client.service.async.ExecuteSingleAsyncRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletableFuture;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseLoadControllerTest {

    @InjectMocks
    private DatabaseLoadController databaseLoadController;

    @Spy
    private ExecuteSingleAsyncRequest executeSingleAsyncRequest;

    @Mock
    private StarShipService starShipService;


    @Mock
    private FilmService filmService;


    @Before
    public void setup(){

        Mockito.when(starShipService.loadBaseFromService()).thenAnswer( response -> {
            return CompletableFuture.runAsync(() ->{
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        Mockito.when(filmService.loadBaseFromService()).thenAnswer( response -> {
            return CompletableFuture.runAsync(() ->{
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
    }


    @Test
    public void filmLoad() throws Exception {
        ResponseEntity responseEntity = databaseLoadController.loadMoviesTheDatabase();
        Assert.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void startShipLoad() throws Exception {
        ResponseEntity responseEntity = databaseLoadController.loadStarShipInDatabase();
        Assert.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
    }


    @Test(expected = SingleLoadRequestAsync.class)
    public void startShipLoadOneTaskExecuting() throws Exception {
        databaseLoadController.loadStarShipInDatabase();
        databaseLoadController.loadStarShipInDatabase();

    }

    @Test(expected = SingleLoadRequestAsync.class)
    public void filmLoadOneTaskExecuting() throws Exception {
        databaseLoadController.loadMoviesTheDatabase();
        databaseLoadController.loadMoviesTheDatabase();

    }


}
