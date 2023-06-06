<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>전달된 request 객체에 저장된 정보 출력하기</h2>

<%--  <%--%>
<%--    String name = (String) request.getAttribute("name");--%>
<%--    int age = (Integer) request.getAttribute("age");--%>
<%--    String phone = (String) request.getAttribute("phone");--%>
<%--  %>--%>

<%--  name : <%= name %> <br>--%>
<%--  age : <%= age %> <br>--%>
<%--  phone : <%= phone %> <br>--%>

<%--  name : ${ requestScope.name } <br>--%>
<%--  age : ${ requestScope.age } <br>--%>
<%--  phone : ${ requestScope.phone } <br>--%>

  name : ${ name } <br>
  age : ${ age } <br>
  phone : ${ phone } <br>

  <h2>items 이름의 리스트에 저장된 정보 출력하기</h2>

<%--  <%--%>
<%--    ArrayList items = (ArrayList) request.getAttribute("items");--%>
<%--    for(int i = 0; i < items.size(); i++) { %>--%>
<%--      <%= i %> : <%= items.get(i) %> <br>--%>
<%--  <%  }  %>--%>

<%--  0 : ${ requestScope.items[0] } <br>--%>
<%--  1 : ${ requestScope.items[1] } <br>--%>
<%--  2 : ${ requestScope.items[2] } <br>--%>
  0 : ${ items[0] } <br>
  1 : ${ items[1] } <br>
  2 : ${ items[2] } <br>
</body>
</html>
