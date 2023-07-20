package com.itwindy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author windy
 * @create 2023-07-11 9:26
 */
@Slf4j
@Component
@Aspect//AOp类
public class TimeAspent {
    @Around("execution(* com.itwindy.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //1.记录开始时间
        long begin = System.currentTimeMillis();
        //2.调用原始方法运行
        Object result = joinPoint.proceed();
        //3.记录结束时间，计算方法执行耗时
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature()+"方法执行耗时：{}ms",end-begin);
        return  result;
    }
}
