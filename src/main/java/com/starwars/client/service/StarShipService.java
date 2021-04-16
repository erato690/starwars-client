package com.starwars.client.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.starwars.client.model.StarWarsApiReturn;
import com.starwars.client.model.Starship;
import com.starwars.client.proxy.StarWarsProxy;
import com.starwars.client.repository.StarShipRepository;
import com.starwars.client.utils.StarWarsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class StarShipService extends  BaseStarWarsService<Starship>{

    @Autowired
    private StarWarsProxy starShipProxy;

    @Value("${api.client.starwars.starship}")
    private String starShipUrl;

    @Autowired
    private StarShipRepository starShipRepository;


    @Async
    public CompletableFuture<Void> loadBaseFromService(){

        log.info("inicio  carga de base starship.");
        try {
            int pageCount =1;

            StarWarsApiReturn<Starship> page = null;
            do {
                page = getPageable(pageCount,starShipUrl,new TypeReference<StarWarsApiReturn<Starship>>(){});

                page.getResults().stream().forEach(starShip -> {
                    starShip.setId(StarWarsUtils.id(starShip.getUrl()));
                });
                starShipRepository.saveAll(page.getResults());
                pageCount+=1;
            }while(page != null && page.hasNext());
        }catch (Exception ex){
            log.error("Erro para carregar os itens no banco.",ex);
            return CompletableFuture.failedFuture(ex);
        }finally {
            log.info("fim  carga de base starship.");
        }

        return CompletableFuture.completedFuture(null);
    }


}
