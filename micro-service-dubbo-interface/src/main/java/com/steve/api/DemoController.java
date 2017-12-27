package com.steve.api;

import io.swagger.annotations.ApiOperation;
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


    @ApiOperation(value = "测试文档", notes = "")
    @RequestMapping(value = "/getDate")
    public Date date(){
        return new Date();
    }
}
