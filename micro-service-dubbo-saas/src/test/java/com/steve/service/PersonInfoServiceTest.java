package com.steve.service;

import com.steve.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by SteveJobson on 2017/7/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class PersonInfoServiceTest {

    @Autowired
    PersonInfoService service;

    @Test
    public void testGetPersonInfo(){
        Person p = service.getPersonInfo();
        System.out.println(p.getName() +"666" + p.getAddress());
    }
}
