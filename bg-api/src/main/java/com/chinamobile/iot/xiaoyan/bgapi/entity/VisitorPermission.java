package com.chinamobile.iot.xiaoyan.bgapi.entity;

public class VisitorPermission {

    private String id, function, description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "VisitorPermission{" +
                "id='" + id + '\'' +
                ", function='" + function + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
