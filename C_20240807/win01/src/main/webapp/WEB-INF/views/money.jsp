<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>재정 상태</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f0f8ff;
      font-family: Arial, sans-serif;
    }
    .container {
      margin-top: 50px;
      text-align: center;
    }
    .result-box {
      margin-top: 20px;
      padding: 20px;
      background-color: #fff;
      border-radius: 10px;
      box-shadow: 0 4px 6px rgba(0,0,0,0.1);
      display: inline-block;
    }
    h1 {
      margin-bottom: 30px;
    }
    .result-box h2 {
      color: #333;
    }
    .btn-custom {
      background-color: #4CAF50;
      color: white;
      border: none;
      padding: 10px 20px;
      border-radius: 5px;
      font-size: 1.1em;
      transition: background-color 0.3s;
    }
    .btn-custom:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
<div class="container">
  <%
    String result = (String) request.getAttribute("result");
  %>
  <h1>재정 상태 결과</h1>
  <div class="result-box"><h2><%= result %></h2></div>
  <div style="margin-top: 20px;">
    <a href="money?money=15000"><button class="btn-custom">샘플 요청(15,000)</button></a>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
