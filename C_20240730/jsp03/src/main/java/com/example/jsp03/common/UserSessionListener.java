package com.example.jsp03.common;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class UserSessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
        // 세션 생성 시 로직
        System.out.println("Session created: " + se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        // 세션 종료 시 로직
        System.out.println("Session destroyed: " + se.getSession().getId());
    }
}
