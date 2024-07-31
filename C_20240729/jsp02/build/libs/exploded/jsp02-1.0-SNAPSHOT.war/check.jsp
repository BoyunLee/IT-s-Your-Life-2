<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>get요청(날씨)</h3>
<form action="check.do" method="get">
    <select name="today">
        <option value="맑음">해가쨍쟁</option>
        <option value="흐림">구름잔뜩</option>
        <option value="비옴">우산준비</option>
    </select>
    <button type="submit">서버로 전송</button>
</form>

<hr color="red">
<h3>post요청(출입문 암호)</h3>
<form action="check.do" method="post">
    오늘의 출입문 암호는(나는왕이다) <br>
    입력 <input name="pass" value="나는퀸이다."><br>
      <button type="submit">서버로 전송</button>
</form>
</body>
</html>
