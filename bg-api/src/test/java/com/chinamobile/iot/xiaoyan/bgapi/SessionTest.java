package com.chinamobile.iot.xiaoyan.bgapi;

import com.chinamobile.iot.xiaoyan.bgapi.entity.AccessToken;
import com.chinamobile.iot.xiaoyan.bgapi.service.TokenService;
import com.chinamobile.iot.xiaoyan.bgapi.service.impl.TokenServiceImpl;
import org.apache.shiro.crypto.hash.SimpleHash;
import com.chinamobile.iot.xiaoyan.bgapi.utils.SessionTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SessionTest {

    @Autowired
    TokenServiceImpl tokenService;


    @Test
    public void test() {
        System.out.println(tokenService.filterUri("/bgapi/featuredcontents/miguvoice/pageno=1&pagesize=3&token=dd"));
    }

    //@Test
    //这是一个综合测试, 首先把token加入数据库, 有效期1分钟, 然后查看内存中是否有数据.
    public void checkTokenTest() {
        AccessToken at = new AccessToken();
        at.setUsername("tester");
        at.setToken("abcdefgh");
        at.setCreateTime(new Date());
        at.setAvailableBefore(new Date(new Date().getTime() + 1000 * 60));
        at.setStatus(1);
        System.out.println(tokenService.addAccessToken(at));

        //插入后检查是否已经插入
        System.out.println(tokenService.findTokenByUsername(at));

        //检查token是否存在
        System.out.println(tokenService.ifTokenActive(at.getToken()));

    }

    //@Test
    public void findTokenByUsernameTest() {
        AccessToken at = new AccessToken();
        at.setUsername("tester");
        System.out.println(tokenService.findTokenByUsername(at));
    }

    // @Test
    public void findTokenByTokenTest() {
        AccessToken at = new AccessToken();
        at.setToken("xxxx1232");
        System.out.println(tokenService.findTokenByToken(at));
    }

    //@Test
    public void removeTokenTest() {
        AccessToken at = new AccessToken();
        at.setUsername("tester");
        System.out.println(tokenService.removeTokenByUsername(at));
    }


    //@Test
    public void addTokenTest() {
        AccessToken at = new AccessToken();
        at.setUsername("tester");
        at.setToken("xxxx1232");
        at.setCreateTime(new Date());
        at.setAvailableBefore(new Date());
        at.setStatus(1);
        System.out.println(tokenService.addAccessToken(at));
    }


    //@Test
    public void genSession() {
        SessionTool session = new SessionTool();
        System.out.println(session.getRandomSessionID());
        System.out.println(session.getRandomSessionID());
        System.out.println(session.getRandomSessionID());
        System.out.println(session.getRandomSessionID());
    }

    //@Test
    public void checkUserNamePassword() {

        //加密方式
        String algorithmName = "md5";

        //存储的密码
        String encrypedPasswd = "c8f7987189361f2a57907c5d5fd0c966";

        //用户名
        String username = "tester";
        //明文密码
        String password = "123456";
        //盐
        String salt = "77eba2949827d942b5baab9f53af4fe3";

        //加密轮数
        int hashIterations = 2;

        //计算
        SimpleHash hash = new SimpleHash(algorithmName, password, username + salt, hashIterations);
        System.out.println(encrypedPasswd);
        System.out.println(hash);
    }

    //@Test
    public void genPasswd() {

        //加密方式
        String algorithmName = "md5";
        //用户名
        String username = "admin4test";
        //明文密码
        String password = "123456";
        //盐
        String salt = "c576e77e6452bd4301be8e9d66b56906";

        //加密轮数
        int hashIterations = 2;

        //计算
        SimpleHash hash = new SimpleHash(algorithmName, password, username + salt, hashIterations);
        //System.out.println(encrypedPasswd);
        System.out.println(hash);
    }
}
