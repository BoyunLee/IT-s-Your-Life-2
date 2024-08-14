<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Transfer Form</title>
    <style>
        input {
            background: aqua;
        }
        button {
            background: lime;
        }
        body {
            background: beige;
        }
    </style>
</head>
<body>
<h1>Transfer Form(계좌이체)</h1>
<form id="transferForm" action="/finance/transfer" method="post">
    From Account: <input type="text" id="accountFrom" name="accountFrom" value="apple"/><br/>
    To Account: <input type="text" id="accountTo" name="accountTo" value="spring"/><br/>
    Amount: <input type="number" id="amount" name="amount" value="10000"/><br/>
    <button type="submit">Submit</button>
</form>
</body>
</html>
