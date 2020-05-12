package com.chinamobile.iot.xiaoyan.bgapi.mapper;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Developer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//开发者映射接口
@Mapper
public interface DeveloperMapper {

    List<Developer> listAll();

    int addDeveloper(Developer developer);

    int updateDeveloper(Developer developer);

    int removeDeveloper(Developer developer);
}
