package org.scoula.security.util;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

// Spring 환경에서 JWT(Json Web Token) 처리 기능을 테스트하기 위한 JUnit 테스트 클래스

// @ExtendWith(SpringExtension. class): Spring 의 테스트 확장 기능을 사용하여 Spring 컨텍스트를 초기화
@ExtendWith(SpringExtension. class)

// @ContextConfiguration(classes = {RootConfig.class, SecurityConfig. class}): 테스트에 필요한 Spring 설정
// 파일 RootConfig , SecurityConfig 을 로드
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig. class})

// @Log4j : Log4j 를 사용하여 로그를 출력할 수 있도록 설정
@Log4j
class JwtProcessorTest {
    // 의존성 주입 : @Autowired 어노테이션을 통해 JwtProcessor 객체를 주입
    @Autowired
    JwtProcessor jwtProcessor;

    // generateToken 메서드 : 특정 사용자 이름 (예 : "user0") 을 사용하여 JWT 토큰을 생성하고 , 해당 토큰이 null 이 아닌지 확인 .
    // 생성된 토큰은 로그에 출력
    @Test
    void generateToken() {
        String username = "user0";
        String token = jwtProcessor.generateToken(username);
        log.info(token);
        assertNotNull(token);
    }

    // getUsername 메서드 : 주어진 JWT 토큰에서 사용자 이름을 추출하고 , 추출된 사용자 이름이 null 이 아닌지 확인 추출된
    // 사용자 이름은 로그에 출력
    @Test
    void getUsername() {
        String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTcyNDc0MzE0MCwiZXhwIjoxNzI0NzQzNzQwfQ.lAVFznBjFOOv5ZiVWuTKXJh0lb3vaRfImZOmZCQeR-qkGsuPxZ3-VERWV3naa3Yo";
        String username = jwtProcessor.getUsername(token);
        log.info(username);
        assertNotNull(username);
    }

    // validateToken 메서드 : 주어진 JWT 토큰의 유효성을 검사하고 , 유효한 경우 true 를 반환하며 , 그 결과를 로그에 출력 .
    // 5분 이상 경과한 토큰은 무효로 처리
    @Test
    void validateToken() {
        String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTcyNDc0MzE0MCwiZXhwIjoxNzI0NzQzNzQwfQ.lAVFznBjFOOv5ZiVWuTKXJh0lb3vaRfImZOmZCQeR-qkGsuPxZ3-VERWV3naa3Yo";
        boolean isValid = jwtProcessor.validateToken(token);
        log.info("--->> " + isValid);
        assertTrue(isValid);
    }


}