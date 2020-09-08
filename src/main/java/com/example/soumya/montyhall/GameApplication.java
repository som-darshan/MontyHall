package com.example.soumya.montyhall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan
public class GameApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(GameApplication.class, args);
    }
}
