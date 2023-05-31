<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Session</title>
</head>
<body>
    <h1>Session Object Handling</h1>

    <form action="session" method="post">
        <table>
            <tr>
                <td>firstName : </td>
                <td><input type="text" name="firstName"t></td>
            </tr>
            <tr>
                <td>lastName : </td>
                <td><input type="text" name="lastName"t></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">Send</button>
                </td>
            </tr>
        </table>
    </form>

    <hr>
    <a href="delete">session 데이터 삭제</a>
</body>
</html>