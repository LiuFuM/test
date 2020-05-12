package com.chinamobile.iot.xiaoyan.bgapi.controller;

import com.chinamobile.iot.xiaoyan.bgapi.utils.JsonMsg;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseController {

    private static final long serialVersionUID = 6357869213649815390L;

    protected Logger logger = Logger.getLogger(this.getClass());

//    protected JsonMsg feedbackJson(int result) {
//        JsonMsg jsonMsg = new JsonMsg();
//        if (result > 0) {
//            jsonMsg.setObj(result);
//            jsonMsg.setMsg("OK");
//        } else {
//            jsonMsg.setSuccess(false);
//            jsonMsg.setMsg("Error");
//        }
//        return jsonMsg;
//    }


    protected JsonMsg feedbackJson(Object object) {
        JsonMsg jsonMsg = new JsonMsg();
        if (object != null) {
            jsonMsg.setObj(object);
            jsonMsg.setMsg("OK");
        } else {
            jsonMsg.setSuccess(false);
            jsonMsg.setMsg("Error");
        }
        return jsonMsg;
    }


    protected JsonMsg feedbackPermissionErrorJson() {
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.setSuccess(false);
        jsonMsg.setMsg("Authorization/authentication fail");
        return jsonMsg;
    }

    protected JsonMsg feedbackJson(List<?> ObjList) {
        JsonMsg jsonMsg = new JsonMsg();
        int resultNumber = ObjList.size();
        if (resultNumber > 0) {
            jsonMsg.setObj(ObjList);
            jsonMsg.setMsg("OK");
        } else {
            jsonMsg.setSuccess(false);
            jsonMsg.setMsg("Error");
        }
        return jsonMsg;
    }

}
