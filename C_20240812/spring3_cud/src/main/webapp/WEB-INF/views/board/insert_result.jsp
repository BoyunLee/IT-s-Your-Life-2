<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Board CRUD Form</title>
    <link rel="stylesheet" href="../resources/css/out.css">
</head>
<body>
<%
    String result = (String)request.getAttribute("result");
%>
    <h3>insert_result : <%= result %></h3>
<hr color="red">
<a href="/board">
    <img src="../resources/image/member.png" width="300" height="200">
</a>
<a href="/">
    <img src="../resources/image/home.png" width="300" height="200">
</a>
<hr color="red">
</body>
</html>
