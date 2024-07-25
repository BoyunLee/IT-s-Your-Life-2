<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 24. 7. 25.
  Time: 오후 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img src="/login.png" width="250" height="250">
<form action="/loginProcess" method="post">
    <table border = "1">
        <tr>
            <td>아이디</td>
            <td>
                <input type="text" name="id" value="apple">
            </td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td>
                <input type="text" name="pw" value="1234">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">로그인 처리 요청</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
