<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Controller Examples</title>
</head>
<body>
<h1>Controller Examples</h1>
<ul>
    <li><a href="travel/destination">Travel Destination</a></li>
    <li><a href="travel/city">Travel City</a></li>
    <li>
        <form action="travel/plan" method="post">
            <button type="submit">Plan Trip</button>
        </form>
    </li>
    <li>
        <form action="travel/search" method="get">
            <input type="text" name="keyword" placeholder="Enter keyword">
            <button type="submit">Search Destination</button>
        </form>
    </li>
    <li><a href="travel/country/Korea">Country Info: Korea</a></li>
    <li><a href="travel/country/unknown">Country Info: Unknown</a></li>
    <li><a href="travel/booking">Booking Form</a></li>
    <li>
        <form action="finance/loan" method="post">
            <input type="text" name="applicantName" placeholder="Applicant Name">
            <input type="text" name="amount" placeholder="Amount">
            <button type="submit">Apply for Loan</button>
        </form>
    </li>
    <li>
        <form action="finance/loanStatus" method="get">
            <input type="text" name="loanId" placeholder="Enter Loan ID">
            <button type="submit">Check Loan Status</button>
        </form>
    </li>
    <li>
        <form action="finance/balance" method="get">
            <input type="text" name="accountId" placeholder="Enter Account ID">
            <button type="submit">Check Balance</button>
        </form>
    </li>
    <li><a href="finance/transfer">Transfer Form</a></li>
</ul>
</body>
</html>
