<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    // db와 연동해서 로그인 성공하면 세션을 설정
    session.setAttribute("userId", "apple");
%>
<a href="sessionGet.jsp">세션 값 확인</a>
</body>
</html>

