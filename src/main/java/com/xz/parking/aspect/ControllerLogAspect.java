package com.xz.parking.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 记录控制器Controller的日志
 * 记录内容：{
 * 访问的URL,
 * 访问者IP,
 * 请求模式(get/post),
 * 调用的方法,
 * 请求参数
 * }
 */
@Aspect     //aop切面
@Component  //开启组件扫描
public class ControllerLogAspect {
    private final Logger logger = LoggerFactory.getLogger(ControllerLogAspect.class);

    @Pointcut("execution(public * com.xz.parking.controller..*.*(..))")//切入点描述
    public void controllerLog() {
    }


    @Before("controllerLog()")
    public void doBefore(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String httpMethod = request.getMethod();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("Request{}", new RequestLog(url, ip, httpMethod, classMethod, args));
    }


    private static class RequestLog {
        private String url, ip, httpMethod, classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String httpMethod, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.httpMethod = httpMethod;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", httpMethod='" + httpMethod + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}