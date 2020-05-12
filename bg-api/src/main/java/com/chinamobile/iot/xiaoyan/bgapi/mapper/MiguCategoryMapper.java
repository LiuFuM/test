package com.chinamobile.iot.xiaoyan.bgapi.mapper;

import com.chinamobile.iot.xiaoyan.bgapi.entity.MiguCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MiguCategoryMapper {

    List<MiguCategory> listCategory();
}
