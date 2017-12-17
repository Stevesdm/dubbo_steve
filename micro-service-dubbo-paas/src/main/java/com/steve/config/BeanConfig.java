package com.steve.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/16 下午10:50
 */
@Configuration
public class BeanConfig {


    @Bean(initMethod = "init", destroyMethod = "destory")
    public DemoBean getDemobean() {
        return new DemoBean();
    }
}
