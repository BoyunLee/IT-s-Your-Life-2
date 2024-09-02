<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">
        /* Javascript 샘플 코드 */


        var xhr = new XMLHttpRequest();
        var url = 'http://apis.data.go.kr/4050000/apt/getApt'; /*URL*/
        var queryParams = '?' + encodeURIComponent('serviceKey') + '='+'63Jk4KYSAeT0Kif97Z6jQm7H4vk6jMJSJ29jfJB4wMtKA%2FDfN7igbdpFRmXbS%2BfopaXmPMqvIhJWeVLeuy2DXw%3D%3D'; /*Service Key*/
        queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('3'); /**/
        queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('5'); /**/
        queryParams += '&' + encodeURIComponent('cmplx_nm') + '=' + encodeURIComponent(''); /**/
        queryParams += '&' + encodeURIComponent('gu') + '=' + encodeURIComponent(''); /**/
        queryParams += '&' + encodeURIComponent('dong') + '=' + encodeURIComponent(''); /**/
        xhr.open('GET', url + queryParams);
        xhr.onreadystatechange = function () {
            if (this.readyState == 4) {
                console.log('Status: '+this.status+'nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+'nBody: '+this.responseText);
            }
        };

        xhr.send('');

    </script>
</head>
<body>

</body>
</html>
