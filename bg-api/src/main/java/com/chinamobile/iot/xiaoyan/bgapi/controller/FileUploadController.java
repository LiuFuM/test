package com.chinamobile.iot.xiaoyan.bgapi.controller;

import com.chinamobile.iot.xiaoyan.bgapi.config.ImageConfig;
import com.chinamobile.iot.xiaoyan.bgapi.service.TokenService;
import com.chinamobile.iot.xiaoyan.bgapi.utils.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

//文件上传
@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileUploadController extends BaseController {

    @Resource
    ImageConfig imageConfig;

    @Autowired
    TokenService tokenService;

    //文件上传
    @CrossOrigin
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public JsonMsg fileUpload(MultipartFile file) {
        JsonMsg json = new JsonMsg();

        try {
            SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyyMMdd/HHmmss");

            // 获取日期,组成目录名
            String subFolderName = dateformat1.format(new Date()) + "/";

            //String baseFolder = "c://filestore//";

            String baseFolder = imageConfig.getImageFolder();

            String imageAddress = subFolderName + file.getOriginalFilename();
            // 组成长文件名
            String fullFilePath = baseFolder + subFolderName + file.getOriginalFilename();

            // 写入
            FileUtils.writeByteArrayToFile(new File(fullFilePath), file.getBytes());

            // 将结果准备输出
            // 代实现

            // 保存到输出Json
            json.setObj(imageAddress);
            json.setMsg("OK");
            return json;

        } catch (IOException e) {
            json.setSuccess(false);
            logger.debug(e.getStackTrace().toString());

            json.setMsg(e.getStackTrace().toString());
            return json;
        }

    }
}
