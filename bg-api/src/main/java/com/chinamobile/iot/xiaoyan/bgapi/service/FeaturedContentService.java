package com.chinamobile.iot.xiaoyan.bgapi.service;

import com.chinamobile.iot.xiaoyan.bgapi.entity.FeaturedContent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeaturedContentService {
    List<FeaturedContent> getContentByTypeAndLimit(int limit, int type);

    List<FeaturedContent> getAllContent();

    int addFeaturedContent(FeaturedContent featuredContent);

    int removeFeaturedContentById(String id);

    int updateFeaturedContent(FeaturedContent featuredContent);
}
