package com.starwars.client.controller;

import com.starwars.client.model.Starship;
import com.starwars.client.service.StarShipService;
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
@RequestMapping("/starShip")
public class StarShipController {

    @Autowired
    private StarShipService starShipService;

    @ApiOperation(value = "Faz uma busca no banco de acordo com os parametros passados .")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Solicitação foi processada."),
            @ApiResponse(code = 404, message = "Não existe o item."),
            @ApiResponse(code = 500, message = "Erro na consulta")
    })
    @GetMapping(value = "/{query}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Starship> findStarShipByQuery(@NonNull @RequestParam("query")List<String> query){
        log.info("Inicio da pesquisa por query  query={}.",query);
        List<Starship> listStarhips =  starShipService.findByQuery(query,Starship.class);
        log.info("Fim da pesquisa por query query={}.",query);
        return listStarhips;
    }

    @ApiOperation(value = "Faz uma busca no banco de acordo com os parametros passados .")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Solicitação foi processada."),
            @ApiResponse(code = 404, message = "Não existe o item."),
            @ApiResponse(code = 500, message = "Erro na consulta")
    })
    @GetMapping(value = "/",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Starship> findAllStarShip(){
        log.info("Inicio da pesquisa por todos");
        List<Starship> listStarhips =  starShipService.findAllWithLimit(Starship.class);
        log.info("Fim da pesquisa por todos");
        return listStarhips;
    }
}
