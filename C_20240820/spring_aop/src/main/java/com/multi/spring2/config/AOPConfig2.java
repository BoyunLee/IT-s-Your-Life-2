package com.multi.spring2.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AOPConfig2 {

    public AOPConfig2(){
        System.out.println("AppConfig2 created");
    }

    @Bean
    public AspectClass2 aspect() {
        return new AspectClass2();
    }

    @Aspect
    public static class AspectClass2 {

        @Pointcut("execution(* com.multi.spring2.aop.controller.AOPController.aop2*(..))")
        public void order() {
        }

        @Before("order()")
        public void Login() {
            System.out.println("Login aspect triggered");
        }

        @After("order()")
        public void Logout() {
            System.out.println("Logout aspect triggered");
        }
    }
}


