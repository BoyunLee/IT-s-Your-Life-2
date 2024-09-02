package org.scoula.security.account.mapper;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// @ExtendWith(SpringExtension. class): Spring 의 테스트 확장 기능을 사용하여 Spring 컨텍스트를 초기화
@ExtendWith(SpringExtension. class)

// @ContextConfiguration(classes = {RootConfig.class, SecurityConfig. class}): 테스트에서 필요한 Spring 설정
// 파일 RootConfig , SecurityConfig 을 로드
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})

// @Log4j : Log4j 를 사용하여 로그를 출력할 수 있도록 설정
@Log4j
public class UserDetailsMapperTest {

    // 의존성 주입 : @Autowired 어노테이션을 통해 UserDetailsMapper 객체를 주입
    @Autowired
    private UserDetailsMapper mapper;

    @Test
    public void testGet() {
        // testGet 메서드는 UserDetailsMapper 를 사용하여 사용자 아이디가 "admin" 인 사용자의 정보를 조회
        MemberVO member = mapper.get("admin");

        // 조회된 MemberVO 객체를 로그에 출력
        log.info(member);

        // 해당 사용자에게 부여된 권한 AuthVO 리스트 을 순회하며 각 권한을 로그에 출력
        for(AuthVO auth : member.getAuthList()){
            log.info(auth);
        }
    }
}
