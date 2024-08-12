package com.multi.di3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.multi.di3")
public class AppConfig {
    // 이 클래스는 빈 설정과 컴포넌트 스캔을 위한 설정 클래스입니다.

    @Bean(name = "note")
    @Scope("singleton")
    public Note getNote(){
        return new Note("Say Note");
    }
}