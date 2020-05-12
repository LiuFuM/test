package com.chinamobile.iot.xiaoyan.bgapi.service;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Permission;
import com.chinamobile.iot.xiaoyan.bgapi.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PermissionService {

    List<Permission> listAll();

    int addPermission(Permission permission);

    int removePermission(Permission permission);

    List<Permission> getPermissionByRole(Role role);

    int removePermissionOfRole(String permissionId, String roleId);

    int addPermissionOfRole(String permissionId, String roleId);

}
