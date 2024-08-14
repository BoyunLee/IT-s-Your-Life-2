<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>City Information</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">City Information</h2>

    <!-- City Insert Form -->
    <div class="card mb-4">
        <div class="card-header">
            <h3>Add City</h3>
        </div>
        <div class="card-body">
            <form action="city/insert" method="post" class="row g-3">
                <div class="table-responsive">
                    <table class="table table-bordered table-header">
                        <tbody>
                        <tr>
                            <td class="col-md-3">
                                <label for="name" class="form-label">Name</label>
                                <input type="text" id="name" name="name" class="form-control" required>
                            </td>
                            <td class="col-md-3">
                                <label for="countryCode" class="form-label">Country Code</label>
                                <input type="text" id="countryCode" name="countryCode" class="form-control" required>
                            </td>
                        </tr>
                        <tr>
                            <td class="col-md-3">
                                <label for="district" class="form-label">District</label>
                                <input type="text" id="district" name="district" class="form-control" required>
                            </td>
                            <td class="col-md-3">
                                <label for="population" class="form-label">Population</label>
                                <input type="number" id="population" name="population" class="form-control" required>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-success">Add City</button>
                </div>
            </form>

        </div>
    </div>

    <!-- City List Link -->
    <div class="card">
        <div class="card-header">
            <h3>City List</h3>
        </div>
        <div class="card-body">
            <a href="city/all" class="btn btn-secondary">Search All Cities</a>
        </div>
    </div>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
