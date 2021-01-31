package com.kwon770.lamt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LamtApplication {

    public static void main(String[] args) {
        SpringApplication.run(LamtApplication.class, args);
    }

}
