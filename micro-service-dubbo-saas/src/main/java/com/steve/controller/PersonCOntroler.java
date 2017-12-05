package com.steve.controller;

import com.steve.model.Person;
import com.steve.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by SteveJobson on 2017/7/13.
 */

@RestController
public class PersonCOntroler {

    @Autowired
    private PersonInfoService personInfoService;

    @RequestMapping(value = "/")
    public Person getPersonInfo(){
        return personInfoService.getPersonInfo();
    }
}
