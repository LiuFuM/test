package com.chinamobile.iot.xiaoyan.bgapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiguConfig {

    @Value("${migu.tempfilefolder}")
    private String miguTempFileFolder = "";


    public String getMiguTempFileFolder() {
        return miguTempFileFolder;
    }
}
