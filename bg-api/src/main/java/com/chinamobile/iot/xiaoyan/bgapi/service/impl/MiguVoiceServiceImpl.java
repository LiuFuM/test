package com.chinamobile.iot.xiaoyan.bgapi.service.impl;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Banner;
import com.chinamobile.iot.xiaoyan.bgapi.entity.MiguVoice;
import com.chinamobile.iot.xiaoyan.bgapi.mapper.BannerMapper;
import com.chinamobile.iot.xiaoyan.bgapi.mapper.MiguVoiceMapper;
import com.chinamobile.iot.xiaoyan.bgapi.plugin.PageRowBounds;
import com.chinamobile.iot.xiaoyan.bgapi.service.BannerService;
import com.chinamobile.iot.xiaoyan.bgapi.service.MiguVoiceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MiguVoiceServiceImpl implements MiguVoiceService {

    @Resource
    MiguVoiceMapper miguVoiceMapper;

    @Override
    public int addMiguVoice(MiguVoice miguVoice) {

        return miguVoiceMapper.addMiguVoice(miguVoice);
    }

    @Override
    public int removeAll() {

        return miguVoiceMapper.removeAll();
    }

    @Override
    public List<MiguVoice> listAll() {

        return miguVoiceMapper.listAll();
    }


    @Override
    public Page<MiguVoice> listByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return miguVoiceMapper.listByPage(pageNo, pageSize);
    }

    @Override
    public Page<MiguVoice> listByPage(PageRowBounds pageRowBounds) {
        return miguVoiceMapper.listByPage(pageRowBounds);
    }


    @Override
    public Page<MiguVoice> searchByCategory(int pageNo, int pageSize, String categoryID) {
        PageHelper.startPage(pageNo, pageSize);
        return miguVoiceMapper.searchByCategory(pageNo, pageSize, categoryID);
    }

}
