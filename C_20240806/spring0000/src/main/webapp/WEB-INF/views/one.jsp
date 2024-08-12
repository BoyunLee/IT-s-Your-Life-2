<%@ page import="org.example.spring0000.domain.HomeVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background: yellow;
        }
    </style>
</head>
<body>
<h1>회원검색 처리 결과 페이지</h1>
<%
    HomeVO homeVO = (HomeVO) request.getAttribute("homeVO");
%>
아이디 : <%= homeVO.getId()%> <br>
이름 : <%= homeVO.getName()%>
</body>
</html>
