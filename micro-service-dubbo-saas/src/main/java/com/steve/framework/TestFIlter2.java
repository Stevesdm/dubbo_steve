package com.steve.framework;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by SteveJobson on 2017/7/13.
 */
public class TestFIlter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        System.out.println("----------------filter2-------------");
        System.out.println(servletRequest.getRemoteHost());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
