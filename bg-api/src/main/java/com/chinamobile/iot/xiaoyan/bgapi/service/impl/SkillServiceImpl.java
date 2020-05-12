package com.chinamobile.iot.xiaoyan.bgapi.service.impl;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Skill;
import com.chinamobile.iot.xiaoyan.bgapi.mapper.SkillMapper;
import com.chinamobile.iot.xiaoyan.bgapi.service.SkillService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

    @Resource
    SkillMapper skillMapper;

    @Override
    public List<Skill> listAll() {
        return skillMapper.listAll();
    }

    @Override
    public List<Skill> getAllSkillName() {
        return skillMapper.getAllSkillName();
    }

    @Override
    public int addSkill(Skill skill) {
        return skillMapper.addSkill(skill);
    }

    @Override
    public int updateSkill(Skill skill) {
        return skillMapper.updateSkill(skill);
    }

    @Override
    public int removeSkill(Skill skill) {
        return skillMapper.removeSkill(skill);
    }

    @Override
    public List<Skill> listAllWithResource() {
        return skillMapper.listAllWithResource();
    }

    @Override
    public List<Skill> searchSkillByName(String name) {
        return skillMapper.searchSkillByName(name);
    }

    @Override
    public List<Skill> listAllOrderBySearched() {
        return skillMapper.listAllOrderBySearched();
    }

    @Override
    public Page<Skill> listAllOrderBySearched(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return skillMapper.listAllOrderBySearched(pageNo,pageSize);
    }


    @Override
    public List<Skill> listAllOrderBySearched(RowBounds rowBounds) {
        return skillMapper.listAllOrderBySearched(rowBounds);
    }
}
