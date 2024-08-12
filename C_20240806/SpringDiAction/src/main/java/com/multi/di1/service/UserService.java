package com.multi.di1.service;

import com.multi.di1.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;
    private EmailService emailService;

    // UserRepository 설정자 메서드
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // EmailService 설정자 메서드
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
