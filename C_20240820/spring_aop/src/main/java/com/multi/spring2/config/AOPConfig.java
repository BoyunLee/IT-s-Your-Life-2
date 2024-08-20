package com.multi.spring2.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AOPConfig {

    public AOPConfig(){
        System.out.println("AppConfig created");
    }

    @Bean
    public AspectClass2 aspect() {
        return new AspectClass2();
    }

    @Aspect
    public static class AspectClass2 {

        @Pointcut("execution(* com.multi.spring2.aop.controller.AOPController.aop*(..))")
        public void tour() {
            // Pointcut method, no implementation needed
        }

        @Before("tour()")
        public void Login() {
            System.out.println("Login aspect triggered");
        }

        @After("tour()")
        public void Logout() {
            System.out.println("Logout aspect triggered");
        }
    }
}


