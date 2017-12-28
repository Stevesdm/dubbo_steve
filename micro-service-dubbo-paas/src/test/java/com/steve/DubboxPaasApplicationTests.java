package com.steve;

import com.steve.model.Permission;
import com.steve.service.PermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboxPaasApplicationTests {


    @Autowired
    PermissionService permissionService;

    @Test
    public void contextLoads() {

        System.out.println("000000000");

        List<Permission> list = permissionService.getPermissionsByUserId(3);
        for(Permission p : list){
            System.out.println(p);
        }
        System.out.println("000000000");
    }

}
