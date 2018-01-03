package com.steve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/28 下午10:36
 */
@Service
public class DemoService {


    //通过这种方式加密密码
    @Autowired
    private PasswordEncoder passwordEncoder;


    @RolesAllowed("ROLE_ADMIN")
    public String test() {
        return passwordEncoder.encode("admin");
    }
}
