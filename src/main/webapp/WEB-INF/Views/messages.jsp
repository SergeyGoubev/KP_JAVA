<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 03.06.2021
  Time: 1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Список сообщений:</h1>
    <div>
        <c:forEach items="${list}" var="item">
            <div>
                ${message.message} <br>
                ${message.data} <br>
                ${message.userId}
            </div>
        </c:forEach>
    </div>
    <div>
        <form:form action="/send" method="post" modelAttribute="message">
            <form:hidden path="organizatorId"/> <br/>
           Текст:  <form:input path="message"/> <br/>
           Id получателя: <form:input path="userId"/> <br/>
        </form:form>
    </div>
</body>
</html>
