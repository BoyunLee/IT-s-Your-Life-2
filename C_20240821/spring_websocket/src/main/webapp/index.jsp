<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Index Page</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <h1 class="text-center mb-5">Welcome to the Chat Application</h1>

  <div class="row justify-content-center">
    <div class="col-md-4">
      <div class="card">
        <div class="card-body text-center">
          <h5 class="card-title">My Shop ChatBot</h5>
          <p class="card-text">Interact with our shop's chatbot to get help with your queries.</p>
          <a href="myShopChatBot.jsp" class="btn btn-primary">Go to My Shop ChatBot</a>
        </div>
      </div>
    </div>

    <div class="col-md-4">
      <div class="card">
        <div class="card-body text-center">
          <h5 class="card-title">Real Chat</h5>
          <p class="card-text">Join the real-time chat and start communicating with others now.</p>
          <a href="realChat.jsp" class="btn btn-success">Go to Real Chat</a>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
