package com.chinamobile.iot.xiaoyan.bgapi.controller;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Skill;
import com.chinamobile.iot.xiaoyan.bgapi.entity.SkillExample;
import com.chinamobile.iot.xiaoyan.bgapi.service.TokenService;
import com.chinamobile.iot.xiaoyan.bgapi.service.impl.SkillExamplerServiceImpl;
import com.chinamobile.iot.xiaoyan.bgapi.utils.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//语料的控制器
@RestController
@RequestMapping("/bgapi")
public class ExampleController extends BaseController {

    @Resource
    SkillExamplerServiceImpl skillExamplerService;

    @Autowired
    TokenService tokenService;

    //根据技能id获取该技能的所有语料
    @RequestMapping(value = "/skills/{id}/skillexamples/", method = RequestMethod.GET)
    public JsonMsg getSkillExampleBySkillId(@PathVariable("id") String id) {

        Skill skill = new Skill();

        skill.setId(id);

        List<SkillExample> examples = skillExamplerService.getExamplesOfSkill(skill);

        JsonMsg jsonMsg = feedbackJson(examples);

        return jsonMsg;


    }

    //新增语料
    @RequestMapping(value = "/skillexamples/", method = RequestMethod.POST)
    public JsonMsg addSkillExample(SkillExample skillExample) {
        int result = skillExamplerService.addExample(skillExample);
        JsonMsg jsonMsg = feedbackJson(result);
        return jsonMsg;
    }

    //更新语料
    @RequestMapping(value = "/skillexamples/", method = RequestMethod.PUT)
    public JsonMsg updateSkillExample(SkillExample skillExample) {
        int result = skillExamplerService.updateExample(skillExample);
        JsonMsg jsonMsg = feedbackJson(result);
        return jsonMsg;
    }

    //删除语料
    @RequestMapping(value = "/skillexamples/{id}", method = RequestMethod.DELETE)
    public JsonMsg removeSkillExample(@PathVariable("id") String id) {
        SkillExample skillExample = new SkillExample();
        skillExample.setId(id);
        int result = skillExamplerService.removeExample(skillExample);
        JsonMsg jsonMsg = feedbackJson(result);
        return jsonMsg;
    }

}
