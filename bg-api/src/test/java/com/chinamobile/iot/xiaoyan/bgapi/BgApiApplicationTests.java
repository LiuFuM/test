//package com.chinamobile.iot.xiaoyan.bgapi;
//
//import com.chinamobile.iot.xiaoyan.bgapi.entity.Developer;
//import com.chinamobile.iot.xiaoyan.bgapi.entity.Skill;
//import com.chinamobile.iot.xiaoyan.bgapi.service.impl.SkillServiceImpl;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class BgApiApplicationTests {
//
//    @Autowired
//    SkillServiceImpl skillService;
//
//    @Test
//    public void contextLoads() {
//    }
//
//    @Test
//    public void searchSkillTest(){
//        System.out.println(skillService.searchSkillByName("火车票"));
//    }
//
//    @Test
//    public void testListAll() {
//        System.out.println(skillService.listAll());
//    }
//
//    @Test
//    public void testListAllWithResource() {
//        System.out.println(skillService.listAllWithResource());
//    }
//
//    @Test
//    public void testAddSkill(){
//        Skill skill=new Skill();
//        skill.setDescription("描述");
//        skill.setName("测试技能");
//        skill.setType(1);
//        Developer developer=new Developer();
//        developer.setId("bbeba89e-3056-11e9-9fad-525400820e38");
//        skill.setDeveloper(developer);
//        System.out.println(skillService.addSkill(skill));
//    }
//
//    @Test
//    public void testUpdateSkill(){
//        Skill skill=new Skill();
//        skill.setId("7ee6aa9b-31e6-11e9-9fad-525400820e38");
//        skill.setTimesSearched(123);
//        System.out.println(skillService.updateSkill(skill));
//    }
//
//    @Test
//    public void testRemoveSkill(){
//        Skill skill=new Skill();
//        skill.setId("1");
//        System.out.println(skillService.removeSkill(skill));
//    }
//
//}
//
