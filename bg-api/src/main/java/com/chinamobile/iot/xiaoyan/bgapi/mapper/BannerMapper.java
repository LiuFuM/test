package com.chinamobile.iot.xiaoyan.bgapi.mapper;

import com.chinamobile.iot.xiaoyan.bgapi.entity.Banner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//滚动条映射接口
@Mapper
public interface BannerMapper {
    List<Banner> listAll();

    int addBanner(Banner banner);

    int removeBanner(String id);

    int disableBanner(String id);


}
