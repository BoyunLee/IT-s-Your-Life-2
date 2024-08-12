package com.multi.di3.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendEmail(String user) {
        // 이메일 전송 로직을 여기에 구현합니다.
        System.out.println("Sending email to " + user);
    }
}
