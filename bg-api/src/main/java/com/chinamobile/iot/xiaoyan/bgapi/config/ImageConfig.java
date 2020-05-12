package com.chinamobile.iot.xiaoyan.bgapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImageConfig {

    @Value("${image.folder}")
    private String imageFolder = "";

    public String getImageFolder() {
        return imageFolder;
    }
}
