package com.steve.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2018/1/12 下午3:44
 */
@Service
public class LogService {

    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

    public void info(){

        for (int i = 0; i < 30; i++){
            logger.info("this is logger test,num: {}",i);
        }
    }
}
