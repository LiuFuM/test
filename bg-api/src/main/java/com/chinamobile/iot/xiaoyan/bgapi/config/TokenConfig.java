package com.chinamobile.iot.xiaoyan.bgapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenConfig {
    @Value("${controllers}")
    private String controllers = "";

    @Value("${url.prefix}")
    private String urlPrefix = "";

    @Value("${uri.app.name}")
    private String appName = "";

    @Value("${token.available.seconds}")
    private long tokenAvailableSeconds;

    public String getControllers() {
        return controllers;
    }

    public String getUrlPrefix() {
        return urlPrefix;
    }

    public long getTokenAvailableSeconds() {
        return tokenAvailableSeconds;
    }

    public String getAppName() {
        return appName;
    }
}
