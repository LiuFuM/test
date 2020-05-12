package com.chinamobile.iot.xiaoyan.bgapi.mapper;

import com.chinamobile.iot.xiaoyan.bgapi.entity.VisitorPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface VisitorPermissionMapper {

    List<VisitorPermission> listAll();
}
