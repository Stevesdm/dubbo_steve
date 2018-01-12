package com.steve;

import com.steve.service.LogService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/27 下午3:15
 */

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {


        ApplicationContext context = SpringApplication.run(WebApplication.class, args);
        context.getBean(LogService.class).info();
    }
}
