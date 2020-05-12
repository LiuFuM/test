package com.chinamobile.iot.xiaoyan.bgapi.entity;

import java.util.Date;
import java.util.List;

//推荐内容实体类
public class FeaturedContent {

    //id, 名称, 描述
    private String id, name, description;

    //类型
    private int type;

    //创建及更新时间
    private Date createTime, updateTime;

    //图片资源地址表
    private List<ResourceAddress> resourceAddressList;

    public List<ResourceAddress> getResourceAddressList() {
        return resourceAddressList;
    }

    public void setResourceAddressList(List<ResourceAddress> resourceAddressList) {
        this.resourceAddressList = resourceAddressList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "FeaturedContent{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", resourceAddressList=" + resourceAddressList +
                '}';
    }
}
