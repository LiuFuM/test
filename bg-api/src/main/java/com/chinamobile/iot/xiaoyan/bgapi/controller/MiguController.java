package com.chinamobile.iot.xiaoyan.bgapi.controller;

import com.chinamobile.iot.xiaoyan.bgapi.entity.MiguCategory;
import com.chinamobile.iot.xiaoyan.bgapi.entity.MiguVoice;
import com.chinamobile.iot.xiaoyan.bgapi.page.PageInfo;
import com.chinamobile.iot.xiaoyan.bgapi.service.MiguCategoryService;
import com.chinamobile.iot.xiaoyan.bgapi.service.MiguVoiceService;
import com.chinamobile.iot.xiaoyan.bgapi.utils.JsonMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/bgapi")
public class MiguController extends BaseController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MiguCategoryService miguCategoryService;

    @Autowired
    MiguVoiceService miguVoiceService;


    //获取所有咪咕有声分类
    @GetMapping("/miguvoice/categories/")
    public JsonMsg getAllMiguCategory() {
        List<MiguCategory> list =  miguCategoryService.listCategory();
        List<MiguCategory> listHead = new ArrayList<>();
        List<MiguCategory> listHeadbefor = new ArrayList<>();
        List<MiguCategory> listBottom = new ArrayList<>();
        List<MiguCategory> listRetuen = new ArrayList<>();
        int indexOne = 0;
        int indexTwo = 0;
        Calendar now = Calendar.getInstance();
        int week = now.get(Calendar.DAY_OF_WEEK);
        if(week == Calendar.MONDAY || week == Calendar.TUESDAY){
            return feedbackJson(list);
        }else if(week == Calendar.WEDNESDAY || week == Calendar.THURSDAY){
            indexOne = 10;
            indexTwo = 20;
        }else if(week == Calendar.FRIDAY || week == Calendar.SATURDAY){
            indexOne = 20;
            indexTwo = 30;
        }else if(week == Calendar.SUNDAY){
            indexOne = 30;
            indexTwo = 40;
        }
        listHead = list.subList(indexOne, indexTwo);
        listHeadbefor = list.subList(0, indexOne);
        listBottom = list.subList(indexTwo, list.size());
        listRetuen.addAll(listHead);
        listRetuen.addAll(listHeadbefor);
        listRetuen.addAll(listBottom);
        return feedbackJson(listRetuen);
    }


    //分页根据类别id列出咪咕推荐有声资源
    @GetMapping("/miguvoice/category/{categoryID}/pageno={pageno}&pagesize={pagesize}")
    public JsonMsg listAllMiguVoice(@PathVariable("pageno") int pageNo, @PathVariable("pagesize") int pageSize, @PathVariable("categoryID") String categoryID) {
        JsonMsg jsonMsg = new JsonMsg();
        List<MiguVoice> miguVoiceList;
        PageInfo<MiguVoice> pageInfo = null;
        try {
            if (pageNo == 0 || pageSize == 0) {
                miguVoiceList = miguVoiceService.listAll();
            } else {
                logger.debug("pageNo: " + pageNo + "pageSize: " + pageSize);
                miguVoiceList = miguVoiceService.searchByCategory(pageNo, pageSize, categoryID);
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
        return jsonMsg;
    }

}
