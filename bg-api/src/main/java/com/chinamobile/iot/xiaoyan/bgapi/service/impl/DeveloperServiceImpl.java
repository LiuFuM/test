package com.chinamobile.iot.xiaoyan.bgapi.service.impl;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Developer;
import com.chinamobile.iot.xiaoyan.bgapi.mapper.DeveloperMapper;
import com.chinamobile.iot.xiaoyan.bgapi.service.DeveloperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Resource
    DeveloperMapper developerMapper;

    @Override
    public List<Developer> listAll() {
        return developerMapper.listAll();
    }

    @Override
    public int addDeveloper(Developer developer) {
        return developerMapper.addDeveloper(developer);
    }

    @Override
    public int updateDeveloper(Developer developer){
        return developerMapper.updateDeveloper(developer);
    }

    @Override
    public int removeDeveloper(Developer developer){
        return developerMapper.removeDeveloper(developer);
    }

}
