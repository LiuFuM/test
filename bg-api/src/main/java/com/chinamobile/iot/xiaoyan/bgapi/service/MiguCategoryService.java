package com.chinamobile.iot.xiaoyan.bgapi.service;

import com.chinamobile.iot.xiaoyan.bgapi.entity.MiguCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MiguCategoryService {

    List<MiguCategory> listCategory();
}
