<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 광고 추적 쿠키 설정
    String cookieName = "adTracker";
    String cookieValue = "user12345"; // 사용자 고유 식별자
    int maxAge = 60 * 60 * 24 * 30; // 쿠키 유효기간 30일
    //int maxAge = 0;
    Cookie adCookie = new Cookie(cookieName, cookieValue);
    adCookie.setMaxAge(maxAge);
    response.addCookie(adCookie);
%>
<html>
<head>
    <title>쿠키 설정</title>
</head>
<body>
<h1>광고 추적 쿠키가 설정되었습니다.</h1>
</body>
</html>

