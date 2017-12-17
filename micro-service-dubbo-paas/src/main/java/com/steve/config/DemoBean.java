package com.steve.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/16 下午10:50
 */
public class DemoBean {

    public void init() {
        System.out.println("Demo bean init.....");
    }

    public DemoBean() {
        System.out.println("Demo bean constructor");
    }

    public void destory() {
        System.out.println("Demo bean destroy.....");
    }
}
