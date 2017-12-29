package com.steve.config;

import com.steve.framework.TestFIlter2;
import com.steve.framework.TestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

/**
 * Created by SteveJobson on 2017/7/13.
 */
@org.springframework.context.annotation.Configuration
public class FilterConfig {

    @Bean
    @Order(1)
    public FilterRegistrationBean testFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new TestFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("testFiletr");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    @Order(2)
    public FilterRegistrationBean testFilter1() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new TestFIlter2());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("testFiletr1");
        registrationBean.setOrder(2);
        return registrationBean;
    }

}
