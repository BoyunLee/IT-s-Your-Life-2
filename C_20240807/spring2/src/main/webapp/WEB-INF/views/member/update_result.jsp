<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    회원 수정한 id는 ${memberVO.id} <br>
    회원 수정한 pw는 ${memberVO.pw} <br>
    회원 수정한 name은 ${memberVO.name} <br>
    회원 수정한 tel은 ${memberVO.tel} <br>
    <hr color="black">
    <a href="/member">
        <img src="../resources/image/member.png" width="150" height="100">
    </a>
    <a href="/">
        <img src="../resources/image/home.png" width="150" height="100">
    </a>
</body>
</html>
