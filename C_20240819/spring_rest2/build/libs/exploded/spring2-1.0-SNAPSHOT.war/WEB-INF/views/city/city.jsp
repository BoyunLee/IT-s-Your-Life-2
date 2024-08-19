<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>City Information Viewer</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <!-- Custom CSS for additional styling -->
    <style>
        body {
            background-color: #f8f9fa;
        }
        .navbar {
            margin-bottom: 30px;
        }
        .card {
            border-radius: 10px;
        }
        #result {
            margin-top: 30px;
        }
    </style>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">City Info Viewer</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col text-center">
            <button id="b1" class="btn btn-outline-primary btn-lg m-2">Get City by ID</button>
            <button id="b2" class="btn btn-outline-secondary btn-lg m-2">Get All Cities (List)</button>
            <button id="b3" class="btn btn-outline-success btn-lg m-2">View All Cities (Table)</button>
        </div>
    </div>
    <div id="result" class="row justify-content-center"></div>
</div>

<script>
    document.getElementById('b1').addEventListener('click', function() {
        /*구현 부분*/
        axios.get('/city/json3')
            .then(function (response){
                var city = response.data;
                var resultDiv = document.getElementById('result');

                resultDiv.innerHTML = '';

                city.forEach(function (city) {
                    var cityElement = document.createElement('div');
                    cityElement.className = 'card p-3 mb-3';
                    cityElement.innerHTML = '<h3><i class="bi bi-building"></i> ' + city.name + '</h3>' +
                        '<p><strong>Country Code:</strong> ' + city.countryCode + '</p>' +
                        '<p><strong>District:</strong> ' + city.district + '</p>' +
                        '<p><strong>Population:</strong> ' + city.population + '</p>';
                    resultDiv.appendChild(cityElement);
                });
            })
            .catch(function (error) {
                console.error('Error fetching the city:', error);
            });
    });

    document.getElementById('b2').addEventListener('click', function() {
        /*구현 부분*/
        axios.get('/city/json4')
            .then(function (response) {
                var cities = response.data;
                var resultDiv = document.getElementById('result');

                resultDiv.innerHTML = '';

                cities.forEach(function (city) {
                    var cityElement = document.createElement('div');
                    cityElement.className = 'card p-3 mb-3';
                    cityElement.innerHTML = '<h3><i class="bi bi-building"></i> ' + city.name + '</h3>' +
                        '<p><strong>Country Code:</strong> ' + city.countryCode + '</p>' +
                        '<p><strong>District:</strong> ' + city.district + '</p>' +
                        '<p><strong>Population:</strong> ' + city.population + '</p>';
                    resultDiv.appendChild(cityElement);
                });
            })
            .catch(function (error) {
                console.error('Error fetching the cities:', error);
            });
    });

    document.getElementById('b3').addEventListener('click', function() {
        /*구현 부분*/
        axios.get('/city/json4')
            .then(function (response) {
                var cities = response.data;
                var resultDiv = document.getElementById('result');

                resultDiv.innerHTML = '';

                var table = document.createElement('table');
                table.className = 'table table-striped';

                var thead = document.createElement('thead');
                thead.innerHTML = '<tr>' +
                    '<th scope="col">#</th>' +
                    '<th scope="col">City Name</th>' +
                    '<th scope="col">Country Code</th>' +
                    '<th scope="col">District</th>' +
                    '<th scope="col">Population</th>' +
                    '</tr>';
                table.appendChild(thead);

                var tbody = document.createElement('tbody');
                cities.forEach(function(city, index) {
                    var row = document.createElement('tr');
                    row.innerHTML = '<th scope="row">' + (index + 1) + '</th>' +
                        '<td><i class="bi bi-geo-alt-fill me-2"></i>' + city.name + '</td>' +
                        '<td>' + city.countryCode + '</td>' +
                        '<td>' + city.district + '</td>' +
                        '<td>' + city.population + '</td>';
                    tbody.appendChild(row);
                });
                table.appendChild(tbody);

                resultDiv.appendChild(table);
            })
            .catch(function (error) {
                console.error('Error fetching the cities:', error);
            });
    });
</script>
<!-- Bootstrap 5 JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
