//package com.chinamobile.iot.xiaoyan.bgapi;
//
//import com.chinamobile.iot.xiaoyan.bgapi.entity.MiguVoice;
//import com.chinamobile.iot.xiaoyan.bgapi.utils.TempFileReader;
//import org.junit.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootTest
//public class FileReadingTest {
//
//    private static final String FILE_ADDRESS = "D:\\Bi\\20190423.txt";
//
//    @Test
//    public void FileReadTest() {
//        System.out.println("start to read file");
//        TempFileReader tempFileReader = new TempFileReader();
//        tempFileReader.readFileByLines(FILE_ADDRESS);
//    }
//
//    @Test
//    public void getNameTest() {
//        List<String> names = getFileName("D:\\Bi\\miguvoice");
//        System.out.println(findBigest(names));
//
//    }
//
//    public String findBigest(List<String> names) {
//        String max = "";
//        int temp = 0;
//        for (int i = 0; i < names.size(); i++) {
//
//            if (Integer.parseInt(names.get(i)) > temp) {
//                max = names.get(i);
//            }
//        }
//        return max;
//    }
//
//    public List<String> getFileName(String strPath) {
//        List<String> fileNames = new ArrayList<>();
//        File[] files = null;
//        File fileDir = new File(strPath);
//        if (null != fileDir && fileDir.isDirectory()) {
//            files = fileDir.listFiles();
//        }
//        for (int i = 0; i < files.length; i++) {
//            fileNames.add(files[i].getName().replace(".txt", ""));
//        }
//        return fileNames;
//    }
//}
