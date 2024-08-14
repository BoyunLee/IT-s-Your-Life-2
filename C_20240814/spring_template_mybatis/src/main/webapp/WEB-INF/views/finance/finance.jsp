<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Finance Controller Examples</title>
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
<h1>Finance Controller Examples</h1>
<ul>
    <li>
            <label for="applicantName">신청자 이름:</label>
            <input type="text" id="applicantName" name="applicantName" value="best" required>
            <br>
            <label for="amount">대출 금액:</label>
            <input type="number" id="amount" name="amount" value="1000" required>
            <br>
            <label for="term">기간(years):</label>
            <input type="number" id="term" name="term" value="2" required>
            <br>
            <button type="button" id="button">Apply for Loan</button>

        <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
        <script>
            document.getElementById('button').addEventListener('click', function(event) {
              //  event.preventDefault();

                const applicantName = document.getElementById('applicantName').value;
                const amount = document.getElementById('amount').value;
                const term = document.getElementById('term').value;
                console.log(applicantName + " " + amount + " " + term);

                axios.post('/finance/loan', {
                    applicantName: applicantName,
                    amount: amount,
                    term: term
                }, {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }).then(function (response) {
                    console.log(response.data);
                    alert(response.data);
                }).catch(function (error) {
                    console.log('There was an error!'+ error);
                });
            });
        </script>
    </li>
    <li>
        <form id="form2" method="get">
            <input type="text" id="loanId" value="100" placeholder="Enter Loan ID">
            <button type="submit">Check Loan Status</button>
        </form>
        <script>
            document.getElementById('form2').addEventListener('submit', function(event) {
                event.preventDefault();

                const loanId = document.getElementById('loanId').value;

                axios.get('/finance/loanStatus', {
                    params : {
                        loanId: loanId
                    },
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }).then(function (response) {
                    console.log(response.data.loanId +  " " + response.data.status);
                    alert(response.data.loanId +  " " + response.data.status);
                }).catch(function (error) {
                    console.log('There was an error!'+ error);
                });
            });
        </script>
    </li>
    <li>
        <form action="/finance/balance" method="get">
            <input type="text" name="accountId" value="200" placeholder="Enter Account ID">
            <button type="submit">Check Balance</button>
        </form>
    </li>
    <li><a href="/finance/transfer">계좌이체 폼</a></li>
</ul>
</body>
</html>
