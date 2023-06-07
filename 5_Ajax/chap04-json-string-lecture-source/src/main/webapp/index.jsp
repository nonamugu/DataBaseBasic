<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Json String</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
    <h1>Ajax 요청 후 Stream을 이용한 json 응답 (simple json string)</h1>

    <h2>JSON 데이터 요청</h2>

    <h3>1-1. 데이터 전송 없이 json 반환</h3>
    <button id="send-get-1">Send</button>
    <script>
        $("#send-get-1").click(function() {
           $.ajax({
               url: "/chap04/receive/json",
               type: "get",
               success: function(data, textStatus, xhr) {
                   console.log(data);

                   let jsonObject = JSON.parse(data);
                   console.log(jsonObject);
               },
               error: function (xhr, status, error) {
                   console.log(error);
               }

           });
        });
    </script>

    <h3>1-2. 데이터 전송 없이 jsonArray 반환</h3>
    <button id="send-get-2">Send</button>
    <script>
        $("#send-get-2").click(function() {
           $.ajax({
               url: "/chap04/receive/array",
               type: "get",
               success: function(data, textStatus, xhr) {
                 console.table(data);

                 let jsonObject = JSON.parse(data);

                 console.table(jsonObject);
               },
               error: function(xhr, status, error) {
                   console.log(error);
               }
           });
        });
    </script>
    <h3>1-3. 데이터 전송 없이 응답 헤더를 설정 후 jsonArray 반환</h3>
    <button id="send-get-3">Send</button>
    <script>
        $("#send-get-3").click(function() {
           $.ajax({
              url: "/chap04/receive/jsonarray",
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