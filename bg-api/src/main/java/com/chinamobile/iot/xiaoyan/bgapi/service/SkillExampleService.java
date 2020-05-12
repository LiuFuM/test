package com.chinamobile.iot.xiaoyan.bgapi.service;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Skill;
import com.chinamobile.iot.xiaoyan.bgapi.entity.SkillExample;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkillExampleService {

    List<SkillExample> getExamplesOfSkill(Skill skill);

    int addExample(SkillExample skillExample);

    int removeExample(SkillExample skillExample);

    int updateExample(SkillExample skillExample);
}
