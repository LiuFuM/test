package com.chinamobile.iot.xiaoyan.bgapi.mapper;

import com.chinamobile.iot.xiaoyan.bgapi.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface UserMapper {
    User checkLogin(User user);

    String getSalt(User user);

    int getStatus(User user);

    int addUser(User user);

    List<User> listAllUsers();

    int updateUser(User user);

    int updateUserPasswordByUsername(User user);

    int disableUser(User user);

    int enableUser(User user);

    User findUserByUsername(String username);

    int addRole2User(@Param("userId") String userId, @Param("roleId") String roleId);

    int updateUserRole(@Param("userId") String userId, @Param("roleId") String roleId);
}
