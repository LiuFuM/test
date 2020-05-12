package com.chinamobile.iot.xiaoyan.bgapi;

import com.chinamobile.iot.xiaoyan.bgapi.entity.User;
import com.chinamobile.iot.xiaoyan.bgapi.service.UserService;
import com.chinamobile.iot.xiaoyan.bgapi.utils.PasswordGenTool;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void test(){

    }

    //@Test
    public void findUserTest() {
        System.out.println(userService.findUserByUsername("tester2"));
    }

    //@Test
    public void loginTest() {
        User user = new User();
        user.setUsername("tester");
        user.setPassword("c8f7987189361f2a57907c5d5fd0c966");
        System.out.println(userService.checkLogin(user));
    }

    //@Test
    public void getSalt() {
        User user = new User();
        user.setUsername("tester");
        System.out.println(userService.getSalt(user));
        user.setUsername("xxx");
        System.out.println(userService.getSalt(user));
    }

    //@Test
    public void getStatus() {

        User user = new User();
        user.setUsername("tester");
        System.out.println(userService.getStatus(user));
    }

    //@Test
    public void addUserTest() {
        User user = new User();
        user.setUsername("tester2");
        user.setPassword("123456");
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
       // String encryptedPassword = PasswordGenTool.genPassword(user.getUsername(), salt, user.getPassword());
        user.setPassword(PasswordGenTool.genPassword(user.getUsername(), salt, user.getPassword()));
        user.setStatus(1);
        user.setSalt(salt);
        user.setName("测试用");
        System.out.println(userService.addUser(user));
    }

    @Test
    public void listAllUsersTest() {
        System.out.println(userService.listAllUsers());
    }

    //@Test
    public void updateUser(){
        User user = new User();
        user.setId("e9f4b671-8b28-11e9-9fad-525400820e38");
        user.setUsername("tester2Changed");
        user.setPassword("xdChanged");
        user.setSalt("saltChanged");
        user.setStatus(2);
        user.setName("nameChanged");
        System.out.println(userService.updateUser(user));

    }

    //@Test
    public void disableUserTest(){
        User user = new User();
        user.setId("e9f4b671-8b28-11e9-9fad-525400820e38");
        System.out.println(userService.disableUser(user));
    }



}



