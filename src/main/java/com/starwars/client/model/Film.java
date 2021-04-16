package com.starwars.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(
        collection = "films"
)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class Film {


    @Id
    private String id;

    private String title;
    private Integer episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate release_date;


    private List<String> starships;

    private String url;


    public String customId(){
        String[] segments = url.split("/");
        return  segments[segments.length-1];
    }


}
