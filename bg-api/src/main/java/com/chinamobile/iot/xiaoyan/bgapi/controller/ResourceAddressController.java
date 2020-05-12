package com.chinamobile.iot.xiaoyan.bgapi.controller;

import com.chinamobile.iot.xiaoyan.bgapi.entity.ResourceAddress;
import com.chinamobile.iot.xiaoyan.bgapi.service.ResourceAddressService;
import com.chinamobile.iot.xiaoyan.bgapi.service.TokenService;
import com.chinamobile.iot.xiaoyan.bgapi.utils.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//图片资源地址管理控制器
@RestController
@RequestMapping("/bgapi")
public class ResourceAddressController extends BaseController {

    @Resource
    ResourceAddressService resourceAddressService;

    @Autowired
    TokenService tokenService;

    //获取所有的图片资源地址
    @RequestMapping(value = "/resourceaddresses/", method = RequestMethod.GET)
    public JsonMsg getAllResourceAddress() {

        JsonMsg jsonMsg = feedbackJson(resourceAddressService.listAll());

        return jsonMsg;

    }

    //新增一个图片资源地址
    @RequestMapping(value = "/resourceaddresses/", method = RequestMethod.POST)
    public JsonMsg addResourceAddresse(ResourceAddress resourceAddress) {

        return feedbackJson(resourceAddressService.addResourceAddress(resourceAddress));
    }

    //删除图片资源地址
    @RequestMapping(value = "/resourceaddresses/{id}", method = RequestMethod.DELETE)
    public JsonMsg removeResourceAddress(@PathVariable("id") String id) {
        JsonMsg jsonMsg = feedbackJson(resourceAddressService.removeResourceAddressById(id));
        return jsonMsg;
    }

}
