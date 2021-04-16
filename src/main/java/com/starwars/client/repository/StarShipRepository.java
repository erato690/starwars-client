package com.starwars.client.repository;

import com.starwars.client.model.Starship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarShipRepository extends CrudRepository<Starship,String> {
}
