package com.desafio.anota.ai.odivanmarcos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class OdivanmarcosApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdivanmarcosApplication.class, args);
	}

}
