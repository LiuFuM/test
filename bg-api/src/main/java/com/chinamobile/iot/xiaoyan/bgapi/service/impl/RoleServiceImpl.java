package com.chinamobile.iot.xiaoyan.bgapi.service.impl;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Role;
import com.chinamobile.iot.xiaoyan.bgapi.mapper.RoleMapper;
import com.chinamobile.iot.xiaoyan.bgapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleMapper roleMapper;

    @Override
    public List<Role> listAllRole(){
        return roleMapper.listAllRole();
    }

    @Override
    public int addRole(Role role){
        return roleMapper.addRole(role);
    }

    @Override
    public  int removeRole(Role role){
        return roleMapper.removeRole(role);
    }
}
