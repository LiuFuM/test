package com.chinamobile.iot.xiaoyan.bgapi.utils;

import com.chinamobile.iot.xiaoyan.bgapi.entity.MiguVoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//咪咕有声资源的文件读取工具
public class TempFileReader {

    Logger logger = LoggerFactory.getLogger(getClass());

    //挨行读取文件
    public List<MiguVoice> readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        List<MiguVoice> voiceList = new ArrayList<>();
        try {
            System.out.println("以行为单位读取文件内容，一次读一行");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;

            //一次读一行，读入null时文件结束
            while ((tempString = reader.readLine()) != null) {

                //把当前行号显示出来
                //System.out.println("line " + line + ": " + tempString);

                //用##分离出文本内容
                String[] lineStringArr = tempString.split("##");
                //挨个填入
                MiguVoice miguVoice = new MiguVoice();
                miguVoice.setCategoryId(lineStringArr[0]);
                miguVoice.setCategoryName(lineStringArr[1]);
                miguVoice.setId(lineStringArr[2]);
                miguVoice.setName(lineStringArr[3]);
                miguVoice.setTextAuthor(lineStringArr[4]);
                miguVoice.setVoiceAuthor(lineStringArr[5]);
                miguVoice.setCoverImageUrl(lineStringArr[6]);

                System.out.println("line " + line + ":" + miguVoice);
                //加入到list中
                voiceList.add(miguVoice);

                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        //输出list
        return voiceList;
    }


    //找到移动上传的文件中最新的.
    public String findBigest(List<String> names) {
        //String max = "";
        int temp = 0;
        for (int i = 0; i < names.size(); i++) {
            //temp=names.get(i)
            if (Integer.parseInt(names.get(i)) > temp) {

                temp = Integer.parseInt(names.get(i));
            }
        }
        return temp + "";
    }

    //搜索暂存目录
    public List<String> getFileName(String strPath) {
        List<String> fileNames = new ArrayList<>();
        File[] files = null;
        logger.debug("folder is " + strPath);
        File fileDir = new File(strPath);
        if (null != fileDir && fileDir.isDirectory()) {
            files = fileDir.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].getName().indexOf("txt") > 0) {
                    fileNames.add(files[i].getName().replace(".txt", ""));
                }
            }
        }
        for (String name : fileNames) {
            logger.debug(name);
        }
        return fileNames;
    }
}