package com.multi.spring2.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AOPConfig3 {

    public AOPConfig3(){
        System.out.println("AppConfig3 created");
    }

    @Bean
    public AOPConfig3.AspectClass3 aspect() {
        return new AOPConfig3.AspectClass3();
    }

    @Aspect
    public static class AspectClass3 {

        @Around("execution(* com.multi.spring2.aop.service.ASiteService.task*(..))")
        public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
            /*코드 작성*/
            long start = System.currentTimeMillis();

            Object proceed = joinPoint.proceed();

            long executionTime = System.currentTimeMillis() - start;
            System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");

            return proceed;
        }
    }
}


