package com.sparta.spring0617;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class Spring0617Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring0617Application.class, args);
	}

}
