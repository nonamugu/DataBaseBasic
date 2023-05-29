<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Service Method</title>
</head>
<body>
    <h1>service() method의 역할</h1>
    <h3>GET 방식 요청</h3>
    <h4>a태그의 href 속성값 변겅</h4>
    <a href="request-service">service method 요청</a>
    <h4>form 태그의 method 속성 get 설정</h4>
    <form action="request-service" method="get">
        <input type="submit" value="GET방식 request">
    </form>
    <h4>form 태그의 method 속성 post 설정</h4>
    <form action="request-service" method="post">
        <input type="submit" value="POST방식 request">
    </form>
</body>
</html>