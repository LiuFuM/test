package com.chinamobile.iot.xiaoyan.bgapi.mapper;

import com.chinamobile.iot.xiaoyan.bgapi.entity.MiguVoice;
import com.chinamobile.iot.xiaoyan.bgapi.plugin.PageRowBounds;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//咪咕有声映射接口
@Mapper
public interface MiguVoiceMapper {

    int addMiguVoice(MiguVoice miguVoice);

    int removeAll();

    List<MiguVoice> listAll();

    Page<MiguVoice> listByPage(int pageNo, int pageSize);

    Page<MiguVoice> listByPage(PageRowBounds pageRowBounds);

    Page<MiguVoice> searchByCategory(int pageNo, int pageSize, @Param("categoryID") String categoryID);

}
