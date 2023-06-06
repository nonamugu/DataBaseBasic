<%@ page import="com.el.model.dto.MemberDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>전달된 request 객체에 저장된 Member 객체 필드값 출력하기</h2>

<%--  <% MemberDTO member = (MemberDTO) request.getAttribute("member"); %>--%>
<%--  이름 : <%= member.getName() %> <br>--%>
<%--  나이 : <%= member.getAge() %> <br>--%>
<%--  전화번호 : <%= member.getPhone() %> <br>--%>
<%--  이메일 : <%= member.getEmial() %> <br>--%>

  이름 : ${ member.name } <br>
  나이 : ${ member.age } <br>
  전화번호 : ${ member.phone } <br>
  이메일 : ${ member.email } <br>
</body>
</html>
