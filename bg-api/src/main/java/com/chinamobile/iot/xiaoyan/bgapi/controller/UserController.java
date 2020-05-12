package com.chinamobile.iot.xiaoyan.bgapi.controller;

import com.chinamobile.iot.xiaoyan.bgapi.config.TokenConfig;
import com.chinamobile.iot.xiaoyan.bgapi.entity.AccessToken;
import com.chinamobile.iot.xiaoyan.bgapi.entity.User;
import com.chinamobile.iot.xiaoyan.bgapi.service.TokenService;
import com.chinamobile.iot.xiaoyan.bgapi.service.UserService;
import com.chinamobile.iot.xiaoyan.bgapi.utils.JsonMsg;
import com.chinamobile.iot.xiaoyan.bgapi.utils.PasswordGenTool;
import com.chinamobile.iot.xiaoyan.bgapi.utils.SessionTool;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bgapi")
public class UserController extends BaseController {

    @Autowired
    TokenConfig tokenConfig;

    @Autowired
    TokenService tokenService;

    @Autowired
    UserService userService;

    //用户自己修改密码
    @PostMapping("/users/password/")
    public JsonMsg updateSelfPassword(User user) {
        JsonMsg jsonMsg = new JsonMsg();
        //检查授权

        //然后确定修改的是自己的密码,而不是别人的
        //if (tokenService.getTokenListInRAM().get(token).getUsername().equals(user.getUsername())) {
        logger.debug("user is changing password");

        //获取盐
        String salt = userService.getSalt(user);
        //加密密码
        String encryptedPassword = PasswordGenTool.genPassword(user.getUsername(), salt, user.getPassword());
        user.setPassword(encryptedPassword);
        //更新user
        int result = userService.updateUserPasswordByUsername(user);
        //int result = userService.updateUser(user);

        if (result > 0) {
            jsonMsg.setMsg("Password changed");
            return jsonMsg;
        } else {
            jsonMsg.setSuccess(false);
            jsonMsg.setMsg("Password change fail");
            return jsonMsg;
        }
        //}

    }

    //管理员增加用户
    @PostMapping("/users/")
    public JsonMsg addUser(User user) {
        JsonMsg jsonMsg = new JsonMsg();
        //鉴权
        //username, name, 是用户传进来的.
        user.setStatus(1);

        //随机生成盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        user.setSalt(salt);

        //要做就是利用用户名密码进行密码加密
        user.setPassword(PasswordGenTool.genPassword(user.getUsername(), salt, user.getPassword()));

        int result = userService.addUser(user);
        jsonMsg = feedbackJson(result);
        return jsonMsg;
    }

    //管理员更新用户
    @RequestMapping(value = "/users/", method = RequestMethod.PUT)
    public JsonMsg updateUser(User user) {
        JsonMsg jsonMsg = new JsonMsg();
        //鉴权

        //如果输入了密码, 就将明文密码加盐加密保存
        if (!user.getPassword().equals("")) {

            //获取盐
            String salt = userService.getSalt(user);

            //要做就是利用用户名密码进行密码加密
            user.setPassword(PasswordGenTool.genPassword(user.getUsername(), salt, user.getPassword()));
        }
        int result = userService.updateUser(user);
        jsonMsg = feedbackJson(result);
        return jsonMsg;
    }

    //列出所有用户
    @GetMapping("/users/")
    public JsonMsg listAllUsers() {
        return feedbackJson(userService.listAllUsers());
    }


    //给新用户增加角色
    @PostMapping("/users/role/{roleId}")
    public JsonMsg addRole2User(@PathVariable("roleId") String roleId, User user) {

        User userDB = userService.findUserByUsername(user.getUsername());

        int result = userService.addRole2User(userDB.getId(), roleId);

        JsonMsg jsonMsg = feedbackJson(result);

        return jsonMsg;

    }

    //修改用户角色
    @RequestMapping(value = "/users/role/{roleId}", method = RequestMethod.PUT)
    public JsonMsg updateUserRole(@PathVariable("roleId") String roleId, User user) {

        int result = userService.updateUserRole(user.getId(), roleId);

        JsonMsg jsonMsg = feedbackJson(result);

        return jsonMsg;

    }

    //启用用户
    @PostMapping("/users/enable")
    public JsonMsg enableUser(User user) {
        int result = userService.enableUser(user);
        JsonMsg jsonMsg = feedbackJson(result);
        return jsonMsg;
    }

    //禁用用户
    @PostMapping("/users/disable")
    public JsonMsg disableUser(User user) {
        int result = userService.disableUser(user);
        JsonMsg jsonMsg = feedbackJson(result);
        return jsonMsg;
    }

    //登陆
    @PostMapping("/users/login")
    public JsonMsg login(User user) {
        JsonMsg jsonMsg = new JsonMsg();

        //搜索用户名是否存在于数据库, 并获取盐
        String salt = userService.getSalt(user);

        //如果能找到这个用户
        if (salt != null) {
            //将明文密码加密后校验
            String encryptedPassword = PasswordGenTool.genPassword(user.getUsername(), salt, user.getPassword());
            user.setPassword(encryptedPassword);
            User dbUser = userService.checkLogin(user);
            //如果db中存在符合的记录, 登陆成功
            if (dbUser != null) {

                //先清除内存跟数据库的记录
                tokenService.clearTokenByUsername(user);

                //生成token
                AccessToken at = SessionTool.genTokenByUsername(user.getUsername(), tokenConfig.getTokenAvailableSeconds());

                //搜索对应的用户权限
                at.setPermissionList(tokenService.getPermissionListFromDB(user.getUsername()));


                //插入内存
                tokenService.addTokenInRAM(at);

                //插入数据库
                tokenService.addAccessToken(at);

                jsonMsg.setMsg("OK");
                //输出token
                jsonMsg.setObj(at.getToken());
                return jsonMsg;

            } else {
                jsonMsg.setSuccess(false);
                jsonMsg.setMsg("Username/Password error");
            }

        } else {
            jsonMsg.setSuccess(false);
            jsonMsg.setMsg("Username/Password error");
        }
        jsonMsg.setSuccess(false);
        jsonMsg.setMsg("Username/Password error");
        return jsonMsg;

    }

    //通过用户名查找用户
    @GetMapping("/users/{username}")
    public JsonMsg findUserByUsername(@PathVariable("username") String username) {
        return feedbackJson(userService.findUserByUsername(username));
    }
}
