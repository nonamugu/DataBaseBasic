<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>parameter 값 받아서 출력하기</h2>

<%--  <%--%>
<%--    String name = request.getParameter("name");--%>
<%--    int price = Integer.parseInt(request.getParameter("price"));--%>
<%--    String[] no = request.getParameterValues("no");--%>
<%--    String option = request.getParameter("option");--%>
<%--  %>--%>

<%--  상품명 : <%= name %> <br>--%>
<%--  가격 : <%= price %> <br>--%>
<%--  제품번호 : <%= no[0] %>과 <%= no[1] %> <br>--%>
<%--  옵션 : <%= option %> <br>--%>

<%--  상품명 : <%= name %> <br>--%>
<%--  가격 : <%= price %> <br>--%>
<%--  제품번호 : <%= no[0] %>과 <%= no[1] %> <br>--%>
<%--  옵션 : <%= option %> <br>--%>

  상품명 : ${ param.name }<br>
  가격 : ${ param.price }<br>
  제품번호 : ${ paramValues.no[0]}과 ${ paramValues.no[1] }<br>
  옵션 : ${ (empty param.option)? "옵션 없음" : param.option }<br>

</body>
</html>
