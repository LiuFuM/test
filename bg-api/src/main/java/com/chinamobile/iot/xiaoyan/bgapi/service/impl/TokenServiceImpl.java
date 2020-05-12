package com.chinamobile.iot.xiaoyan.bgapi.service.impl;

import com.chinamobile.iot.xiaoyan.bgapi.config.TokenConfig;
import com.chinamobile.iot.xiaoyan.bgapi.entity.AccessToken;
import com.chinamobile.iot.xiaoyan.bgapi.entity.Permission;
import com.chinamobile.iot.xiaoyan.bgapi.entity.User;
import com.chinamobile.iot.xiaoyan.bgapi.entity.VisitorPermission;
import com.chinamobile.iot.xiaoyan.bgapi.mapper.AccessTokenMapper;
import com.chinamobile.iot.xiaoyan.bgapi.mapper.UserMapper;
import com.chinamobile.iot.xiaoyan.bgapi.service.TokenService;
import com.chinamobile.iot.xiaoyan.bgapi.service.VisitorPermissionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@Service
public class TokenServiceImpl implements TokenService {

    private Logger logger = Logger.getLogger(this.getClass());


    //这个map的String对应的是token
    private Map<String, AccessToken> tokens = new HashMap<>();

    @Autowired
    TokenConfig tokenConfig;

    @Resource
    AccessTokenMapper tokenMapper;

    @Resource
    UserMapper userMapper;

    @Resource
    VisitorPermissionService visitorPermissionService;

    @Override
    public void addTokenInRAM(AccessToken at) {
        this.tokens.put(at.getToken(), at);
    }

    @Override
    public void removeTokenInRAMByUsername(String username) {
        Iterator<String> iter = tokens.keySet().iterator();
        String token = "";

        //做一个hashmap的遍历
        while (iter.hasNext()) {
            String tempToken = iter.next();
            AccessToken at = tokens.get(tempToken);
            if (at.getUsername().equals(username)) {
                token = tempToken;
            }
        }

        //为避免空指针, 最后再移除
        tokens.remove(token);
    }

    @Override
    public Map<String, AccessToken> getTokenListInRAM() {
        return this.tokens;
    }

    @Override
    public List<Permission> getPermissionListFromDB(String username) {
        User userInDB = userMapper.findUserByUsername(username);
        List<Permission> permissionList = userInDB.getRole().getPermissionList();
        //将数据中的user权限加入到内存对象中
        return permissionList;

    }

    @Override
    public boolean ifTokenActive(String token) {
        Date now = new Date();
        long nowMiniSeconds = now.getTime();

        //先看内存里面有没有这个token
        if (tokens.containsKey(token)) {
            Date availableDate = tokens.get(token).getAvailiableBefore();
            long availableDateMiniSeconds = availableDate.getTime();
            //如果有效期小于token有效期
            if (nowMiniSeconds < availableDateMiniSeconds) {
                //说明token有效
                logger.debug("token在内存中且有效");
                return true;
            } else {
                //否则先把内存中的token删掉.
                logger.debug("token在内存中, 但失效, 已删除");
                tokens.remove(token);
            }
            //没有的话, 到DB里面找
        } else {
            logger.debug("token不在内存中");
            AccessToken at = new AccessToken();
            at.setToken(token);
            AccessToken atInDB = tokenMapper.findTokenByToken(at);
            logger.debug("db中的token是" + atInDB);
            //如果数据库中存在数据
            if (atInDB != null) {
                long availableBeforeMiniSecondsTokenInDB = atInDB.getAvailiableBefore().getTime();
                logger.debug("availableBeforeMiniSecondsTokenInDB: " + availableBeforeMiniSecondsTokenInDB);
                logger.debug("nowMiniSeconds: " + nowMiniSeconds);
                //数据库中的token存在且未过期
                if (nowMiniSeconds < availableBeforeMiniSecondsTokenInDB) {

                    //加入内存
                    logger.debug("token在数据库中,有效,加入内存");


                    //将数据中的user权限加入到内存对象中
                    atInDB.setPermissionList(getPermissionListFromDB(atInDB.getUsername()));

                    tokens.put(atInDB.getToken(), atInDB);
                    //logger.debug(tokens);
                    return true;
                } else {
                    logger.debug("token在数据库中,已经失效,现在删除");
                    tokenMapper.removeTokenByUsername(atInDB);
                }
            } else {
                logger.debug("token不在数据库中");
            }
        }

        return false;
    }

    @Override
    public int saveToken(AccessToken at) {
        return tokenMapper.saveToken(at);
    }

    @Override
    public AccessToken findTokenByUsername(AccessToken at) {
        return tokenMapper.findTokenByUsername(at);
    }

    @Override
    public int removeTokenByUsername(AccessToken at) {
        return tokenMapper.removeTokenByUsername(at);
    }

    @Override
    public int addAccessToken(AccessToken at) {
        return tokenMapper.addAccessToken(at);
    }

    @Override
    public AccessToken findTokenByToken(AccessToken at) {
        return tokenMapper.findTokenByToken(at);
    }

    @Override
    public void clearTokenByUsername(User user) {

        AccessToken at = new AccessToken();
        at.setUsername(user.getUsername());
        //删除内存中的token记录, 如果有的话
        removeTokenInRAMByUsername(user.getUsername());
        //删除DB中的记录, 如果有的话
        removeTokenByUsername(at);
    }

    @Override
    public boolean checkPermissionByToken(String token, String function) {
        //boolean ifUserHasPermission = false;

        //首先看token是否有效
        if (ifTokenActive(token)) {

            //if (tokens.containsKey(token)) {
            AccessToken tokenInRAM = tokens.get(token);
            List<Permission> permissionList = tokenInRAM.getPermissionList();
            for (int i = 0; i < permissionList.size(); i++) {
                //如果包含权限
                if (function.equals(permissionList.get(i).getFunction())) {
                    return true;
                }
            }
            logger.debug("找不到token对应的权限");
            //}
        }
        logger.debug("token 无效");
        return false;
    }

    public String filterUri(String uri) {
        String function = uri.replace(tokenConfig.getAppName(), "");
        int pagenoIndex = function.indexOf("pageno");
        if (pagenoIndex > 0) {
            String subString = function.substring(pagenoIndex);
            function = function.replace(subString, "");
        }
        return function;
    }

    @Override
    public boolean checkPermissionByTokenWithURI(String token, String uri) {
        //首先可能出现的uri是
        ///bgapi/featuredcontents/miguvoice/pageno=1&pagesize=3&token=dd

        //先整理filter一下
        String function = filterUri(uri);

        logger.debug(function);

        return searchPermisionByToken(token, uri);
    }

    //检查要访问的uri是否在白名单里面.
    private boolean ifRequestUriInWhiteList(String uri) {
        //查看白名单
        List<VisitorPermission> visitorPermissions = visitorPermissionService.listAll();

        for (VisitorPermission vp : visitorPermissions) {
            if (vp.getFunction().equals(uri)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean checkPermissionByTokenWithMethodName(String token, String methodName) {

        return searchPermisionByToken(token, methodName);

    }

    private boolean searchPermisionByToken(String token, String function) {
        if (ifRequestUriInWhiteList(function)) {
            logger.debug("uri in white list!");
            return true;
        }

        //除去白名单上的methedName, 如果没有token, 直接返回false
        if (token.equals("")) {
            logger.debug("no token and request method is not in white list, just denied");
            return false;
        }

        return checkPermissionByToken(token, function);

    }

}
