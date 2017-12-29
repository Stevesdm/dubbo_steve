package com.steve.service;

import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/28 下午10:36
 */
@Service
public class DemoService {


    @RolesAllowed("ROLE_ADMIN")
    public String  test(){
        return "hello";
    }
}
