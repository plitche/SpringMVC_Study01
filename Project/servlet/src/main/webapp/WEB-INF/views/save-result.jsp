<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    성공
    <ul>
        <%--<li>id=<%=(Member)request.getAttribute("member").getId%></li>--%>
        <%--대신 jstl의 표현식을 쓰면 된다.--%>
        <li>id=${member.id}</li>
        <li>username=${member.username}</li>
        <li>age=${member.age}</li>
    </ul>
    <a href="/index.html">메인</a>
    </body>
</html>
