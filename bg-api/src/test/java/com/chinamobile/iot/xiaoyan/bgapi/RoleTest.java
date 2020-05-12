package com.chinamobile.iot.xiaoyan.bgapi;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Role;
import com.chinamobile.iot.xiaoyan.bgapi.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTest {

    @Autowired
    RoleService roleService;

    @Test
    public void listAllTest(){
        System.out.println(roleService.listAllRole());
    }

    //@Test
    public void addRoleTest(){
        Role role=new Role();
        role.setDescription("测试人员专用角色");
        role.setName("tester");
        System.out.println(roleService.addRole(role));

    }

    //@Test
    public void removeRoleTest(){
        Role role=new Role();
        role.setId("61e4bb61-8b91-11e9-9fad-525400820e38");
        System.out.println(roleService.removeRole(role));

    }

}
