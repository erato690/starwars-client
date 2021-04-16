package com.starwars.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StarWarsApiReturn<T> {

    private int count;
    private String next;
    private String previous;
    private List<T> results;

    public boolean hasNext(){

        return StringUtils.isNotBlank(next);
    }

}
