package com.chinamobile.iot.xiaoyan.bgapi.controller;

import com.chinamobile.iot.xiaoyan.bgapi.config.TokenConfig;
import com.chinamobile.iot.xiaoyan.bgapi.entity.AccessToken;
import com.chinamobile.iot.xiaoyan.bgapi.entity.User;
import com.chinamobile.iot.xiaoyan.bgapi.service.TokenService;
import com.chinamobile.iot.xiaoyan.bgapi.service.UserService;
import com.chinamobile.iot.xiaoyan.bgapi.utils.JsonMsg;
import com.chinamobile.iot.xiaoyan.bgapi.utils.PasswordGenTool;
import com.chinamobile.iot.xiaoyan.bgapi.utils.SessionTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

//测试用控制器
@RestController
@RequestMapping("/bgapi/test")
public class TestController extends BaseController {
    @Autowired
    TokenConfig tokenConfig;

    @Autowired
    TokenService tokenService;

    @Autowired
    UserService userService;

    @GetMapping("/users/test")
    public JsonMsg userTest() {
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.setObj(tokenService.ifTokenActive("testxxx"));
        jsonMsg.setMsg("for test");
        return jsonMsg;
    }

    @GetMapping("/users/tokens/test")
    public void tokenTest() {
        String controllersStr = tokenConfig.getControllers();
        String[] controllers = controllersStr.split(":");
        for (String c : controllers) {
            logger.debug(c);
            String url = tokenConfig.getUrlPrefix() + c + "/tokens/update";
            RestTemplate restTemplate = new RestTemplate();
            String request = restTemplate.getForObject(url, String.class);
            logger.debug(request);
        }
    }

    @GetMapping("/users/tokens/")
    public JsonMsg getTokenTest() {
        logger.debug("users get token");
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.setObj(tokenService.getTokenListInRAM());
        return jsonMsg;
    }

    @GetMapping("/users/tokentest")
    public JsonMsg tokenTest2() {
        JsonMsg jsonMsg = new JsonMsg();
        AccessToken at = new AccessToken();
        at.setUsername("tester");
        at.setToken("abcdefgh");
        at.setCreateTime(new Date());
        at.setAvailableBefore(new Date(new Date().getTime() + 1000 * 60));
        at.setStatus(1);
        logger.debug(tokenService.addAccessToken(at));

        //插入后检查是否已经插入
        logger.debug(tokenService.findTokenByUsername(at));

        return jsonMsg;
    }

    @GetMapping("/tokens/ifTokenActive/{token}")
    public JsonMsg tokenTest3(@PathVariable String token) {
        JsonMsg jsonMsg = new JsonMsg();
        //检查token是否存在
        jsonMsg.setSuccess(tokenService.ifTokenActive(token));
        return jsonMsg;
    }
}
