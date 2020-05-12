package com.chinamobile.iot.xiaoyan.bgapi.controller;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Permission;
import com.chinamobile.iot.xiaoyan.bgapi.entity.Role;
import com.chinamobile.iot.xiaoyan.bgapi.service.PermissionService;
import com.chinamobile.iot.xiaoyan.bgapi.service.TokenService;
import com.chinamobile.iot.xiaoyan.bgapi.utils.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bgapi")
public class PermissionController extends BaseController {

    @Autowired
    PermissionService permissionService;

    @Autowired
    TokenService tokenService;

    //增加权限
    @PostMapping("/permissions/")
    public JsonMsg addPermission(Permission permission) {
        return feedbackJson(permissionService.addPermission(permission));
    }

    //获取所有权限列表
    @GetMapping("/permissions/")
    public JsonMsg getAllPermission() {
        return feedbackJson(permissionService.listAll());
    }

    //删除权限
    @RequestMapping(value = "/permissions/{id}", method = RequestMethod.DELETE)
    public JsonMsg removePermission(@PathVariable("id") String id) {
        Permission permission = new Permission();
        permission.setId(id);
        return feedbackJson(permissionService.removePermission(permission));
    }

    //根据角色获取permission
    @GetMapping("/roles/{roleId}/permissions/")
    public JsonMsg getPermissionByRole(@PathVariable("roleId") String roleId) {
        Role role = new Role();
        role.setId(roleId);
        return feedbackJson(permissionService.getPermissionByRole(role));
    }

    //删除角色的权限
    @RequestMapping(value = "/roles/{roleId}/permissions/{permissionId}", method = RequestMethod.DELETE)
    public JsonMsg removePermissionOfRole(@PathVariable("roleId") String roleId, @PathVariable("permissionId") String permissionId) {
        return feedbackJson(permissionService.removePermissionOfRole(permissionId, roleId));
    }

    //给角色增加权限
    @PostMapping("/roles/{roleId}/permissions/{permissionId}")
    public JsonMsg addPermissionForRole(@PathVariable("roleId") String roleId, @PathVariable("permissionId") String permissionId) {
        return feedbackJson(permissionService.addPermissionOfRole(permissionId, roleId));
    }

}
