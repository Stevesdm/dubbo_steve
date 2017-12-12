package com.steve;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.steve.dao")
public class DubboPaasApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboPaasApplication.class, args);
    }
}
