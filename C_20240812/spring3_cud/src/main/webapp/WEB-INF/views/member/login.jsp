<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Member CRUD Form</title>
    <link rel="stylesheet" href="../resources/css/out.css">
</head>
<body>
<div class="container">
    <h2>Member login Form</h2>

    <!-- Member Table -->
    <table>
        <thead>
        <tr>
            <th>항목명</th>
            <th>입력폼</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="center">로그인</td>
            <td>
                <!-- Member Login Form -->
                <form action="loginProcess" method="post">
                    <label for="id">ID</label>
                    <input type="text" id="id" name="id" value="apple" required>
                    <label for="pw">Password</label>
                    <input type="password" id="pw" name="pw" value="1234" required>
                    <button type="submit">login Member</button>
                </form>
            </td>
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
