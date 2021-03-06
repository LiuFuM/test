package com.chinamobile.iot.xiaoyan.bgapi.utils;

import com.chinamobile.iot.xiaoyan.bgapi.entity.AccessToken;

import java.util.Date;
import java.util.Random;

public class SessionTool {
    static String[] allChars = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"
    };

    //生成随机32位字符
    public static String getRandomSessionID() {
        String result = "";
        Random r = new Random();
        for (int i = 0; i < 32; i++) {
            result = result + allChars[r.nextInt(allChars.length)];

        }
        return result;
    }

    //根据失效时间生成token
    public static AccessToken genTokenByUsername(String username, long tokenAvailableSeconds) {
        AccessToken at = new AccessToken();
        at.setToken(getRandomSessionID());
        at.setStatus(1);
        at.setUsername(username);
        Date date = new Date();
        long nowMiniSeconds = date.getTime();
        long timeMiniSeconds = nowMiniSeconds + tokenAvailableSeconds * 1000;
        at.setAvailableBefore(new Date(timeMiniSeconds));
        at.setCreateTime(new Date(nowMiniSeconds));
        return at;
    }
}
