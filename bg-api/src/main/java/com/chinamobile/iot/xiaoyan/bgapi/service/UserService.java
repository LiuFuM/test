package com.chinamobile.iot.xiaoyan.bgapi.service;

import com.chinamobile.iot.xiaoyan.bgapi.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User checkLogin(User user);

    String getSalt(User user);

    int getStatus(User user);

    int addUser(User user);

    List<User> listAllUsers();

    int updateUser(User user);

    int updateUserPasswordByUsername(User user);

    int disableUser(User user);

    User findUserByUsername(String username);

    int addRole2User(String userId,String roleId);

    int enableUser(User user);

    int updateUserRole(String userId,String roleId);

}
