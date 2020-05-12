package com.chinamobile.iot.xiaoyan.bgapi.service.impl;

import com.chinamobile.iot.xiaoyan.bgapi.entity.VisitorPermission;
import com.chinamobile.iot.xiaoyan.bgapi.mapper.VisitorPermissionMapper;
import com.chinamobile.iot.xiaoyan.bgapi.service.VisitorPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VisitorPermissionServiceImpl implements VisitorPermissionService {

    @Resource
    VisitorPermissionMapper visitorPermissionMapper;

    @Override
    public List<VisitorPermission> listAll() {
        return visitorPermissionMapper.listAll();
    }
}
