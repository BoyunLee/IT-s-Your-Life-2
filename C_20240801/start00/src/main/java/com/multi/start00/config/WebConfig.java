package com.multi.start00.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//이 클래스가 하나 이상의 스프링 빈을 정의하는 데 사용된다는 것을 나타냄.
@EnableWebMvc
// 스프링 MVC를 활성화하고, 기본적인 설정을 적용합니다. 여기에는 뷰 리졸버설정, static파일 설정 포함.
@ComponentScan(basePackages = "org.example.spring00")
//지정된 패키지에서 컴포넌트를 스캔하여 빈으로 등록
public class WebConfig implements WebMvcConfigurer {
    //viewResolver빈 설정
//controller에서 전달한 데이터를 출력할 jsp파일 위치 해결
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    //resources 위치 핸들러 설정, static파일(js, css, image등)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
//multipartResolver 빈설정
}
