package com.steve.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.steve.model.Person;
import com.steve.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by SteveJobson on 2017/7/13.
 */

@RestController
public class PersonControler {

    @Reference(version = "1.0.0", interfaceClass = PersonService.class)
    public PersonService personService;


    @RequestMapping(value = "/")
    public Person getPersonInfo() throws InterruptedException {
        return personService.getPersonByName("a");
    }

}
