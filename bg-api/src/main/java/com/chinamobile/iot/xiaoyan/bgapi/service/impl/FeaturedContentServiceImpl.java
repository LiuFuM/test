package com.chinamobile.iot.xiaoyan.bgapi.service.impl;

import com.chinamobile.iot.xiaoyan.bgapi.entity.FeaturedContent;
import com.chinamobile.iot.xiaoyan.bgapi.mapper.FeaturedContentMapper;
import com.chinamobile.iot.xiaoyan.bgapi.service.FeaturedContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FeaturedContentServiceImpl implements FeaturedContentService {

    @Resource
    FeaturedContentMapper featuredContentMapper;

    @Override
    public List<FeaturedContent> getContentByTypeAndLimit(int limit, int type) {
        return featuredContentMapper.getContentByTypeAndLimit(limit, type);
    }

    @Override
    public int addFeaturedContent(FeaturedContent featuredContent) {
        return featuredContentMapper.addFeaturedContent(featuredContent);
    }

    @Override
    public int removeFeaturedContentById(String id) {
        return featuredContentMapper.removeFeaturedContentById(id);
    }

    @Override
    public int updateFeaturedContent(FeaturedContent featuredContent) {
        return featuredContentMapper.updateFeaturedContent(featuredContent);
    }

    @Override
    public List<FeaturedContent> getAllContent() {
        return featuredContentMapper.getAllContent();
    }
}
