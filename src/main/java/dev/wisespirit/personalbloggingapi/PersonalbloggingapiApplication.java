package dev.wisespirit.personalbloggingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PersonalbloggingapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalbloggingapiApplication.class, args);
	}

}
