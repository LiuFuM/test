package com.chinamobile.iot.xiaoyan.bgapi.service.impl;

import com.chinamobile.iot.xiaoyan.bgapi.entity.User;
import com.chinamobile.iot.xiaoyan.bgapi.mapper.SkillMapper;
import com.chinamobile.iot.xiaoyan.bgapi.mapper.UserMapper;
import com.chinamobile.iot.xiaoyan.bgapi.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User checkLogin(User user) {
        return userMapper.checkLogin(user);
    }

    @Override
    public String getSalt(User user) {
        return userMapper.getSalt(user);
    }

    @Override
    public int getStatus(User user) {
        return userMapper.getStatus(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public List<User> listAllUsers() {
        return userMapper.listAllUsers();
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int disableUser(User user) {
        return userMapper.disableUser(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public int addRole2User(String userId, String roleId) {
        return userMapper.addRole2User(userId, roleId);
    }

    @Override
    public int enableUser(User user) {
        return userMapper.enableUser(user);
    }

    @Override
    public int updateUserRole(String userId, String roleId) {
        return userMapper.updateUserRole(userId, roleId);
    }

    @Override
    public int updateUserPasswordByUsername(User user) {
        return userMapper.updateUserPasswordByUsername(user);
    }
}
