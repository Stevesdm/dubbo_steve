package com.steve;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.steve.dao")
public class DubboPaasApplication {

    public static void main(String[] args) {


          ApplicationContext ctx = SpringApplication.run(DubboPaasApplication.class, args);
    }
}
