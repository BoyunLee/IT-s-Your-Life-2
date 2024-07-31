
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<center>
    <h1>회원가입</h1>
    <hr>
    <form action="insertUser.do" method="post">
        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td bgcolor="orange" width="90">아이디</td>
                <td><input type="text" name="id" size="12"/></td>
            </tr>
            <tr>
                <td bgcolor="orange">비밀번호</td>
                <td><input type="password" name="password" size="12"/></td>
            </tr>
            <tr>
                <td bgcolor="orange">이름</td>
                <td><input type="text" name="name" size="30"/></td>
            </tr>
            <tr>
                <td bgcolor="orange">권한</td>
                <td>
                    <input type="radio" name="role" value="USER" checked/>USER
                    <input type="radio" name="role" value="ADMIN"/>ADMIN
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
