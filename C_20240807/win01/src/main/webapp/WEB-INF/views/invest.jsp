<%@ page import="com.multi.win01.domain.FinanceVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>투자 정보</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f8f9fa;
      font-family: Arial, sans-serif;
    }
    .container {
      margin-top: 50px;
    }
    h1 {
      margin-bottom: 30px;
    }
    .table {
      margin-top: 20px;
      background-color: #fff;
      border-radius: 10px;
      box-shadow: 0 4px 6px rgba(0,0,0,0.1);
    }
    .table th, .table td {
      vertical-align: middle;
    }
  </style>
</head>
<body>
<div class="container">
  <h1 class="text-center">투자 정보</h1>
  <table class="table table-bordered table-hover">
    <thead class="thead-dark">
    <tr>
      <th scope="col">항목</th>
      <th scope="col">내용</th>
    </tr>
    </thead>
    <tbody>
    <%
      FinanceVO financeVO = (FinanceVO) request.getAttribute("finance");
    %>
    <tr>
      <th scope="row">ID</th>
      <td><%= financeVO.getFinanceId() %></td>
    </tr>
    <tr>
      <th scope="row">제목</th>
      <td><%= financeVO.getTitle() %></td>
    </tr>
    <tr>
      <th scope="row">내용</th>
      <td><%= financeVO.getContent() %></td>
    </tr>
    <tr>
      <th scope="row">분야</th>
      <td><%= financeVO.getField() %></td>
    </tr>
    <tr>
      <th scope="row">금액</th>
      <td><%= financeVO.getAmount() %></td>
    </tr>
    </tbody>
</table>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
