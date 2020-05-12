package com.chinamobile.iot.xiaoyan.bgapi.mapper;

import com.chinamobile.iot.xiaoyan.bgapi.entity.AccessToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccessTokenMapper {

    int saveToken(AccessToken at);

    AccessToken findTokenByUsername(AccessToken at);

    AccessToken findTokenByToken(AccessToken at);

    int removeTokenByUsername(AccessToken at);

    int addAccessToken(AccessToken at);
}
