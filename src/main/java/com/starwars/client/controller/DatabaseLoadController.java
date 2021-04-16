package com.starwars.client.controller;


import com.starwars.client.service.FilmService;
import com.starwars.client.service.StarShipService;
import com.starwars.client.service.async.ExecuteSingleAsyncRequest;
import com.starwars.client.utils.SingleExecutionEnum;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/database")
public class DatabaseLoadController {

    @Autowired
    private StarShipService starShipService;

    @Autowired
    private FilmService movieService;

    @Autowired
    private ExecuteSingleAsyncRequest executeSingleAsyncRequest;

    @ApiOperation(value = "Busca todas os filmes e salva no banco.")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Solicitação foi aceita."),
            @ApiResponse(code = 406, message = "Ja existe  uma execução."),
            @ApiResponse(code = 500, message = "Sistema indisponível")
    })
    @PostMapping(value = "/movies", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> loadMoviesTheDatabase() {

        log.info("Inicio da carga starship async.");
        executeSingleAsyncRequest.isStarExecute(SingleExecutionEnum.LOAD_FILM, () -> movieService.loadBaseFromService());
        log.info("Fim da carga starship async.");
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @ApiOperation(value = "Busca todas as naves de guerra e salva no banco.")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Solicitação foi aceita."),
            @ApiResponse(code = 406, message = "Ja existe  uma execução."),
            @ApiResponse(code = 500, message = "Sistema indisponível")
    })
    @PostMapping(value = "/starship", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> loadStarShipInDatabase() {

        log.info("Inicio da carga starship async.");
        executeSingleAsyncRequest.isStarExecute(SingleExecutionEnum.LOAD_STARSHIP, () ->
             starShipService.loadBaseFromService()
        );
        log.info("Fim da carga starship async.");
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
