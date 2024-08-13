<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Member CRUD Form</title>
    <link rel="stylesheet" href="../resources/css/out.css">
</head>
<body>
<div class="container">
    <h2>Member CRUD Form</h2>

    <!-- Member Table -->
    <table>
        <thead>
        <tr>
            <th>항목명</th>
            <th>입력폼</th>
        </tr>
        </thead>
        <tbody>
        <!-- Sample data row for demonstration -->
        <tr>
            <td class="center">회원가입</td>
            <td>
                <!-- Member Insert Form -->
                <form action="member/insert" method="post">
                    <label for="id">ID</label>
                    <input type="text" id="id" name="id" value="apple" required>
                    <label for="pw">Password</label>
                    <input type="password" id="pw" name="pw" value="1234" required>
                    <label for="name">Name</label>
                    <input type="text" id="name" name="name" value="apple">
                    <label for="tel">Telephone</label>
                    <input type="text" id="tel" name="tel" value="011">
                    <button type="submit">Add Member</button>
                </form>
            </td>
        </tr>
        <tr>
            <td class="center">회원탈퇴</td>
            <td>
                <!-- Member Delete Form -->
                <form action="member/delete" method="post">
                    <input type="text" name="id" value="apple">
                    <button type="submit" class="btn-edit">Delete Member</button>
                </form>
            </td>
        </tr>
        <tr>
            <td class="center">회원정보 수정</td>
            <td>
                <!-- Member Update Form -->
                <form action="member/update" method="post">
                    <label for="id">Update Member by ID</label>
                    <input type="text" id="id" name="id" required>
                    <label for="tel">New Telephone</label>
                    <input type="text" id="tel" name="tel">
                    <button type="submit">Update Member</button>
                </form>
            </td>
        </tr>
        <tr>
            <td class="center">회원정보 검색</td>
            <td>
                <!-- Member Search Form -->
                <form action="member/one" method="get">
                    <label for="id">Search Member by ID</label>
                    <input type="text" name="id" value="apple" required>
                    <button type="submit">Search</button>
                </form>
            </td>
        </tr>
        <tr>
            <td class="center">회원 전체 검색</td>
            <td>
                <!-- Member All -->
                <a href="member/all">
                    <button>Search All</button>
                </a>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
