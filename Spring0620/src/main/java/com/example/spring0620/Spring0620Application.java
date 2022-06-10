package com.example.spring0620;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Spring0620Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring0620Application.class, args);
    }

}
