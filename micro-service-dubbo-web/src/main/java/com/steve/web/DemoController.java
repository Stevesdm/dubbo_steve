package com.steve.web;

import com.steve.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/27 下午3:16
 */
@Controller
public class DemoController {

    @Autowired
    DemoService demoService;


    @RequestMapping(value = "/home")
    public ModelAndView hello() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping("/demo")
    @ResponseBody
    public String demo() {

        return demoService.test();
    }

}
