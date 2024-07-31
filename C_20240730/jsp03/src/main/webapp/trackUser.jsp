<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 광고 추적 쿠키 읽기
    Cookie[] cookies = request.getCookies();
    String adTracker = null;

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("adTracker")) {
                adTracker = cookie.getValue();
                break;
            }
        }
    }

    if (adTracker != null) {
        // 사용자가 방문했음을 추적
        out.println("<h1>환영합니다, 사용자 " + adTracker + "!</h1>");
        out.println("<p>당신의 활동을 추적하고 있습니다.</p>");
    } else {
        out.println("<h1>환영합니다, 새로운 사용자!</h1>");
        out.println("<p>당신의 광고 추적 쿠키가 없습니다.</p>");
    }
%>
<html>
<head>
    <title>사용자 추적</title>
</head>
<body>
</body>
</html>

