package com.chinamobile.iot.xiaoyan.bgapi.service;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Banner;
import com.chinamobile.iot.xiaoyan.bgapi.entity.MiguVoice;
import com.chinamobile.iot.xiaoyan.bgapi.plugin.PageRowBounds;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MiguVoiceService {

    int addMiguVoice(MiguVoice miguVoice);

    int removeAll();

    List<MiguVoice> listAll();

    Page<MiguVoice> listByPage(int pageNo, int pageSize);

    Page<MiguVoice> listByPage(PageRowBounds pageRowBounds);

    Page<MiguVoice> searchByCategory(int pageNo, int pageSize, String categoryID);

}
