package com.chinamobile.iot.xiaoyan.bgapi;


import com.chinamobile.iot.xiaoyan.bgapi.entity.Permission;
import com.chinamobile.iot.xiaoyan.bgapi.entity.Role;
import com.chinamobile.iot.xiaoyan.bgapi.service.PermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    PermissionService permissionService;

    @Test
    public void removePermissionByRoleTest() {

        String roleID = "93df2e6a-8be0-11e9-9fad-525400820e38";
        String permissionID = "152961bf-8ac8-11e9-9fad-525400820e38";

        logger.debug("record removed: " + permissionService.removePermissionOfRole(permissionID, roleID));
    }

    @Test
    public void testGetPermissionByRole() {
        Role role = new Role();
        role.setId("93df2e6a-8be0-11e9-9fad-525400820e38");
        logger.debug(permissionService.getPermissionByRole(role).toString());

        role.setId("4e0f6c84-8aab-11e9-9fad-525400820e38");
        logger.debug(permissionService.getPermissionByRole(role).toString());

        role.setId("3ad731f0-8aab-11e9-9fad-525400820e38");
        logger.debug(permissionService.getPermissionByRole(role).toString());
    }

    @Test
    public void listAllTest() {

        logger.debug(permissionService.listAll().toString());
    }

    @Test
    public void addPermissionTest() {
        Permission permission = new Permission();
        permission.setFunction("test");
        permission.setDescription("测试页面");

        logger.debug(permissionService.addPermission(permission) + "条记录被修改了");
    }

}
