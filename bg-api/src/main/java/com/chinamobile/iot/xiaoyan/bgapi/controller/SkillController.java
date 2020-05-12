package com.chinamobile.iot.xiaoyan.bgapi.controller;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Developer;
import com.chinamobile.iot.xiaoyan.bgapi.entity.Skill;
import com.chinamobile.iot.xiaoyan.bgapi.service.TokenService;
import com.chinamobile.iot.xiaoyan.bgapi.service.impl.SkillServiceImpl;
import com.chinamobile.iot.xiaoyan.bgapi.utils.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//技能控制器
@RestController
@RequestMapping(value = "/bgapi")
public class SkillController extends BaseController {

    @Autowired
    SkillServiceImpl skillServiceImpl;

    @Autowired
    TokenService tokenService;

    //获取技能名称
    @RequestMapping(value = "/skillsname/", method = RequestMethod.GET)
    public JsonMsg getAllSkillName() {
        return feedbackJson(skillServiceImpl.getAllSkillName());
    }

    //获取所有技能详细信息
    @RequestMapping(value = "/skills/", method = RequestMethod.GET)
    public JsonMsg getAllSkills() {
        return feedbackJson(skillServiceImpl.listAllWithResource());
    }

    //获取技能热词
    @RequestMapping(value = "/skills/hot/", method = RequestMethod.POST)
    public JsonMsg listHotSkills(int pageNo, int pageSize) {
        return feedbackJson(skillServiceImpl.listAllOrderBySearched(pageNo, pageSize));
    }

    //技能搜索
    @RequestMapping(value = "/skills/search", method = RequestMethod.POST)
    public JsonMsg searchSkills(String name) {
        List<Skill> skillList = skillServiceImpl.searchSkillByName(name);
        //搜出来的结果加1
        if (skillList.size() > 0) {
            Skill skill = new Skill();
            System.out.println(skillList.get(0).getId());
            skill.setId(skillList.get(0).getId());
            long timeSearched = skillList.get(0).getTimesSearched();
            //System.out.println(timeSearched);
            timeSearched++;
            skill.setTimesSearched(timeSearched);
            skillServiceImpl.updateSkill(skill);
        }
        return feedbackJson(skillList);
    }

    //根据id删除技能
    @RequestMapping(value = "/skills/{id}", method = RequestMethod.DELETE)
    public JsonMsg removeSkill(@PathVariable String id) {
        Skill skill = new Skill();

        skill.setId(id);

        return feedbackJson(skillServiceImpl.removeSkill(skill));

    }

    //增加技能
    @RequestMapping(value = "/developers/{id}/skills/", method = RequestMethod.POST)
    public JsonMsg addSkill(@PathVariable String id, Skill skill) {

        Developer developer = new Developer();

        developer.setId(id);

        skill.setDeveloper(developer);

        return feedbackJson(skillServiceImpl.addSkill(skill));
    }

    //根据技能id更新技能
    @RequestMapping(value = "/skills/{id}", method = RequestMethod.PUT)
    public JsonMsg updateSkill(@PathVariable String id, Skill skill, String developerId) {

        skill.setId(id);

        Developer developer = new Developer();

        if (developerId != null && developerId != "") {
            developer.setId(developerId);
        }

        skill.setDeveloper(developer);

        return feedbackJson(skillServiceImpl.updateSkill(skill));

    }

}
