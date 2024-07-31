<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
세션 값 확인:
<%
    //세션 값 확인
    String loginId = (String)session.getAttribute("loginId");
    out.print(loginId);

%>
<hr color="red">
</body>
</html>
