package com.chinamobile.iot.xiaoyan.bgapi.service;

import com.chinamobile.iot.xiaoyan.bgapi.entity.AccessToken;
import com.chinamobile.iot.xiaoyan.bgapi.entity.Permission;
import com.chinamobile.iot.xiaoyan.bgapi.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TokenService {

    void addTokenInRAM(AccessToken at);

    Map<String, AccessToken> getTokenListInRAM();

    boolean ifTokenActive(String token);

    int saveToken(AccessToken at);

    AccessToken findTokenByUsername(AccessToken at);

    int removeTokenByUsername(AccessToken at);

    int addAccessToken(AccessToken at);

    AccessToken findTokenByToken(AccessToken at);

    void clearTokenByUsername(User user);

    void removeTokenInRAMByUsername(String username);

    boolean checkPermissionByToken(String token, String function);

    List<Permission> getPermissionListFromDB(String username);

    boolean checkPermissionByTokenWithURI(String token, String uri);

    boolean checkPermissionByTokenWithMethodName(String token, String methodName);
}
