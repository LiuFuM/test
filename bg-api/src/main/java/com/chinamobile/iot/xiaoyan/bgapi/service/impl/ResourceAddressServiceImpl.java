package com.chinamobile.iot.xiaoyan.bgapi.service.impl;

import com.chinamobile.iot.xiaoyan.bgapi.entity.ResourceAddress;
import com.chinamobile.iot.xiaoyan.bgapi.mapper.ResourceAddressMapper;
import com.chinamobile.iot.xiaoyan.bgapi.service.ResourceAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResourceAddressServiceImpl implements ResourceAddressService {

    @Resource
    ResourceAddressMapper resourceAddressMapper;

    @Override
    public List<ResourceAddress> listAll() {
        return resourceAddressMapper.listAll();
    }

    @Override
    public int removeResourceAddressById(String id) {
        return resourceAddressMapper.removeResourceAddressById(id);
    }

    @Override
    public int addResourceAddress(ResourceAddress resourceAddress){
        return resourceAddressMapper.addResourceAddress(resourceAddress);
    }
}
