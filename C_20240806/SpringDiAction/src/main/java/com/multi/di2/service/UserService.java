package com.multi.di2.service;

import com.multi.di2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    private UserRepository userRepository;
    private EmailService emailService;

    // UserRepository 설정자 메서드
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // EmailService 설정자 메서드
    @Resource
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void processUsers() {
        // 사용자 목록을 가져옵니다.
        String[] users = userRepository.getUsers();

        // 각 사용자에게 이메일을 전송합니다.
        for (String user : users) {
            System.out.println("Processing user: " + user);
            emailService.sendEmail(user);
        }
    }
}
