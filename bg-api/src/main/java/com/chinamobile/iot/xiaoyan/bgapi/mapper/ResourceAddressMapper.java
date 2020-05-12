package com.chinamobile.iot.xiaoyan.bgapi.mapper;

import com.chinamobile.iot.xiaoyan.bgapi.entity.ResourceAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//资源地址映射接口
@Mapper
public interface ResourceAddressMapper {
    List<ResourceAddress> listAll();

    int removeResourceAddressById(String id);

    int addResourceAddress(ResourceAddress resourceAddress);

}
