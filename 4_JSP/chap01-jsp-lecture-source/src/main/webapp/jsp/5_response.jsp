<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    String menuName = (String) request.getAttribute("menuName");
    int amount = (Integer) request.getAttribute("amount");
    int orderPrice = (Integer) request.getAttribute("orderPrice");
  %>

  <h3>주문한 메뉴 : <%= menuName %></h3>
  <h3>주문 수량 : <%= amount %></h3>
  <h3>결제할 금액 : <%= orderPrice %></h3>

</body>
</html>
