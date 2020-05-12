package com.chinamobile.iot.xiaoyan.bgapi.mapper;

import com.chinamobile.iot.xiaoyan.bgapi.entity.FeaturedContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//推荐内容映射接口
@Mapper
public interface FeaturedContentMapper {

    //    List<FeaturedContent> getContentByTypeAndLimit(int limit,int type);
    List<FeaturedContent> getContentByTypeAndLimit(@Param("limit") int limit, @Param("type") int type);

    int addFeaturedContent(FeaturedContent featuredContent);

    int removeFeaturedContentById(String id);

    int updateFeaturedContent(FeaturedContent featuredContent);

    List<FeaturedContent> getAllContent();
}
