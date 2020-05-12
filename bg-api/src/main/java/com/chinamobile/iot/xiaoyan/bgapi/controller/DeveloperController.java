package com.chinamobile.iot.xiaoyan.bgapi.controller;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Developer;
import com.chinamobile.iot.xiaoyan.bgapi.service.TokenService;
import com.chinamobile.iot.xiaoyan.bgapi.service.impl.DeveloperServiceImpl;
import com.chinamobile.iot.xiaoyan.bgapi.utils.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//开发者的controller
@RestController
@RequestMapping("/bgapi")
public class DeveloperController extends BaseController {

    @Autowired
    DeveloperServiceImpl developerService;

    @Autowired
    TokenService tokenService;


    //获取全部开发者
    @RequestMapping(value = "/developers/", method = RequestMethod.GET)
    public JsonMsg getAllDevelopers() {
        return feedbackJson(developerService.listAll());
    }

    //增加开发者
    @RequestMapping(value = "/developers/", method = RequestMethod.POST)
    public JsonMsg addDeveloper(Developer developer) {
        return feedbackJson(developerService.addDeveloper(developer));
    }

    //根据id删除开发者
    @RequestMapping(value = "/developers/{id}", method = RequestMethod.DELETE)
    public JsonMsg deleteDeveloper(@PathVariable("id") String id) {
        Developer developer = new Developer();
        developer.setId(id);
        int result = developerService.removeDeveloper(developer);
        JsonMsg jsonMsg = feedbackJson(result);
        return jsonMsg;
    }

    //通过put方法,更新已有的开发者
    @RequestMapping(value = "/developers/", method = RequestMethod.PUT)
    public JsonMsg updateDeveloper(Developer developer) {
        int result = developerService.updateDeveloper(developer);
        JsonMsg jsonMsg = feedbackJson(result);
        return jsonMsg;
    }

}
