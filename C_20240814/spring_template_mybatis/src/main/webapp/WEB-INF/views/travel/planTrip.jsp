<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Plan Your Trip</title>
</head>
<body style="background: pink">
<h1>Plan Your Trip Here</h1>
<hr color="red">
여행 목적지 : <%= request.getAttribute("plan")%><br>
여행 경비 : ${price}원
</body>
</html>
