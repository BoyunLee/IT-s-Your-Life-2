package org.example.spring00.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
@Configuration
//이 클래스가 하나 이상의 스프링 빈을 정의하는 데 사용된다는 것을 나타냄.
//@ComponentScan(basePackages = "org.example")
//org.example 패키지와 그 하위 패키지에 있는 모든 컴포넌트를 스캔하여 빈(bean)으로 등록
public class AppConfig {
//db관련 싱글톤 빈 정의
//멀티파트 사이즈 정의
//보안 설정, 비즈니스 서비스 빈 등을 정의
}
