package com.predjeskovic.neo4jrestapi;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Log4j2
@SpringBootApplication
public class Neo4jRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Neo4jRestApiApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(@Value("${spring.data.neo4j.password:secret}") String password) {
		return args -> {
			log.info("Password for neo4j db is: " + password);
		};
	}
}
