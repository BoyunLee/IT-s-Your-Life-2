<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            <h1 class="card-title">Edit User</h1>
        </div>
        <div class="card-body">
            <form action="user?action=update" method="post">
                <input type="hidden" name="id" value="${user.id}">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" name="name" id="name" value="${user.name}" required>
                </div>
                <div class="form-group">
                    <label for="age">Age:</label>
                    <input type="number" class="form-control" name="age" id="age" value="${user.age}" required>
                </div>
                <div class="d-flex justify-content-center mt-3">
                    <div class="btn-group" role="group">
                        <button type="submit" class="btn btn-primary">Update</button>
                        <a href="user?action=list" class="btn btn-secondary">Back to list</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

