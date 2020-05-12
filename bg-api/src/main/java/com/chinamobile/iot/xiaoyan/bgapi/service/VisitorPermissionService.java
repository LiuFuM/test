package com.chinamobile.iot.xiaoyan.bgapi.service;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Banner;
import com.chinamobile.iot.xiaoyan.bgapi.entity.VisitorPermission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VisitorPermissionService {

    List<VisitorPermission> listAll();
}
