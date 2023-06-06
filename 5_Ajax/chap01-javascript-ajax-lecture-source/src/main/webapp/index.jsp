<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Javascript Ajax</title>
</head>
<body>
    <h1>javascript ajax</h1>

    <h3>simple string ajax</h3>
    <input type="text" name="name" id="param">
    <button onclick="sendName();">서버로 전송</button>
    <br>
    <p id="result"></p>

    <script>
        function sendName() {
            console.log("sendName() start");
            const httpRequest = new XMLHttpRequest();
            const serverAddress = "/chap01/javascript";

            httpRequest.onreadystatechange = function () {
                console.log("onreadystatechange function 동작");
                console.log(httpRequest.readyState);
                if(httpRequest.readyState === XMLHttpRequest.DONE) {
                    if(httpRequest.status === 200) {
                        console.log("정상 응답");
                        document.getElementById("result").innerHTML = httpRequest.responseText;
                    } else {

                    }

                }

            }
            let name = document.getElementById("param").value;
            console.log("param 값 설정");
            httpRequest.open("GET", serverAddress + "?name=" + name);
            console.log("open() 완료");
            httpRequest.send();
            console.log("send() 완료");
        }
    </script>


</body>
</html>