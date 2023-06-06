<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <jsp:include page="common.jsp" />

  <h1>여기서부터 testAction.jsp 내용입니다~~~~ 오하하</h1>

  <% request.setAttribute("name", "홍길동"); %>
  <jsp:forward page="testForward.jsp" />
</body>
</html>
