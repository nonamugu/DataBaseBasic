<!-- 1. 페이지 지시자 태그 -->
<!-- 페이지에 대한 설정을 하는 지시자 태그로 현재 페이지에 스크리틀릿 태그를 이용하여 작성하는 문법은 Java라는 의미를 가지며
      response header에 응답을 위한 설정도 가능하고 content-type이라는 헤더에 MIME타입과 인코딩 방식을 지정함-->
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- 2. JSP 주석 태그 -->
    <%-- JSP 주석은 클라이언트에게 노출되지 않음 --%>

    <!-- 3. 선언 태그 -->
    <%!
        private String name;
        private int age;
    %>

    <!-- 4. scriptlet 태그 -->
    <%
        // 간단한 자바 코드를 작성할 수 있음
        /* 스크립틀릿 태그 내에서의 주석 Java 주석과 동일*/

        name = "홀길동";
        age = 300;

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        for(int i = 0; i < name.length(); i++) {
            System.out.println(name.charAt(i));
        }
    %>

    <!-- 5. expression 태그 -->
    name : <%= name %>
    age : <%= age %>
</body>
</html>
