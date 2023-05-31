<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Forward</title>
</head>
<body>
    <h1>forward</h1>
    <form action="forward" method="post">
        <table>
            <tr>
                <td>ID : </td>
                <td><input type="text" name="userId"></td>
                <td rowspan="2"><button type="submit">Log-in</button></td>
            </tr>
            <tr>
                <td>Password : </td>
                <td><input type="password" name="password"></td>
            </tr>
        </table>
    </form>
</body>
</html>