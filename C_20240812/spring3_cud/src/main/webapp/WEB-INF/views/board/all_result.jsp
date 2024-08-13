<%@ page import="com.multi.spring3.member.domain.MemberVO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Board CRUD Form</title>
    <link rel="stylesheet" href="../resources/css/out.css">
</head>
<body>

<div class="container">
    <h1>Board List</h1>
    <table>
        <thead>
        <tr>
            <th>NO</th>
            <th>TITLE</th>
            <th>CONTENT</th>
            <th>WRITER</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="board" items="${all}">
            <c:if test="${board != null}">
                <tr>
                    <td>${board.no}</td>
                    <td>${board.title}</td>
                    <td>${board.content}</td>
                    <td>${board.writer}</td>
                </tr>
            </c:if>
            <c:if test="${board == null}">
                <tr>
                    <td colspan="4">No boards found</td>
                </tr>
            </c:if>
        </c:forEach>
            <tr>
                <td colspan="4">
                    <hr color="red">
                    <a href="/board">
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
