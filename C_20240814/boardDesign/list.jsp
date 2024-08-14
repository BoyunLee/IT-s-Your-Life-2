<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Board List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container">
    <h2 class="text-center mt-5 text-primary">Board List</h2>
    <table class="table table-hover mt-3">
        <thead class="bg-warning text-dark">
        <tr>
            <th scope="col" style="width: 5%;">#</th>
            <th scope="col" style="width: 50%;">Title</th>
            <th scope="col" style="width: 15%;">Author</th>
            <th scope="col" style="width: 15%;">Date</th>
            <th scope="col" style="width: 15%;">Views</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td><a href="#">How to use Bootstrap effectively</a></td>
            <td>John Doe</td>
            <td>2024-08-13</td>
            <td>123</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td><a href="#">Tips for responsive web design</a></td>
            <td>Jane Smith</td>
            <td>2024-08-12</td>
            <td>456</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td><a href="#">Understanding CSS Flexbox</a></td>
            <td>Michael Johnson</td>
            <td>2024-08-11</td>
            <td>789</td>
        </tr>
        <!-- 더 많은 게시글을 여기에 추가할 수 있습니다 -->
        </tbody>
    </table>

    <!-- Pagination -->
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
                <a class="page-link" href="#">Next</a>
            </li>
        </ul>
    </nav>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
