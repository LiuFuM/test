package com.chinamobile.iot.xiaoyan.bgapi.utils;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

public class PasswordGenTool {

    public static String genPassword(String username, String salt,String originPassword) {
        //加密方式
        String algorithmName = "md5";

        //加密轮数
        int hashIterations = 2;

        SimpleHash hash = new SimpleHash(algorithmName, originPassword, username + salt, hashIterations);
        return hash.toString();
    }
}
