<%@ page import="com.multi.spring3.member.domain.MemberVO" %>
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
    MemberVO memberVO = (MemberVO)request.getAttribute("memberVO");
%>
<div class="container">

    <h2>가입한 정보 확인</h2>
    <c:if test="${not empty sessionScope.login_id}">
        <a href="logout">logout</a>
    </c:if>
    <table>
        <thead>
        <tr>
            <th>항목명</th>
            <th>항목값</th>
        </tr>
        </thead>
         <tbody>
        <tr>
            <td>가입한 ID</td>
            <td><%= memberVO.getId()%></td>
        </tr>
        <tr>
            <td>가입한 PW</td>
            <td><%= memberVO.getPw()%></td>
        </tr>
        <tr>
            <td>가입한 NAME</td>
            <td><%= memberVO.getName()%></td>
        </tr>
        <tr>
            <td>가입한 TEL</td>
            <td><%= memberVO.getTel()%></td>
        </tr>
         <tr>
             <td colspan="2">
                 <hr color="red">
                 <a href="/member">
                     <img src="../resources/image/member.png" width="300" height="200">
                 </a>
                 <a href="/">
                     <img src="../resources/image/home.png" width="300" height="200">
                 </a>
                 <hr color="red">
             </td>
         </tr>
        </tbody>
    </table>
</div>
</body>
</html>
