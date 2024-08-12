package com.multi.di3.service;

import com.multi.di3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    private UserRepository userRepository;
    private EmailService emailService;

    // 생성자 주입
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 세터 주입을 통해 EmailService 주입
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
