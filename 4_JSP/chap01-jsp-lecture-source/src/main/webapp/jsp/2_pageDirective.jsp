<!--
    지시자 태그에서 사용 가능한 속성은 여러 가지가 있지만 자주 사용하는 간단한 속성은 아래와 같다.
    errorPage : 현재 페이지에서 Exception이 발생하면 속성값에 설정한 JSP 경로로 exception을 던진다.
    isErrorPage : 현재 페이지가 Exception을 처리할 페이지이면 true로 지정, 아니면 false로 지정한다.
    import : java.long 패키지 이외의 클래스를 현 JSP 파일에서 사용할 때 import 속성으로 정의하면 Java의 import 선언부를 작성하는 것과 같다.

    지시자 태그는 page 지시자 태그, include 지시자 태그, taglib 지시자 태그의 3 종류가 있다.
    page 지시자 태그 : 현 JSP 페이지에 대한 설정을 하는 지시자 태그이다.
    include 지시자 태그 : 다른 JSP 파일을 포함하기 위해 사용하는 지시자 태그이다.
    taglib 지시자 태그 : xml 문법 기반의 라이브러리인 JSTL을 사용하기 위해 선언하는 지시자 태그이다.
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
          import="java.util.Date" errorPage="errorPage.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
      Date date = new Date();
      System.out.println(date);
    %>
    <%
      String str = null;
      char ch = str.charAt(0);
    %>

</body>
</html>
