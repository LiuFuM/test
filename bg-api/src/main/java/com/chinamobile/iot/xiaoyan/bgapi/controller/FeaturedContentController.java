package com.chinamobile.iot.xiaoyan.bgapi.controller;

import com.chinamobile.iot.xiaoyan.bgapi.config.MiguConfig;
import com.chinamobile.iot.xiaoyan.bgapi.entity.FeaturedContent;
import com.chinamobile.iot.xiaoyan.bgapi.entity.MiguVoice;
import com.chinamobile.iot.xiaoyan.bgapi.page.PageInfo;
import com.chinamobile.iot.xiaoyan.bgapi.service.FeaturedContentService;
import com.chinamobile.iot.xiaoyan.bgapi.service.MiguVoiceService;
import com.chinamobile.iot.xiaoyan.bgapi.service.TokenService;
import com.chinamobile.iot.xiaoyan.bgapi.utils.JsonMsg;
import com.chinamobile.iot.xiaoyan.bgapi.utils.TempFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

//推荐内容控制器
@RestController
@RequestMapping(value = "/bgapi")
public class FeaturedContentController extends BaseController {

    //private static final String TEMP_FILE_BASE = "/usr/local/website/migu";
    //private static final String TEMP_FILE_BASE = "D:\\Bi\\miguvoice";

    @Resource
    MiguConfig miguConfig;

    @Autowired
    TokenService tokenService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    FeaturedContentService featuredContentService;

    @Autowired
    MiguVoiceService miguVoiceService;

    //获取所有的推荐内容
    @RequestMapping(value = "/featuredcontents/", method = RequestMethod.GET)
    public JsonMsg getAllFC() {

        List<FeaturedContent> featuredContentList = featuredContentService.getAllContent();

        JsonMsg jsonMsg = feedbackJson(featuredContentList);

        return jsonMsg;

    }

    //获取最新的咪咕有声资源的文件名
    @GetMapping("/featuredcontents/miguvoice/last/")
    public JsonMsg getLastUpdateMiguResourceFileName() {
        TempFileReader tempFileReader = new TempFileReader();
        JsonMsg jsonMsg = new JsonMsg();
        try {
            List<String> names = tempFileReader.getFileName(miguConfig.getMiguTempFileFolder());
            //读取移动方上传的文件目录内的所有txt文件, 找到最新的版本.
            String lastFile = tempFileReader.findBigest(names) + ".txt";
            jsonMsg.setObj(lastFile);
        } catch (Exception e) {
            jsonMsg.setObj(e.getStackTrace());
            jsonMsg.setSuccess(false);
        }
        jsonMsg.setMsg("OK");

        return jsonMsg;

    }

    //分页列出所有咪咕推荐有声资源
    @GetMapping("/featuredcontents/miguvoice/pageno={pageno}&pagesize={pagesize}")
    public JsonMsg listAllMiguVoice(@PathVariable("pageno") int pageNo, @PathVariable("pagesize") int pageSize) {

        JsonMsg jsonMsg = new JsonMsg();
        List<MiguVoice> miguVoiceList;
        PageInfo<MiguVoice> pageInfo = null;
        try {
            if (pageNo == 0 || pageSize == 0) {
                miguVoiceList = miguVoiceService.listAll();
            } else {
                miguVoiceList = miguVoiceService.listByPage(pageNo, pageSize);
                pageInfo = new PageInfo<>(miguVoiceList);
                logger.debug(pageInfo.toString());
                jsonMsg.setPageInfo(pageInfo);
            }
            logger.debug(jsonMsg.toString());
            //jsonMsg.setObj(miguVoiceList);
            jsonMsg.setObj(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println(e.getStackTrace());
            jsonMsg.setMsg(e.getMessage());
            jsonMsg.setObj(e.getStackTrace());
            jsonMsg.setSuccess(false);
        }
        jsonMsg.setMsg("OK");

        return jsonMsg;

    }


    //根据所提供的文件名, 读取txt文件内推荐内容, 更新到数据库
    @RequestMapping(value = "/featuredcontents/miguvoice/", method = RequestMethod.PUT)
    public JsonMsg updateMiguVoiceFileToDB(String filename) {
        JsonMsg jsonMsg = new JsonMsg();
        //首先把已有的数据库条目清空
        miguVoiceService.removeAll();

        //读取指定的文件
        TempFileReader tempFileReader = new TempFileReader();

        //包装成MiguVoice实例的列表
        List<MiguVoice> miguVoices = tempFileReader.readFileByLines(miguConfig.getMiguTempFileFolder() + "/" + filename);

        //挨个添加到数据库
        for (int i = 0; i < miguVoices.size(); i++) {
            miguVoiceService.addMiguVoice(miguVoices.get(i));
        }
        jsonMsg.setMsg("OK");
        return jsonMsg;
    }

    //根据类型获取推荐资源
    @RequestMapping(value = "/featuredcontents/types/{type}", method = RequestMethod.GET)
    public JsonMsg getAllFCByType(@PathVariable("type") int type) {

        //1, 推荐视频3个, 2, 推荐音乐4个, 3 推荐有声内容4个, 4, 推荐技能4个
        int limit = 0;

        switch (type) {
            case 0:
                type = 1;
                limit = 3;
                break;
            case 1:
                limit = 3;
                break;
            case 2:
                limit = 4;
                break;
            case 3:
                limit = 4;
                break;
            case 4:
                limit = 4;
                break;
        }

        JsonMsg jsonMsg = feedbackJson(featuredContentService.getContentByTypeAndLimit(limit, type));

        return jsonMsg;
    }

    //根据id删除推荐资源
    @RequestMapping(value = "/featuredcontents/{id}", method = RequestMethod.DELETE)
    public JsonMsg removeFeaturedContent(@PathVariable("id") String id) {

        int result = featuredContentService.removeFeaturedContentById(id);

        JsonMsg jsonMsg = feedbackJson(result);

        return jsonMsg;

    }

    //增加推荐资源
    @RequestMapping(value = "/featuredcontents/", method = RequestMethod.POST)
    public JsonMsg addFeaturedContent(FeaturedContent featuredContent) {

        int result = featuredContentService.addFeaturedContent(featuredContent);

        JsonMsg jsonMsg = feedbackJson(result);

        return jsonMsg;
    }

}
