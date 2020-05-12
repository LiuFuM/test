package com.chinamobile.iot.xiaoyan.bgapi.mapper;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Banner;
import com.chinamobile.iot.xiaoyan.bgapi.entity.Skill;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

//技能映射接口
@Mapper
public interface SkillMapper {
    List<Skill> listAll();

    List<Skill> listAllWithResource();

    List<Skill> getAllSkillName();

    int addSkill(Skill skill);

    int updateSkill(Skill skill);

    int removeSkill(Skill skill);

    List<Skill> searchSkillByName(String name);

    List<Skill> listAllOrderBySearched();

    Page<Skill> listAllOrderBySearched(int pageNo, int pageSize);

    List<Skill> listAllOrderBySearched(RowBounds rowBounds);
}
