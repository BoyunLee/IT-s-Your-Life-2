package com.example.jsp03.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListener implements
        ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        // 애플리케이션 초기화 로직
        System.out.println("Web application started");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // 애플리케이션 종료 로직
        System.out.println("Web application stopped");
    }
}

