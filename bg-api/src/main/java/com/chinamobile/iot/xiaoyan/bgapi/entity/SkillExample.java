package com.chinamobile.iot.xiaoyan.bgapi.entity;

import java.util.Date;

//技能语料实体类
public class SkillExample {
    //id, 技能id, 语料内容
    private String id, skillId, example;

    //创建, 更新时间
    private Date createTime, updateTime;

    //是否为多轮语料
    private int ifMulti;

    public int getIfMulti() {
        return ifMulti;
    }

    public void setIfMulti(int ifMulti) {
        this.ifMulti = ifMulti;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
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
        return "SkillExample{" +
                "id='" + id + '\'' +
                ", skillId='" + skillId + '\'' +
                ", example='" + example + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", ifMulti=" + ifMulti +
                '}';
    }
}
