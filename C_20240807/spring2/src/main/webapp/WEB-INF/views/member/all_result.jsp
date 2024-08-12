<%@ page import="com.multi.spring2.member.domain.MemberVO" %>
<%@ page import="java.util.List" %>
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
    <h1>Member List</h1>
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
        <%
            List<MemberVO> members = (List<MemberVO>) request.getAttribute("all");
            if (members != null) {
                for (MemberVO member : members) {
        %>
        <tr>
            <td><%= member.getId() %></td>
            <td><%= member.getPw() %></td>
            <td><%= member.getName() %></td>
            <td><%= member.getTel() %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="4">No members found</td>
        </tr>
        <%
            }
        %>
        <tr>
            <td colspan="4">
                <hr color="black">
                <a href="/member">
                    <img src="../resources/image/member.png" width="150" height="100">
                </a>
                <a href="/">
                    <img src="../resources/image/home.png" width="150" height="100">
                </a>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
