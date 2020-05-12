package com.chinamobile.iot.xiaoyan.bgapi.service;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Developer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeveloperService {

    List<Developer> listAll();

    int addDeveloper(Developer developer);

    int updateDeveloper(Developer developer);

    int removeDeveloper(Developer developer);

}
