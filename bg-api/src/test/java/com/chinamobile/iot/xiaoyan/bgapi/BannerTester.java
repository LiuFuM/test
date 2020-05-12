//package com.chinamobile.iot.xiaoyan.bgapi;
//
//
//import com.chinamobile.iot.xiaoyan.bgapi.entity.Banner;
//import com.chinamobile.iot.xiaoyan.bgapi.service.BannerService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class BannerTester {
//
//    @Autowired
//    BannerService bannerService;
//
//    @Test
//    public void bannerTester() {
//        System.out.println(bannerService.listAll());
//    }
//
//    @Test
//    public void addTest(){
//        Banner banner=new Banner();
//        banner.setDescription("这是一个测试用滚动条");
//        banner.setName("测试");
//        banner.setType(1);
//        banner.setStatus(1);
//        banner.setUrl("xxxx/xxx/");
//
//        System.out.println(bannerService.addBanner(banner));
//    }
//
//    @Test
//    public void removeTest(){
//        System.out.println(bannerService.removeBanner("47d2400a-3b07-11e9-9fad-525400820e38"));
//    }
//
//
//
//}
