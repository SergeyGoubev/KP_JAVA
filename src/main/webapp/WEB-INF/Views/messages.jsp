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
                <div>
                    ${item.message}
                </div>
                <div>
                    ${item.date}
                </div>
                <div>
                    ${item.user.name} ${item.user.surname}
                </div>
            </div>
            <div>
                <a href="/message/write/${item.user.userId}">Ответить</a>
            </div>
        </c:forEach>
    </div>
</body>
</html>
