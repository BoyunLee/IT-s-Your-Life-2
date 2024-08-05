<%@ page import="org.example.spring00.domain.HomeVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Member Info</title>
</head>
<body>
<h1>Member Information</h1>
<%
  HomeVO homeVO = (HomeVO) request.getAttribute("homeVO");
  if (homeVO != null) {
%>
<p>ID: <%= homeVO.getId() %></p>
<p>Name: <%= homeVO.getName() %></p>
<% } %>

</body>
</html>
