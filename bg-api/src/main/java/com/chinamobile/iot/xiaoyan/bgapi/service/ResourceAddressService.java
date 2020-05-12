package com.chinamobile.iot.xiaoyan.bgapi.service;

import com.chinamobile.iot.xiaoyan.bgapi.entity.ResourceAddress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResourceAddressService {

    List<ResourceAddress> listAll();

    int removeResourceAddressById(String id);

    int addResourceAddress(ResourceAddress resourceAddress);


}
