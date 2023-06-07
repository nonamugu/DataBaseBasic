<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Object Receive</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
    <h1>Ajax 요청 후 stream을 이용한 json 응답 (toString overriding)</h1>

    <h2>Java Object 응답 받기</h2>
    <button id="send-get-1">Send</button>
    <script>
        $("#send-get-1").click(function() {
           $.ajax({
               url: "/chap05/receive/override",
               type: "get",
               success: function(data, textStatus, xhr) {
                   console.table(data)
               },
               error: function(xhr, status, error) {
                   console.log(error)
               }
           });
        });
    </script>

    <h3>1-2. 데이터 전송 없이 jsonArray 반환</h3>
    <button id="send-get-2">Send</button>
    <script>
        $("#send-get-2").click(function() {
            $.ajax({
                url: "/chap05/receive/list",
                type: "get",
                success: function(data, textStatus, xhr) {
                    console.table(data);
                },
                error: function(xhr, status, error) {
                    console.log(error);
                }
            });
        });
    </script>

    <h3>1-3. 데이터 전송 없이 hashMap 반환</h3>
    <button id="send-get-3">Send</button>
    <script>
        $("#send-get-3").click(function() {
           $.ajax({
               url: "/chap05/receive/map",
               type: "get",
               success: function(data, textStatus, xhr) {
                   console.table(data);
               },
               error: function(xhr, status, error) {
                   console.log(error);
               }
           });
        });
    </script>

</body>
</html>