package com.starwars.client.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.starwars.client.model.Film;
import com.starwars.client.model.StarWarsApiReturn;
import com.starwars.client.proxy.StarWarsProxy;
import com.starwars.client.repository.FilmRepository;
import com.starwars.client.utils.StarWarsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FilmService  extends  BaseStarWarsService{

    @Autowired
    private StarWarsProxy filmProxy;

    @Value("${api.client.starwars.films}")
    private String film;

    @Autowired
    private FilmRepository filmRepository;

    @Async
    public CompletableFuture<Void> loadBaseFromService(){

        log.info("inicio  carga de base films.");
        try {
            int pageCount =1;
            StarWarsApiReturn<Film> page = null;
            do {
                page = getPageable(pageCount,film,new TypeReference<StarWarsApiReturn<Film>>(){});
                List<Film> listFilms = page.getResults()
                        .stream()
                        .peek(film -> {
                            film.setId(StarWarsUtils.id(film.getUrl()));
                            film.setStarships(film.getStarships()
                                    .stream()
                                    .map(url -> StarWarsUtils.id(url))
                                    .collect(Collectors.toList()));
                        }).collect(Collectors.toList());

               filmRepository.saveAll(listFilms);
                pageCount+=1;
            }while(page != null && page.hasNext());
        }catch (Exception ex){
            log.error("Erro para carregar os itens no banco.",ex);
            return CompletableFuture.failedFuture(ex);
        }finally {
            log.info("fim  carga de base films.");
        }
        return CompletableFuture.completedFuture(null);
    }


}
