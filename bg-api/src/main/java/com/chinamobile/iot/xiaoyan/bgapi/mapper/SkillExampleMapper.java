package com.chinamobile.iot.xiaoyan.bgapi.mapper;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Skill;
import com.chinamobile.iot.xiaoyan.bgapi.entity.SkillExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//技能语料映射接口
@Mapper
public interface SkillExampleMapper {
    List<SkillExample> getExamplesOfSkill(Skill skill);

    int addExample(SkillExample skillExample);

    int removeExample(SkillExample skillExample);

    int updateExample(SkillExample skillExample);

}
