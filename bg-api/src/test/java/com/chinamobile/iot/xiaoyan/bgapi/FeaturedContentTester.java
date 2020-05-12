//package com.chinamobile.iot.xiaoyan.bgapi;
//
//
//import com.chinamobile.iot.xiaoyan.bgapi.entity.FeaturedContent;
//import com.chinamobile.iot.xiaoyan.bgapi.service.FeaturedContentService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class FeaturedContentTester {
//
//    @Resource
//    FeaturedContentService featuredContentService;
//
//    @Test
//    public void testGetAllByLimitAndType() {
//        List<FeaturedContent> featuredContentList = featuredContentService.getContentByTypeAndLimit(5, 1);
//        System.out.println(featuredContentList);
//    }
//
//    @Test
//    public void testAddFeaturedContent() {
//        FeaturedContent featuredContent = new FeaturedContent();
//        for (int i = 0; i < 10; i++) {
//            featuredContent.setName("某些内容");
//            featuredContent.setType(i % 4 + 1);
//            featuredContent.setDescription("测试内容" + i);
//            featuredContentService.addFeaturedContent(featuredContent);
//        }
//        List<FeaturedContent> featuredContentList = featuredContentService.getContentByTypeAndLimit(5, 1);
//        System.out.println(featuredContentList);
//    }
//
//    @Test
//    public void testDelete(){
//        Assert.assertEquals(1,featuredContentService.removeFeaturedContentById("8a672f75-3446-11e9-9fad-525400820e38"));
//    }
//    @Test
//    public void testUpdate(){
//        FeaturedContent featuredContent=new FeaturedContent();
//        featuredContent.setDescription("修改过");
//        featuredContent.setName("修改过");
//        featuredContent.setType(5);
//        featuredContent.setId("8a97a557-3446-11e9-9fad-525400820e38");
//        Assert.assertEquals(1,featuredContentService.updateFeaturedContent(featuredContent));
//    }
//}
