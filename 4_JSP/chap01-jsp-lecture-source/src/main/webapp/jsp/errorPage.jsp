<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
          isErrorPage="true"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
      String exceptionType = exception.getClass().getName();
      String exceptionMassage = exception.getMessage();
    %>

    <h1><%= exceptionType%></h1>
    <h3><%= exceptionMassage%></h3>

</body>
</html>
