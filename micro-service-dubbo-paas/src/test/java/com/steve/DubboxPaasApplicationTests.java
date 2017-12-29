package com.steve;

import com.steve.model.Permission;
import com.steve.model.Role;
import com.steve.service.PermissionService;
import com.steve.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboxPaasApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(DubboxPaasApplicationTests.class);


    @Autowired
    PermissionService permissionService;

    @Autowired
    RoleService roleService;

    @Test
    public void testGetPermissionByUserId() {
        List<Permission> list = permissionService.getPermissionsByUserId(3);
        for (Permission p : list) {
            System.out.println(p);
        }
    }

    @Test
    public void testRoleServiceImpl() {

        List<Role> list = roleService.getRoleByUserId(4);
        for (Role r : list) {
            System.out.println(r);
        }
    }

}
