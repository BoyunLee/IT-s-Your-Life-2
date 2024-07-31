<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>게시판 정보 처리 결과를 담는 페이지</title>
</head>
<body>
게시판 정보 : <%= request.getAttribute("board")%>
<hr color="blue">
삭제 요청한 아이디 : <%= request.getAttribute("board_id") %><br>
</body>
</html>