package com.predjeskovic.socialmedia;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Log4j2
@SpringBootApplication
public class SocialMediaRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaRestApiApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(@Value("${spring.data.neo4j.password:secret}") String password
	, @Value("${github_id:}") String clientid
	, @Value("${github_secret:}") String clientsecret) {
		return args -> {
			log.info("Password for neo4j db is: " + password);
			log.info("Github clientId: " + clientid);
			log.info("Github clientSecret: " + clientsecret);
		};
	}
}
