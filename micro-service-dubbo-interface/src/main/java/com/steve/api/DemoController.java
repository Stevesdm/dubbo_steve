package com.steve.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/26 下午7:21
 */

@RestController
public class DemoController {

    @RequestMapping(value = "/getDate")
    public Date date(){
        return new Date();
    }
}
