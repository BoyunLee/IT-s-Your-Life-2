package com.multi.di3;

import com.multi.di3.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // AnnotationConfigApplicationContext를 사용하여 자바 기반 설정 로드
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean("note"));

        // UserService 빈을 가져와서 사용
        UserService userService = context.getBean(UserService.class);
        userService.processUsers();
    }
}
