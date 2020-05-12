package com.chinamobile.iot.xiaoyan.bgapi.service.impl;

import com.chinamobile.iot.xiaoyan.bgapi.entity.MiguCategory;
import com.chinamobile.iot.xiaoyan.bgapi.mapper.MiguCategoryMapper;
import com.chinamobile.iot.xiaoyan.bgapi.service.MiguCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MiguCategoryServiceImpl implements MiguCategoryService {

    @Resource
    MiguCategoryMapper miguCategoryMapper;

    @Override
    public List<MiguCategory> listCategory() {
        return miguCategoryMapper.listCategory();

    }
}
