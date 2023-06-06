<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>EL & JSTL</title>
</head>
<body>
    <h1>JSP Action Tag</h1>
    <h3><a href="views/action/testAction.jsp">JSP Action Tag Test</h3>
    <br>

    <h2>EL Test</h2>
    <h3><a href="test1">request.getAttribute()</a></h3>
    <h3><a href="test2">request에 저장된 객체 출력</a></h3>
    <h3><a href="views/el/testEl3.jsp?name=iPhone&price=100&no=5&no=6&option=애플">parameter로 값을 전달한 경우 EL Test</a></h3>
    <h3><a href="test4">requestScope와 sessionScope Test</a></h3>

    <h2>JSTL Test</h2>
    <h3><a href="views/jstl/testJstlCore.jsp">Core Library Test</a></h3>
    <h3><a href="views/jstl/testJstlFmt.jsp">Fmt Library Test</a></h3>
    <h3><a href="views/jstl/testFunction.jsp">Function Library Test</a></h3>
</body>
</html>