package com.chinamobile.iot.xiaoyan.bgapi.entity;

import java.util.Date;
import java.util.List;

//技能实体类
public class Skill {
    //id, 描述, 名称
    private String id, description, name;
    //评分, 类型
    private int rate, type;

    //搜索次数
    private long timesSearched;
    //type: 1: 影音阅读
    //2: 生活服务
    //3: 效率工具
    //4: 教育百科
    //5: 商业金融
    //6: 游戏娱乐
    //7: 健康健身

    //创建更新时间
    private Date createTime, updateTime;

    //技能图标列表
    private List<ResourceAddress> skillIconList;

    public long getTimesSearched() {
        return timesSearched;
    }

    public void setTimesSearched(long timesSearched) {
        this.timesSearched = timesSearched;
    }

    public List<ResourceAddress> getSkillIconList() {
        return skillIconList;
    }

    public void setSkillIconList(List<ResourceAddress> skillIconList) {
        this.skillIconList = skillIconList;
    }

    private List<SkillExample> skillExamples;

    private Developer developer;

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
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

    public List<SkillExample> getSkillExamples() {
        return skillExamples;
    }

    public void setSkillExamples(List<SkillExample> skillExamples) {
        this.skillExamples = skillExamples;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", type=" + type +
                ", timesSearched=" + timesSearched +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", skillIconList=" + skillIconList +
                ", skillExamples=" + skillExamples +
                ", developer=" + developer +
                '}';
    }
}
