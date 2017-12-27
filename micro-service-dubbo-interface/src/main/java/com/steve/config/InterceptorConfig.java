package com.steve.config;

import com.steve.interceptor.ApiFrequencyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/27 上午11:20
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {


    @Bean
    public ApiFrequencyInterceptor apiFrequencyInterceptor(){
        return new ApiFrequencyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiFrequencyInterceptor())
                .addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
