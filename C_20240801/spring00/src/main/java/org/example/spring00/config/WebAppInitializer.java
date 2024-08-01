package org.example.spring00.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//스프링 기반 웹 애플리케이션의 초기 설정을 구성하여 서블릿 컨테이너가 올바르게 동작하도록 함.
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //루트 애플리케이션 컨텍스트에 로드할 설정 클래스를 반환
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class };
    }
    //서블릿 애플리케이션 컨텍스트에 로드할 설정 클래스를 반환
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }
    //디스패처 서블릿에 매핑할 URL 패턴을 반환
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
