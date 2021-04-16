package com.starwars.client.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.client.exception.InformationNotFound;
import com.starwars.client.exception.StarWarsException;
import com.starwars.client.model.StarWarsApiReturn;
import com.starwars.client.proxy.StarWarsProxy;
import com.starwars.client.repository.StarWarsCustomRepository;
import com.starwars.client.utils.StarWarsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Slf4j
public abstract class BaseStarWarsService <T> {

    @Autowired
    private StarWarsProxy starWarsProxy;

    @Autowired
    private StarWarsCustomRepository<T> starWarsCustomRepository;


    public List<T> findByQuery(List<String> query,Class<T> t){

        try {
            Assert.notNull(query,"O parametro de query não pode ser null.");
            Assert.notNull(t,"O parametro de t  não pode ser null.");
            Map<String,String > mapQuery = StarWarsUtils.parseRequestQuery(query);
            return starWarsCustomRepository.findByQuery(mapQuery,t);
        } catch (InformationNotFound  |  IllegalArgumentException ex){
            log.warn("Não foi encontrado nenhum dado para a pesquisa parameter={}  exception={}",query,ex.getMessage(),ex);
            throw ex;
        } catch (Exception ex){
            log.error("Error ao chamar servico do star wars  parameter={} exception={}",query,ex.getMessage(),ex);
            throw new StarWarsException(ex);
        }
    }

    public List<T> findAllWithLimit(Class<T> t){

        try {
            Assert.notNull(t,"O parametro de t  não pode ser null.");
            return starWarsCustomRepository.findAllWithLimit(t);
        } catch (InformationNotFound  |  IllegalArgumentException ex){
            log.warn("Não foi encontrado nenhum dado para a pesquisa exception={}",ex.getMessage(),ex);
            throw ex;
        } catch (Exception ex){
            log.error("Error ao chamar servico do star wars exception={}",ex.getMessage(),ex);
            throw new StarWarsException(ex);
        }
    }

    protected StarWarsApiReturn<T> getPageable(int page, String url, TypeReference<StarWarsApiReturn<T>> typeReference){
        try {
            String json  = starWarsProxy.getEntityByPage(page,url);
            return new ObjectMapper().readValue(json, typeReference);
        }catch (Exception ex){
            log.error("Error ao chamar servico do star wars  page={} exception={}",page,ex);
            throw new StarWarsException(ex);
        }
    }

}
