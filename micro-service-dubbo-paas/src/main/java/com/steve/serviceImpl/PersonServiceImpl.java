package com.steve.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.steve.model.Person;
import com.steve.service.PersonService;
import org.springframework.stereotype.Component;

/**
 * Created by SteveJobson on 2017/7/13.
 */
@Component
@Service(version = "1.0.0",interfaceClass = PersonService.class,timeout = 5000)
public class PersonServiceImpl implements PersonService {

    @Override
    public Person getPersonByName(String name) throws InterruptedException {
        return new Person("steve",18,"beijing");
    }
}
