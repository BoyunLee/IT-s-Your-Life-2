<%@ page import="com.example.win00.domain.BoardVO" %><%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-08-06
  Time: 오후 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>One</title>
</head>
<body>
<h1>Member Information</h1>

<%
    BoardVO boardVO = (BoardVO) request.getAttribute("boardVO");
%>
검색된 결과 no는 <%= boardVO.getNo() %> <br>
검색된 결과 title는 <%= boardVO.getTitle() %> <br>
검색된 결과 content는 <%= boardVO.getContent() %> <br>
검색된 결과 writer는 <%= boardVO.getWriter() %> <br>

<%--검색된 결과 no는 ${board.no} <br>
검색된 결과 title는 ${board.title} <br>
검색된 결과 content는 ${board.content} <br>
검색된 결과 writer는 ${board.writer} <br>--%>

</body>
</html>
