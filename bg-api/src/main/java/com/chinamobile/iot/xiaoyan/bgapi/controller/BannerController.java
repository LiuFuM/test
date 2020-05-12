package com.chinamobile.iot.xiaoyan.bgapi.controller;

import com.chinamobile.iot.xiaoyan.bgapi.entity.AccessToken;
import com.chinamobile.iot.xiaoyan.bgapi.entity.Banner;
import com.chinamobile.iot.xiaoyan.bgapi.service.BannerService;
import com.chinamobile.iot.xiaoyan.bgapi.service.TokenService;
import com.chinamobile.iot.xiaoyan.bgapi.utils.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//滚动条controller
@RestController
@RequestMapping("/bgapi")
public class BannerController extends BaseController {

    @Autowired
    BannerService bannerService;

    @Autowired
    TokenService tokenService;

    //获取全部的滚动条
    @RequestMapping(value = "/banners/", method = RequestMethod.GET)
    public JsonMsg getAllBanners() {
        return feedbackJson(bannerService.listAll());
    }

    //禁用指定的滚动条
    @RequestMapping(value = "/banners/{id}/status/0", method = RequestMethod.PUT)
    public JsonMsg disableBanner(@PathVariable("id") String id) {
        return feedbackJson(bannerService.disableBanner(id));
    }

    //增加新的滚动条
    @RequestMapping(value = "/banners/", method = RequestMethod.POST)
    public JsonMsg addBanner(Banner banner) {
        return feedbackJson(bannerService.addBanner(banner));
    }

}
