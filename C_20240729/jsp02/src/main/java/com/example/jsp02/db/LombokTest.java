package com.example.jsp02.db;

public class LombokTest {
    public static void main(String[] args) {
        UserVO userVO2 = new UserVO();
        userVO2.setId("hello");
        userVO2.setName("hello");
        System.out.println(userVO2.getId());
        System.out.println(userVO2.getName());
    }
}

