package com.multi.di2.repository;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    public String[] getUsers() {
        // 여기서는 예제 사용자 목록을 반환합니다.
        return new String[]{"spring2", "java2", "sql2"};
    }
}
