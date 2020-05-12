package com.chinamobile.iot.xiaoyan.bgapi.Interceptor;

import com.chinamobile.iot.xiaoyan.bgapi.entity.VisitorPermission;
import com.chinamobile.iot.xiaoyan.bgapi.service.PermissionService;
import com.chinamobile.iot.xiaoyan.bgapi.service.TokenService;
import com.chinamobile.iot.xiaoyan.bgapi.service.VisitorPermissionService;
import com.chinamobile.iot.xiaoyan.bgapi.utils.JsonMsg;
import jdk.nashorn.internal.parser.Token;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Aspect
@Component
public class ControllerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);

    @Autowired
    TokenService tokenService;

    @Autowired
    VisitorPermissionService visitorPermissionService;


    @Pointcut("execution(* com.chinamobile.iot.xiaoyan.bgapi.controller..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodPointcut() {
    }

    //在拦截器中加入加入鉴权功能
    @Around("controllerMethodPointcut()")
    public Object Interceptor(ProceedingJoinPoint pjp) {
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod(); //获取被拦截的方法
        String methodName = method.getName(); //获取被拦截的方法名

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        //获取请求
        HttpServletRequest request = sra.getRequest();
        //拿到请求头
        String token = request.getHeader("token");
        String auth = request.getHeader("Authorization");
        if (token == null) {
            token = "";
        }
        logger.debug("token is " + token);
        logger.debug("auth: " + auth);

        String url = request.getRequestURL().toString();

        String queryString = request.getQueryString();

        String uri = request.getRequestURI();

        logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);

        logger.debug("methodName is " + methodName);
        if (!tokenService.checkPermissionByTokenWithMethodName(token, methodName)) {

            //if (!tokenService.checkPermissionByTokenWithURI(token, uri)) {
            JsonMsg jsonMsg = new JsonMsg();
            jsonMsg.setSuccess(false);
            jsonMsg.setMsg("Token error or permission denied");
            return jsonMsg;
        }

        Object result = null;

        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            logger.info("exception: ", e);
            //result = new JsonResult(ResultCode.EXCEPTION, "发生异常："+e.getMessage());

            result = "发生异常：";
        }

        long costMs = System.currentTimeMillis() - beginTime;

        logger.info("{}请求结束，耗时：{}ms", methodName, costMs);

        return result;
    }


}
