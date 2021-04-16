package com.starwars.client.controller;

import com.starwars.client.exception.InformationNotFound;
import com.starwars.client.exception.SingleLoadRequestAsync;
import com.starwars.client.exception.StarWarsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class ControlExceptionHandler {


    @ExceptionHandler(value = {SingleLoadRequestAsync.class})
    protected ResponseEntity<Object> handleSingleLoadRequest(SingleLoadRequestAsync ex, WebRequest request) {
        log.warn("Solicitação de carga async não aceita msg={} ex={}",ex.getMessage(),ex);
        return   ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();

    }

    @ExceptionHandler(value = {InformationNotFound.class})
    protected ResponseEntity<Object> handleInformationNotFound(InformationNotFound ex, WebRequest request) {
        log.warn("Não existe na base de dados msg={} ex={}",ex.getMessage(),ex);
        return   ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }


    @ExceptionHandler(value = {StarWarsException.class})
    protected ResponseEntity<Object> handleStarw(StarWarsException ex, WebRequest request) {
        log.warn("Erro interno no servidor msg={} ex={}",ex.getMessage(),ex);
        return   ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }


    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleInformationNotFound(Exception ex, WebRequest request) {
        log.warn("Não existe na base de dados msg={} ex={}",ex.getMessage(),ex);
        return   ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }



}
