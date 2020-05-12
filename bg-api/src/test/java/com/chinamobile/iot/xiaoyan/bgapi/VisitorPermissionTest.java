package com.chinamobile.iot.xiaoyan.bgapi;


import com.chinamobile.iot.xiaoyan.bgapi.entity.Permission;
import com.chinamobile.iot.xiaoyan.bgapi.entity.Role;
import com.chinamobile.iot.xiaoyan.bgapi.entity.VisitorPermission;
import com.chinamobile.iot.xiaoyan.bgapi.service.PermissionService;
import com.chinamobile.iot.xiaoyan.bgapi.service.VisitorPermissionService;
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
public class VisitorPermissionTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    VisitorPermissionService visitorPermissionService;

    @Test
    public void listAllTest() {
        List<VisitorPermission> visitorPermissions = visitorPermissionService.listAll();
        logger.debug(visitorPermissions.toString());
    }



}
