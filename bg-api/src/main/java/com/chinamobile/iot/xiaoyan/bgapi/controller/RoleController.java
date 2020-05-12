package com.chinamobile.iot.xiaoyan.bgapi.controller;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Role;
import com.chinamobile.iot.xiaoyan.bgapi.service.RoleService;
import com.chinamobile.iot.xiaoyan.bgapi.service.TokenService;
import com.chinamobile.iot.xiaoyan.bgapi.utils.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/bgapi")
public class RoleController extends BaseController {

    @Resource
    RoleService roleService;

    @Autowired
    TokenService tokenService;

    //获取所有的角色
    @GetMapping("/roles/")
    public JsonMsg listAllRoles() {
        return feedbackJson(roleService.listAllRole());
    }

    //增加角色
    @PostMapping("/roles/")
    public JsonMsg addRoles(Role role) {
        return feedbackJson(roleService.addRole(role));
    }

    //删除角色
    @RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE)
    public JsonMsg removeRoles(@PathVariable("id") String id) {
        Role role = new Role();
        role.setId(id);
        return feedbackJson(roleService.removeRole(role));
    }

}
