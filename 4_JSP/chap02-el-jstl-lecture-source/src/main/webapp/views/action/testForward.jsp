<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1><%= request.getAttribute("name") %>님 환영합니다!</h1>

  <h2>jsp:useBean 활용</h2>
  <jsp:useBean id="member" class="com.el.model.dto.MemberDTO" scope="page" />
  <jsp:setProperty name="member" property="name" value="홍길동" />
  <jsp:setProperty name="member" property="age" value="18" />
  <jsp:setProperty name="member" property="phone" value="010-1234-5678" />
  <jsp:setProperty name="member" property="email" value="hgd@sahmyook.com" />

  이름 : <jsp:getProperty name="member" property="name"/>
  나이 : <jsp:getProperty name="member" property="age"/>
  전화번호 : <jsp:getProperty name="member" property="phone"/>
  이메일 : <jsp:getProperty name="member" property="email"/>

</body>
</html>
