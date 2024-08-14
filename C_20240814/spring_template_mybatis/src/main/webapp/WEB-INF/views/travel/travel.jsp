<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Travel Controller Examples</title>
    <style>
        input {
            background: aqua;
        }
        button {
            background: lime;
        }
    </style>
</head>
<body style="background: pink">
<h1>Travel Controller Examples</h1>
<ul>
    <li><a href="travel/city">인기 여행 도시</a></li>
    <li>
        <form action="travel/plan" method="post">
            plan destination : <input name="plan" value="japan"><br>
            plan price : <input name="price" value="1000"><br>
            <button type="submit">여행 계획</button>
        </form>
    </li>
    <li>
        <form action="travel/search" method="get">
            <input type="text" name="keyword" placeholder="Enter keyword" value="seoul">
            <button type="submit">목적지 검색</button>
        </form>
    </li>
    <li><a href="travel/country/Korea/2000">Korea 정보</a></li>
    <li><a href="travel/country/hongkong/1000">hongkong 정보</a></li>
    <li><a href="travel/booking">여행 예약폼</a></li>
</ul>
</body>
</html>
