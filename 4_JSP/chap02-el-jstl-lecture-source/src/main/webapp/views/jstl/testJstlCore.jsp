<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>JSTL Core Library Tag Test</h1>

    <h2>c:set 태그 : 변수선언</h2>
    <c:set var="num1" value="100" scope="session" />
    <c:set var="num2" value="200" scope="session" />

<%--    <% int sum = num1 + num2; %>--%>
    <c:set var="sum" value="${ num1 + num2 }" />
    num1 + num2 = ${ sum } <br>

    <% int num3 = 10, num4 = 20; %>
    num3 + num4 = ${ num3 + num4 } <br>
    <c:set var="sum2" value="<%= num3 + num4 %>" />
    num3 + num4 = ${ sum2 } <br>

    <hr>

    <h2>c:set 태그 : 배열 또는 컬렉션으로 사용한 문자열 선언</h2>
    <c:set var="colors">
        red, orange, yellow, green, blue, purple
    </c:set>
    colors 배열 값 확인 : ${ colors } <br>

    <script>
        window.onload = function () {
            var colors = '${ colors }'.split(', ');
            console.log(colors)
        }
    </script>

    <hr/>

    <h2>c:remove 태그 : 변수삭제</h2>
    num1 변수 값 : ${ num1 } <br>
    num2 변수 값 : ${ num2 } <br>

    <c:remove var="num1" scope="session" />
    <c:remove var="num2" scope="session" />

    num1 변수 값 : ${ num1 } <br>
    num2 변수 값 : ${ num2 } <br>

    <hr/>

    <h2>c:out 태그 : 값 출력용</h2>
    <c:out value="core 라이브러리의 <out> 태그는 값을 화면에 출력하는 태그이다." /><br>
    <c:out value="<h2>데이터출력</h2>" /><br>
    <c:out value="<h2>데이터출력</h2>" escapeXml="false" /><br>
    <c:out value="<h2>데이터출력</h2>" escapeXml="true" /><br><!-- escapeXml 기본값은 true -->

    <h2>c:out 태그의 default 속성</h2>
    <c:out value="${ param.name }" default="김아무개" /><br>

    <hr/>

    <h2>c:if 태그 : 조건문</h2>
    <c:set var="value1" value="9" scope="page" />
    <c:set var="value2" value="3" scope="page" />
    value1의 값은 <c:out value="${ value1 }" />이고 value2의 값은 <c:out value="${ value2 }" />이다.

    <c:if test="${ value1 >= value2 }">
        <h3>value1이 큽니다. : ${ value1 }</h3>
    </c:if>
    <c:if test="${ value1 < value2 }">
        <h3>value2가 큽니다. : ${ value2 }</h3>
    </c:if>

    <hr/>

    <h2>c:choose 태그 : switch문</h2>
    <h3>c:when 태그 : case문</h3>
    <h3>c:otherwise 태그 : default문</h3>
    <c:set var="no" value="${ param.no }" />
    param.no의 값은 <c:out value="${ param.no }" />입니다.

    <c:choose>
        <c:when test="${ no == 1 }">
            <h3>안녕하세요.</h3>
        </c:when>
        <c:when test="${ no eq 2 }">
            <h3>반갑습니다.</h3>
        </c:when>
        <c:otherwise>
            <h3>안녕히가세요.</h3>
        </c:otherwise>
    </c:choose>

    <hr/>

    <h2>c:forEach 태그 : for문</h2>
    <c:forEach begin="1" end="10">
        반복실행<br>
    </c:forEach>

    <br>


    <c:forEach var="size" begin="1" end="7" step="1">
        <font size="${ size }">글자크리 ${ size }</font><br>
    </c:forEach>

    <br>

    <h2>c:forEach 태그 : 배열 또는 컬렉션 연속처리에 for~each문처럼 사용함</h2>
    <c:forEach var="color" items="${ colors }" varStatus="st">
        <style font-color="${ color }">${ st.count } : 글자색 ${ color }</style>
    </c:forEach>

    <hr/>

    <h2>c:forTokens 태그 : 문자열을 토큰으로 분리 처리할 때 사용함</h2>
    <ul>
        <c:forTokens items="red orange yellow green" delims=" " >
            <li>${ color }</li>
        </c:forTokens>
    </ul>
    <br>

    <h3>여러 개의 토큰 문자를 가지고 분리 처리할 수 있음</h3>
    <c:forTokens var="color" items="red-orange/yellow*green blue" delims=" &/-">
        ${ color }<br>
    </c:forTokens>
    <hr/>

    <h2>c:url 태그 : 링크 설정 정보를 별도로 지정할 때 사용하는 태그</h2>
    <c:url var="fmtLink" value="testJstlCoreResult.jsp">
        <c:param name="num" value="77" />
    </c:url>
    <a href="${ fmtLink }">결과 확인 연결</a>

</body>
</html>
