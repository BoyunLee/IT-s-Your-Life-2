<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Bank Chatbot</title>
  <script type="text/javascript"
          src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
  <script
          src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <script type="text/javascript" src="resources/js/sockjs-0.3.4.js"></script>
  <script type="text/javascript" src="resources/js/stomp.js"></script>
  <script type="text/javascript">
    var stompClient = null;

    function setConnected(connected) {
      document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
      document.getElementById('response').innerHTML = '';
    }

    function connect() {
      var socket = new SockJS('${pageContext.request.contextPath}/chat2');
      stompClient = Stomp.over(socket);

      stompClient.connect({}, function(frame) {
        setConnected(true);
        alert('연결됨. ' + frame);
        stompClient.subscribe('/topic/messages2', function(messageOutput) {
          showMessageOutput(JSON.parse(messageOutput.body));
        });
      });
    }

    function sendMessage() {
      var from = "guest";
      var text = document.getElementById('text').value;
      stompClient.send("/app/chat2", {}, JSON.stringify({
        'from' : from,
        'text' : text
      }));
    }

    function showMessageOutput(messageOutput) {
      var response = document.getElementById('response');
      var p = document.createElement('p');
      p.style.wordWrap = 'break-word';
      p.appendChild(document.createTextNode(messageOutput.menu));
      response.appendChild(p);
    }

    function disconnect() {
      if (stompClient != null) {
        stompClient.disconnect();
      }
      setConnected(false);
      console.log("Disconnected");
    }

    // 엔터키를 감지하여 메시지 전송 함수 호출
    function checkEnter(event) {
      if (event.key === "Enter") {
        sendMessage();
      }
    }
  </script>
</head>
<body onload="connect();">
<br>
<br>
<img src="resources/image/chat1.png" width="100" height="100"><img src="resources/image/chat4.png" width="400" height="100">
<div class="alert alert-primary" style="width: 500px;">
  <div>챗 봇>> 1) 은행거래 2) 대출거래</div>
  <br>
  <div id="response">

  </div>
  <div class="form-floating mb-3 mt-3" id="conversationDiv">
    <table>
      <tr>
        <!-- input 필드에 onkeypress 이벤트 추가 -->
        <td><input type="text" class="form-control" id="text" style="width: 400px; background: yellow"
                   onkeypress="checkEnter(event)"></td>
        <td><button id="sendMessage" onclick="sendMessage();"class="btn btn-primary">Send</button></td>
      </tr>
    </table>
  </div>
</div>
</body>
</html>
