package com.starwars.client.proxy;

import com.starwars.client.exception.StarWarsException;
import com.starwars.client.utils.StarWarsDataUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class StarWarsProxyTest {

    @InjectMocks
    private StarWarsProxy staShipProxy;

    @Mock
    private RestTemplate restTemplate;


    @Before
    public void setup() {
        org.springframework.test.util.ReflectionTestUtils.setField(staShipProxy, "host", "https://swapi.dev/api");
    }

    @Test
    public void getStarShipsByPageSuccess(){

        Mockito.when(restTemplate.exchange("https://swapi.dev/api/starships?page=1", HttpMethod.GET,null,String.class))
                .thenReturn(new ResponseEntity<String>(StarWarsDataUtils.jsonStarShipNextPage(), HttpStatus.OK));

        String starShip = staShipProxy.getEntityByPage(1,"/starships");
        Assert.assertNotNull(starShip);
        Assert.assertEquals(StarWarsDataUtils.jsonStarShipNextPage(),starShip);
    }

    @Test(expected = StarWarsException.class)
    public void getStarShipsByPageBadRequest(){

        Mockito.when(restTemplate.exchange("https://swapi.dev/api/starships?page=1", HttpMethod.GET,null,String.class))
                .thenReturn(new ResponseEntity<String>("Erro na comunicação", HttpStatus.BAD_REQUEST));

        staShipProxy.getEntityByPage(1,"/starships");
    }


    @Test
    public void getStarShipSingleEntityByParamSuccess(){

        Mockito.when(restTemplate.exchange("https://swapi.dev/api/starships?search=CR90%20corvette", HttpMethod.GET,null,String.class))
                .thenReturn(new ResponseEntity<String>(StarWarsDataUtils.jsonStarShipOnePage(), HttpStatus.OK));

        String starShip = staShipProxy.getSingleEntityBySearchParam("CR90 corvette","/starships");
        Assert.assertNotNull(starShip);
        Assert.assertEquals(StarWarsDataUtils.jsonStarShipOnePage(),starShip);
    }

    @Test(expected = StarWarsException.class)
    public void getStarShipSingleEntityByParamBadRequest(){

        Mockito.when(restTemplate.exchange("https://swapi.dev/api/starships?search=CR90%20corvette", HttpMethod.GET,null,String.class))
                .thenReturn(new ResponseEntity<String>("Erro na comunicação", HttpStatus.BAD_REQUEST));

        staShipProxy.getSingleEntityBySearchParam("CR90 corvette","/starships");
    }


    @Test
    public void getStarShipsByUrlSuccess(){

        String url = "https://swapi.dev/api/starships/1";

        Mockito.when(restTemplate.exchange(url, HttpMethod.GET,null,String.class))
                .thenReturn(new ResponseEntity<String>(StarWarsDataUtils.jsonStarShipOnePage(), HttpStatus.OK));

        String starShip = staShipProxy.getSingleEntityByURL(url);
        Assert.assertNotNull(starShip);
        Assert.assertEquals(StarWarsDataUtils.jsonStarShipOnePage(),starShip);
    }

    @Test(expected = StarWarsException.class)
    public void getStarShipsByUrlBadRequest(){

        String url = "https://swapi.dev/api/starships/1";

        Mockito.when(restTemplate.exchange(url, HttpMethod.GET,null,String.class))
                .thenReturn(new ResponseEntity<String>("Erro na comunicação", HttpStatus.BAD_REQUEST));

        staShipProxy.getSingleEntityByURL(url);
    }

}
