<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="second?name=나는한글이란다이름이&choice=time">get요청</a>
<form action="second" method="post">
    아이디 <input name="id" value="나는한글이란다가아이디가"><br>
    패스워드 <input name="pw" value="1234"><br>
    <button type="submit">서버로 전송</button>
</form>
</body>
</html>
