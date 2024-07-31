<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원정보 처리 결과를 담는 페이지</title>
</head>
<body>
<br>
<hr color="blue">

<h3>insert 정보</h3>
insertion member : <%= request.getAttribute("member")%>

<hr color="red">

<h3>delete 정보</h3>
deletion member_id : <%= request.getAttribute("member_id")%>
</body>
</html>
