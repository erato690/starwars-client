package com.starwars.client.controller;

import com.starwars.client.model.Film;
import com.starwars.client.service.FilmService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService movieService;

    @ApiOperation(value = "Faz uma busca no banco de acordo com os parametros passados .")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Solicitação foi processada."),
            @ApiResponse(code = 404, message = "Não existe o item."),
            @ApiResponse(code = 500, message = "Erro na consulta")
    })
    @GetMapping(value = "/{query}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Film> findFilmByQuery(@NonNull @RequestParam("query")List<String> query){
        log.info("Inicio da pesquisa por query  query={}.",query);
        List<Film> listFilm =  movieService.findByQuery(query,Film.class);
        log.info("Fim da pesquisa  por query  query={}.",query);
        return listFilm;
    }

    @ApiOperation(value = "Faz uma busca no banco de acordo com os parametros passados .")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Solicitação foi processada."),
            @ApiResponse(code = 404, message = "Não existe o item."),
            @ApiResponse(code = 500, message = "Erro na consulta")
    })
    @GetMapping(value = "/",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Film> findAllFilm(){
        log.info("Inicio da pesquisa por todos");
        List<Film> listFilm =  movieService.findAllWithLimit(Film.class);
        log.info("Fim da pesquisa por todos");
        return listFilm;
    }



}
