package com.starwars.client.repository;

import com.starwars.client.model.Film;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends CrudRepository<Film,String> {

    @Query("{'episode_id':?0}")
    Optional<Film> findByEpisode(int episode);
}
