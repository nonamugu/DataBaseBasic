<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Ajax</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
    <h1>ajax 요청 후 stream을 이용한 문자열 응담</h1>

    <h2>1. GET 방식의 데이터 요청</h2>

    <h3>1-1. 데이터 전송 없이 문자열 반환</h3>
    <button id="send-get-1">Send</button>
    <script>
        $("#send-get-1").click(function() {

            $.ajax({
                url: "/chap03/first/receive",
                type: "get",
                success: function(data, textStatus, xhr) {
                    alert(data);
                },
                error: function(xhr, status, error) {
                    console.log(error);
                }
            });

        });


    </script>

    <h3>1-2. data로 값 전송 후 문자열 반환</h3>
    <input type="text" id="message-get-2"><button id="send-get-2">Send message</button>
    <script>
        $("#send-get-2").click(function() {

            $.ajax({
                url: "/chap03/first/message",
                type: "get",
                data: { message : message },
                success: function(data, textStatus, xhr) {
                    alert(data);
                },
                error: function(xhr, status, error) {
                    console.log(error);
                }
            });

        });


    </script>

    <h2>2. POST 방식의 데이터 요청</h2>

    <h3>2-1. 데이터 전송 없이 문자열 반환</h3>
    <button id="send-post-1">Send</button>
    <script>
        $("#send-post-1").click(function() {
            $.ajax({
                url: "/chap03/first/receive",
                type: "post",
                success: function(data, textStatus, xhr) {
                    alert(data);
                },
                error: function(xhr, status, error) {
                    console.log(error);
                }
            });
        });
    </script>

    <h3>2-2. data로 값 전송 후 문자열 반환</h3>
    <input type="text" id="message-post-2"><button id="send-post-2">Send message</button>
    <script>
        $("#send-post-2").click(function() {
            const message = $("#message-post-2").val();

            $.ajax({
                url: "/chap03/first/message",
                type: "post",
                data: { message : message },
                success: function(data, textStatus, xhr) {
                    alert(data);
                },
                error: function(xhr, status, error) {
                    console.log(error);
                }
            });

        });
    </script>


</body>
</html>