package com.chinamobile.iot.xiaoyan.bgapi.service;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BannerService {

    List<Banner> listAll();
    int addBanner(Banner banner);
    int removeBanner(String id);

    int disableBanner(String id);
}
