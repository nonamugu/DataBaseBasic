<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JQuery Ajax</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
    <h1>jQuery ajax</h1>

    <h3>simple string ajax</h3>
    <input type="text" name="name" id="param">
    <button id="sendServer">서버로 전송</button>
    <br>
    <p id="result"></p>

    <script>
        $("#sendServer").click(function() {

            const name = $("#param").val();

            $.ajax({
                url: "/chap02/jquery",
                data: { name : name },
                method: "GET",
                success: function(data, textStatus, xhr) {
                    $("#result").text(data);
                    console.log(textStatus);
                    console.log(xhr);
                },
                error: function(xhr, status, error) {
                    console.log(xhr);
                    console.log(status);
                    console.log(error);
                }
            });

        });
    </script>

</body>
</html>