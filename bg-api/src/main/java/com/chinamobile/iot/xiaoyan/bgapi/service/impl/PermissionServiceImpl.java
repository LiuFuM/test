package com.chinamobile.iot.xiaoyan.bgapi.service.impl;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Permission;
import com.chinamobile.iot.xiaoyan.bgapi.entity.Role;
import com.chinamobile.iot.xiaoyan.bgapi.mapper.PermissionMapper;
import com.chinamobile.iot.xiaoyan.bgapi.mapper.RoleMapper;
import com.chinamobile.iot.xiaoyan.bgapi.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.websocket.server.ServerEndpoint;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> listAll() {
        return permissionMapper.listAll();
    }

    @Override
    public int addPermission(Permission permission) {
        return permissionMapper.addPermission(permission);
    }

    @Override
    public int removePermission(Permission permission) {
        return permissionMapper.removePermission(permission);
    }

    @Override
    public List<Permission> getPermissionByRole(Role role) {
        return permissionMapper.getPermissionByRole(role);
    }

    @Override
    public int removePermissionOfRole(String permissionId, String roleId) {
        return permissionMapper.removePermissionOfRole(permissionId, roleId);
    }

    @Override
    public int addPermissionOfRole(String permissionId, String roleId) {
        return permissionMapper.addPermissionOfRole(permissionId, roleId);
    }
}
