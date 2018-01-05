package com.steve.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2018/1/5 下午3:32
 */
public class BeforeLoginFilter extends GenericFilterBean {

    private static final Logger logger = LoggerFactory.getLogger(BeforeLoginFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            logger.info("this is a before login filter");

            filterChain.doFilter(servletRequest,servletResponse);
    }
}
