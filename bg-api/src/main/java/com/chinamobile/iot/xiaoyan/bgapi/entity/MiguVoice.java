package com.chinamobile.iot.xiaoyan.bgapi.entity;

//咪咕有声推荐资源实体类
public class MiguVoice {
    //id, 名称, 类型id, 类型名称, 文本作者, 音频配音作者, 封面图片地址
    private String id, name, categoryId, categoryName, textAuthor, voiceAuthor, coverImageUrl;
    //创建时间
    private String createTime;

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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTextAuthor() {
        return textAuthor;
    }

    public void setTextAuthor(String textAuthor) {
        this.textAuthor = textAuthor;
    }

    public String getVoiceAuthor() {
        return voiceAuthor;
    }

    public void setVoiceAuthor(String voiceAuthor) {
        this.voiceAuthor = voiceAuthor;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "MiguVoice{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", textAuthor='" + textAuthor + '\'' +
                ", voiceAuthor='" + voiceAuthor + '\'' +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
