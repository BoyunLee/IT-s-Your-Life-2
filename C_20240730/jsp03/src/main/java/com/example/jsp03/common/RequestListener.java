package com.example.jsp03.common;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {
    public void requestInitialized(ServletRequestEvent sre) {
        // 요청 초기화 시 로직
        System.out.println("Request initialized: " + sre.getServletRequest().getRemoteAddr());
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        // 요청 종료 시 로직
        System.out.println("Request destroyed: " + sre.getServletRequest().getRemoteAddr());
    }
}
