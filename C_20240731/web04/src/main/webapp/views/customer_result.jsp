<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>고객 정보 처리 결과 페이지</title>
</head>
<body>
추가 요청한 고객 정보 : <%= request.getAttribute("customer") %><br>
삭제 요청한 고객 아이디 : <%= request.getAttribute("customer_id") %>
</body>
</html>