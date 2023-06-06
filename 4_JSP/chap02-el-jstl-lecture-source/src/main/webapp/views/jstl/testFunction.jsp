<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>JSTL Functions Library Tag Test</h1>
    <h3>문자열 처리에 관련된 함수 사용 가능</h3>
    <h3>EL 내부에서 값 처리용으로 사용하거나 value 속성 대입 시에 사용</h3>

    <c:set var="str" value="How are you?" />
    str : ${ str } <br>
    you가 포함되어 있는가? : ${ fn:contains(str, 'you') } <br>
    how가 포암되어 있는가? : ${ fn:contains(str, 'how') } <br>
    대소문자 구분없이 how 포함 여부 확인 : ${ fn:containsIgnoreCase(str, 'how') } <br>
    모든 문자를 대문자로 : ${ fn:toUpperCase(str) } <br>
    모든 문자를 소문자로 : ${ fn:toLowerCase(str) } <br>
    are의 위치는 : ${ fn:indexOf(str, 'are') } <br>
    How를 Where로 변경 : ${ fn:replace(str, 'How' , 'Where') } <br>
    문자열 길이 : ${ fn:length(str) } <br>
    are 분리 추출 : ${ fn:substring(str, 4, 7) } <br>

    <hr/>

    <c:set var="arr" value="${ fn:split(str, ' ') }" /> 배열로 반환 <br>
    <c:forEach items="${ arr }" varStatus="st">
        <c:out value="${ st.count } : ${ arr[st.index] }" /> <br>
    </c:forEach>

    <br>
    배열 하나로 합치기 : <c:out value="${ fn:join(arr, '-') }" /> <br>


</body>
</html>
