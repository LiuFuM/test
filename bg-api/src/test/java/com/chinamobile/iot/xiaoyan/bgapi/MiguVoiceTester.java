package com.chinamobile.iot.xiaoyan.bgapi;
//
//

import com.alibaba.fastjson.JSON;
import com.chinamobile.iot.xiaoyan.bgapi.entity.MiguCategory;
import com.chinamobile.iot.xiaoyan.bgapi.service.MiguCategoryService;
import com.chinamobile.iot.xiaoyan.bgapi.service.MiguVoiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import com.chinamobile.iot.xiaoyan.bgapi.entity.MiguVoice;
//import com.chinamobile.iot.xiaoyan.bgapi.entity.Skill;
//import com.chinamobile.iot.xiaoyan.bgapi.page.PageInfo;
//import com.chinamobile.iot.xiaoyan.bgapi.plugin.PageRowBounds;
//import com.chinamobile.iot.xiaoyan.bgapi.service.MiguVoiceService;
//import com.chinamobile.iot.xiaoyan.bgapi.utils.TempFileReader;
//import com.github.pagehelper.Page;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
@RunWith(SpringRunner.class)
@SpringBootTest
public class MiguVoiceTester {
    //
//    private static final String FILE_ADDRESS = "D:\\Bi\\20190423.txt";
//
//    private Logger logger = LoggerFactory.getLogger(MiguVoiceTester.class);

    @Autowired
    MiguCategoryService miguCategoryService;

    @Test
    public void test() {
        System.out.println(miguCategoryService.listCategory());
    }
}
//        miguVoice.setCoverImageUrl("url");
//        miguVoice.setId("id");
//        miguVoice.setTextAuthor("text");
//        miguVoice.setVoiceAuthor("voidce");
//        miguVoice.setName("name");
//        miguVoice.setCategoryName("catename");
//        miguVoice.setCategoryId("catid");
//        System.out.println(miguVoiceService.addMiguVoice(miguVoice));
//    }
//
//    @Test
//    public void fileReadAndInert() {
//        miguVoiceService.removeAll();
//
//        TempFileReader tempFileReader = new TempFileReader();
//        List<MiguVoice> miguVoices = tempFileReader.readFileByLines(FILE_ADDRESS);
//        for (int i = 0; i < miguVoices.size(); i++) {
//            miguVoiceService.addMiguVoice(miguVoices.get(i));
//        }
//    }
//
//    @Test
//    public void testListAll() {
//        System.out.println(miguVoiceService.listAll());
//    }
//
//    @Test
//    public void pageTest() {
//        //Page<MiguVoice> pagedMiguVoice = miguVoiceService.listByPage(1, 5);
//        //PageInfo<MiguVoice> pageInfo = new PageInfo<>(pagedMiguVoice);
//        //logger.debug(pageInfo.toString());
//        //logger.debug(JSON.toJSONString(pageInfo));
//
//        List<MiguVoice> miguVoiceList;
//        PageRowBounds pageRowBounds = new PageRowBounds(1, 5);
//        miguVoiceList = miguVoiceService.listByPage(pageRowBounds);
//        //获取总数
//        for (MiguVoice voice : miguVoiceList) {
//            System.out.println(voice);
//        }
//        PageInfo<MiguVoice> pageInfo = new PageInfo<>(miguVoiceList);
//        logger.debug(pageInfo.toString());
//    }
//
//    @Test
//    public void pageTest2() {
//
//        List<MiguVoice> miguVoiceList;
//        miguVoiceList = miguVoiceService.listByPage(1,5);
//        //获取总数
//        for (MiguVoice voice : miguVoiceList) {
//            System.out.println(voice);
//        }
//        PageInfo<MiguVoice> pageInfo = new PageInfo<>(miguVoiceList);
//        logger.debug(pageInfo.toString());
//    }
//}
