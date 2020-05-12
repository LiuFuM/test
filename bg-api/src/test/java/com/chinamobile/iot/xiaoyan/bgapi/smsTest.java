package com.chinamobile.iot.xiaoyan.bgapi;

import com.alibaba.fastjson.JSONException;
import com.chinamobile.iot.xiaoyan.bgapi.service.UserService;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class smsTest {

    private String strMobile = "13788888888"; //tel 的 mobile 字段的内容
    private String strAppKey = "97f7567c273cf4df0230abf69e159058"; //sdkappid 对应的 appkey，需要业务方高度保密
    private String strRand = "7226249334"; //URL 中的 random 字段的值
    private String mobile = "13714614100";
    //private String sig = Sha256(strAppKey + strRand + strTime + mobile);

    private int appid = 1400217390;
    private String appkey = "97f7567c273cf4df0230abf69e159058";
    private int templateId = 348429;
    private String smsSign = "";
    private String[] phoneNumbers = {"13714614100"};

    @Test
    public void test(){

    }

    //@Test
    public void getSig() {
        Date date = new Date();
        String time = date.getTime() / 1000 + "";
        String originSt = strAppKey + strRand + time + mobile;
        System.out.println(originSt);
        System.out.println(time);
        System.out.println(SHA(originSt, "SHA-256"));
    }

    // @Test
    public void sendSingleSMS() {
        try {
            String[] params = {"5678", "1"};
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
                    templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信

            // SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers[0],
            //"thanks", "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
        }

    }

    private String SHA(final String strText, final String strType) {
        // 返回值
        String strResult = null;

        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并傳入加密類型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes());
                // 得到 byte 類型结果
                byte byteBuffer[] = messageDigest.digest();

                // 將 byte 轉換爲 string
                StringBuffer strHexString = new StringBuffer();
                // 遍歷 byte buffer
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回結果
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return strResult;
    }

}
