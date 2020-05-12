package com.chinamobile.iot.xiaoyan.bgapi.entity;

//资源地址实体类
//目前仅限图片资源
public class ResourceAddress {
    //id, 地址, 挂钩对象id, 描述
    private String id, address, targetId, description;

    //挂钩名称
    //target及使用这个图片的实体类, 例如推荐内容, 技能都会使用到图片, 这个图片的target就是对应的内容/技能
    private String targetName;

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ResourceAddress{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", targetId='" + targetId + '\'' +
                ", description='" + description + '\'' +
                ", targetName='" + targetName + '\'' +
                '}';
    }
}
