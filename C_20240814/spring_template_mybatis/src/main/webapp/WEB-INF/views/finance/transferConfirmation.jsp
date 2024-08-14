<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Transfer Confirmation</title>
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
<h1>Transfer Confirmation</h1>
<p>From Account: ${transfer.accountFrom}</p>
<p>To Account: ${transfer.accountTo}</p>
<p>Amount: ${transfer.amount}</p>
</body>
</html>
