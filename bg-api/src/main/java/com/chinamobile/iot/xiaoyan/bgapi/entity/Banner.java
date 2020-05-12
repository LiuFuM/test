package com.chinamobile.iot.xiaoyan.bgapi.entity;

import java.util.Date;
import java.util.List;

//滚动条实体类
public class Banner {
    //id, 名称, 描述, url地址
    private String id, name, description, url;
    //类型, 状态(启用/禁用)
    private int type, status;
    //滚动条创建时间
    private Date createTime;

    private List<ResourceAddress> resourceAddressList;

    public List<ResourceAddress> getResourceAddressList() {
        return resourceAddressList;
    }

    public void setResourceAddressList(List<ResourceAddress> resourceAddressList) {
        this.resourceAddressList = resourceAddressList;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", createTime=" + createTime +
                ", resourceAddressList=" + resourceAddressList +
                '}';
    }
}
