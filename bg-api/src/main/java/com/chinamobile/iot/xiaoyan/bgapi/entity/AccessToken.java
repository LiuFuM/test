package com.chinamobile.iot.xiaoyan.bgapi.entity;

import java.util.Date;
import java.util.List;

public class AccessToken {
    private String token;
    private String username;
    private List<Permission> permissionList;
    private Date createTime;
    private Date availableBefore;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAvailiableBefore() {
        return availableBefore;
    }

    public void setAvailableBefore(Date availableBefore) {
        this.availableBefore = availableBefore;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", permissionList=" + permissionList +
                ", createTime=" + createTime +
                ", availableBefore=" + availableBefore +
                ", status=" + status +
                '}';
    }
}
