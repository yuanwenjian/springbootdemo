package com.yuanwj.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by bmk on 17-8-18.
 */
@Aspect
@Component
public class WebLogAspect {

    private static final Logger LOG = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("within(com.yuanwj.rest..*)")
    public void webLog() {

    }

    @Around("webLog()")
    public void doBefore(ProceedingJoinPoint point) {
        LOG.debug("访问地址为{}.{}(),参数为{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName(), Arrays.toString(point.getArgs()));
        try {
            Object result = point.proceed();
            LOG.debug("请求地址{}.{}(),返回结果为{}",point.getSignature().getDeclaringTypeName(),point.getSignature().getName(),result);
        } catch (Throwable throwable) {
            LOG.debug("访问异常,异常信息为{}",getStackTrace(throwable));
            throwable.printStackTrace();
        }
    }

    @AfterThrowing(pointcut = "webLog()",throwing = "throwable")
    public void doThrowe(JoinPoint point,Throwable throwable){
        LOG.debug("访问地址为{}.{}(),出现异常,异常信息为{}",point.getSignature().getDeclaringType(),point.getSignature().getName(),getStackTrace(throwable));
    }

    public String getStackTrace(Throwable throwable) {
        StringBuffer sb=new StringBuffer(throwable.getMessage()+"\n");
        StackTraceElement[] traceElements = throwable.getStackTrace();
        for (StackTraceElement element:traceElements){
            sb.append(element.toString()+"\n");
        }
        return sb.toString();
    }
}
