package com.multi.di2;
import com.multi.di2.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // XML 기반의 스프링 컨텍스트 로드
        // XML 기반의 스프링 컨텍스트 로드
        ApplicationContext context = new ClassPathXmlApplicationContext("appservice2.xml");

        // UserService 빈을 가져와서 사용
        UserService userService = context.getBean(UserService.class);
        userService.processUsers();
    }
}
