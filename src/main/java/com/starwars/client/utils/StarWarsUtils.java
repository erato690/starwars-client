package com.starwars.client.utils;

import lombok.NonNull;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StarWarsUtils {

    public static String id(String url){
        Assert.notNull(url,"O parametro url não pode ser null");
        String[] paths = url.split("/");
        return  paths[paths.length-1];
    }

    public static Map<String,String> parseRequestQuery(List<String> query){

        Assert.notNull(query,"O parametro query não pode ser null");
        return  query.stream()
                .map(s -> s.split("="))
                .collect(Collectors.toMap(key -> key[0], value ->  value[1] ));
    }
}
