<%@ page import="com.multi.spring2.board.domain.BoardVO" %>
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
    BoardVO vo = (BoardVO)request.getAttribute("boardVO");
%>
<div class="container">

    <h2>게시판 정보 확인</h2>
    <table>
        <thead>
        <tr>
            <th>항목명</th>
            <th>항목값</th>
        </tr>
        </thead>
         <tbody>
        <tr>
            <td>게시판 NO</td>
            <td><%= vo.getNo() %></td>
        </tr>
        <tr>
            <td>게시판 TITLE</td>
            <td><%= vo.getTitle() %></td>
        </tr>
        <tr>
            <td>게시판 CONTENT</td>
            <td><%= vo.getContent() %></td>
        </tr>
        <tr>
            <td>게시판 WRITER</td>
            <td><%= vo.getWriter() %></td>
        </tr>
         <tr>
             <td colspan="2">
                 <hr color="red">
                 <a href="/board">
                     <img src="../resources/image/board.png" width="300" height="200">
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
