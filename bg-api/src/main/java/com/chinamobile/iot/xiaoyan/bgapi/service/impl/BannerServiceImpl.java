package com.chinamobile.iot.xiaoyan.bgapi.service.impl;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Banner;
import com.chinamobile.iot.xiaoyan.bgapi.entity.MiguVoice;
import com.chinamobile.iot.xiaoyan.bgapi.mapper.BannerMapper;
import com.chinamobile.iot.xiaoyan.bgapi.service.BannerService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Resource
    BannerMapper bannerMapper;

    @Override
    public List<Banner> listAll() {
        return bannerMapper.listAll();
    }

    @Override
    public int addBanner(Banner banner) {
        return bannerMapper.addBanner(banner);
    }

    @Override
    public int removeBanner(String id) {
        return bannerMapper.removeBanner(id);
    }

    @Override
    public int disableBanner(String id) {
        return bannerMapper.disableBanner(id);
    }

}
