<%@ page import="com.multi.spring3.member.domain.MemberVO" %>
<%@ page import="java.util.List" %>
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

<div class="container">
    <h1>Member find List</h1>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Password</th>
            <th>Name</th>
            <th>Telephone</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="member" items="${all}">
            <c:if test="${member != null}">
                <tr>
                    <td>${member.id}</td>
                    <td>${member.pw}</td>
                    <td>${member.name}</td>
                    <td>${member.tel}</td>
                </tr>
            </c:if>
            <c:if test="${member == null}">
                <tr>
                    <td colspan="4">No members found</td>
                </tr>
            </c:if>
        </c:forEach>
            <tr>
                <td colspan="4">
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
