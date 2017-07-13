package com.steve.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.steve.model.Person;
import org.springframework.stereotype.Component;

/**
 * Created by SteveJobson on 2017/7/13.
 */
@Component
public class PersonInfoService {

    @Reference(version = "1.0.0",interfaceClass = PersonService.class)
    public PersonService personService;

    public Person getPersonInfo() {
        return personService.getPersonByName("111");
    }
}
