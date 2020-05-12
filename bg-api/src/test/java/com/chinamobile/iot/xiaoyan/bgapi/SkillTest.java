//package com.chinamobile.iot.xiaoyan.bgapi;
//
//
//import com.alibaba.fastjson.JSON;
//import com.chinamobile.iot.xiaoyan.bgapi.entity.Skill;
//import com.chinamobile.iot.xiaoyan.bgapi.page.PageInfo;
//import com.chinamobile.iot.xiaoyan.bgapi.plugin.PageRowBounds;
//import com.chinamobile.iot.xiaoyan.bgapi.service.impl.SkillServiceImpl;
//import com.github.pagehelper.Page;
//import com.github.pagehelper.PageHelper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SkillTest {
//
//    @Autowired
//    SkillServiceImpl skillService;
//
//    @Test
//    public void listBySearchTimes() {
//        List<Skill> skillList = skillService.listAllOrderBySearched();
//
//        System.out.println(skillList.size());
//    }
//
//    @Test
//    public void listBySearchTimesWithPage() {
//        Page<Skill> skills = skillService.listAllOrderBySearched(1, 5);
//        PageInfo<Skill> pageInfo = new PageInfo<>(skills);
//        System.out.println(JSON.toJSONString(skills));
//        System.out.println(pageInfo);
//    }
//
//    @Test
//    public void test() {
//
//        List<Skill> list;
//        PageRowBounds pageRowBounds = new PageRowBounds(2, 2);
//        //再次查询
//        pageRowBounds = new PageRowBounds(1, 5);
//        list = skillService.listAllOrderBySearched(pageRowBounds);
//        //获取总数
//        for (Skill skill : list) {
//            System.out.println(skill);
//        }
//
//    }
//
//    @Test
//    public void test2() {
//        PageHelper.startPage(1, 5);
//        List<Skill> skillList = skillService.listAllOrderBySearched();
//        PageInfo page = new PageInfo(skillList);
//        System.out.println(JSON.toJSONString(skillList));
//
//        PageHelper.startPage(2, 5);
//        skillList = skillService.listAllOrderBySearched();
//        page = new PageInfo(skillList);
//        System.out.println(JSON.toJSONString(skillList));
//    }
//
//    @Test
//    public void test3(){
//        List<Skill> skillList = skillService.searchSkillByName("火");
//        System.out.println(skillList);
//
//    }
//
//
//}
