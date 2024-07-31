<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    // 세션 값 설정
    session.setAttribute("loginId", "apple");
%>
세션 값을 서버에 저장했습니다.
<hr color="red">
<a href="sessionGet.jsp">세션값보기</a>

</body>
</html>

