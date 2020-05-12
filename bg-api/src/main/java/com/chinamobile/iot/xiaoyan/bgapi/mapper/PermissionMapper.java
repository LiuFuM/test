package com.chinamobile.iot.xiaoyan.bgapi.mapper;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Permission;
import com.chinamobile.iot.xiaoyan.bgapi.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionMapper {
    List<Permission> listAll();

    int addPermission(Permission permission);

    int removePermission(Permission permission);

    List<Permission> getPermissionByRole(Role role);

    int removePermissionOfRole(@Param("permissionId") String permissionId, @Param("roleId") String roleId);

    int addPermissionOfRole(@Param("permissionId") String permissionId, @Param("roleId") String roleId);
}
