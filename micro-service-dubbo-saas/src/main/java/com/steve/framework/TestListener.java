package com.steve.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/13 下午12:52
 */
public class TestListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        long start = System.currentTimeMillis();
        logger.info("系统启动中。。");
        long end = System.currentTimeMillis();
        logger.info("启动完毕："+(end-start));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
