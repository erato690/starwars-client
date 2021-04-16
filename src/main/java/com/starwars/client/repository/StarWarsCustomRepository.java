package com.starwars.client.repository;

import com.starwars.client.exception.InformationNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Repository
public class StarWarsCustomRepository<T> {


    private final MongoTemplate mongoTemplate;

    @Value("${api.client.starwars.queryLimit}")
    private Integer queryLimit;

    @Value("${api.client.starwars.findAllLimit}")
    private Integer findAllLimit;

    @Autowired
    public StarWarsCustomRepository(final MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    public List<T> findByQuery(Map<String,String> query, Class<T> c){

        Query queryMongo = new Query();

        query.keySet().stream().forEach( key -> {
            queryMongo.addCriteria(Criteria.where(key).is(query.get(key)));
        });

        queryMongo.limit(queryLimit);

        List<T> result = mongoTemplate.find(queryMongo,c);

        if(CollectionUtils.isEmpty(result)){
           throw  new InformationNotFound("Não existe dados para a pesquisa");
        }

        return result;

    }

    public List<T> findAllWithLimit(Class<T> c){

        Query queryMongo = new Query();
        queryMongo.limit(findAllLimit);

        List<T> result = mongoTemplate.find(queryMongo,c);

        if(CollectionUtils.isEmpty(result)){
            throw new InformationNotFound("Não existe dados para a pesquisa");
        }

        return result;


    }

}
