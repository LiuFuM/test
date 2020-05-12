package com.chinamobile.iot.xiaoyan.bgapi.service;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Skill;
import com.github.pagehelper.Page;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkillService {
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
