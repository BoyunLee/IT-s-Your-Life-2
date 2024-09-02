package org.scoula.security;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// @ExtendWith(SpringExtension. class): Spring 의 확장 기능을 통해 테스트 클래스에서 Spring 의 기능을 사용할 수 있게 함
@ExtendWith(SpringExtension.class)

// @ContextConfiguration(classes = {RootConfig.class, SecurityConfig. class}): 테스트에 필요한 Spring 설정 파일
// RootConfig 및 SecurityConfig 을 로드
@ContextConfiguration(classes = {
        RootConfig.class,
        SecurityConfig.class,
})

// @Log4j : Log4j 를 사용하여 로그를 출력할 수 있게 함
@Log4j
public class PasswordEncoderTest {
    // @Autowired 어노테이션을 통해 PasswordEncoder 객체를 주입
    @Autowired
    private PasswordEncoder pwEncoder;

    // testEncode 메서드는 PasswordEncoder 를 사용하여 "1234" 라는 문자열을 인코딩한 후 , 그 결과를 로그에 출력
    @Test
    public void testEncode() {
        String str = "1234";

        String enStr = pwEncoder.encode(str);
        log.info("password: " + enStr);

        String enStr2 = pwEncoder.encode(str);
        log.info("password: " + enStr2);

        log.info("match : " + pwEncoder.matches(str, enStr));
        log.info("match : " + pwEncoder.matches(str, enStr2));
    }
}
