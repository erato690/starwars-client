package com.starwars.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.starwars.client")
@EnableMongoRepositories
@EnableAsync
public class StarWarsClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarWarsClientApplication.class, args);
	}

}
