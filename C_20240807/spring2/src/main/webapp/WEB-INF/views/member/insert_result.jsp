<%@ page import="com.multi.spring2.member.domain.MemberVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Member CRUD Form</title>
    <link rel="stylesheet" href="../resources/css/out.css">
</head>
<body>
    <%
        String result = (String)request.getAttribute("result");
    %>
    <h3>insert_result : <%= result %></h3>

    회원 가입한 id는 ${memberVO.id} <br>
    회원 가입한 pw는 ${memberVO.pw} <br>
    회원 가입한 name은 ${memberVO.name} <br>
    회원 가입한 tel은 ${memberVO.tel} <br>

    <hr color="black">
    <a href="/member">
        <img src="../resources/image/member.png" width="150" height="100">
    </a>
    <a href="/">
        <img src="../resources/image/home.png" width="150" height="100">
    </a>
    <%--<%
        MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
        String result = (String) request.getAttribute("result");
    %>
    회원가입한 결과는 <%= result%> <br>
    회원 가입한 id는 <%= memberVO.getId()%> <br>
    회원 가입한 pw는 <%= memberVO.getPw()%> <br>
    회원 가입한 name은 <%= memberVO.getName()%> <br>
    회원 가입한 tel은 <%= memberVO.getTel()%> <br>

    <hr color="red">
    회원가입한 결과는 ${result} <br>
    회원 가입한 id는 ${memberVO.id} <br> &lt;%&ndash;memberVO.getId()&ndash;%&gt;
    회원 가입한 pw는 ${memberVO.pw} <br>
    회원 가입한 name은 ${memberVO.name} <br>
    회원 가입한 tel은 ${memberVO.tel} <br>--%>
</body>
</html>
