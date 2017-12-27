package com.steve.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/27 下午3:16
 */
@Controller
public class DemoController {


    @RequestMapping(value = {"/","/home"})
    @RolesAllowed("user")
    public ModelAndView home(){
        return new ModelAndView("home");
    }


    @RequestMapping(value = "/hello")
    public ModelAndView hello(){
        return new ModelAndView("hello");
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

}
