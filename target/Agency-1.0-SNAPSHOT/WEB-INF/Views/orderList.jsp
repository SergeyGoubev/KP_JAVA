<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 13.06.2021
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <c:forEach items="${list}" var="item">
            <div>
                Заказчик: ${item.user.name} + ${item.user.surname}
            </div>
            <div>
                Описание: ${item.description}
            </div>
            <div>
                Статус: ${item.status}
            </div>
            <div>
                <c:if test="${item.status == \"sent\"}">
                    <a href="/organizator/orders/accept/${item.id}">Принять</a>
                </c:if>
            </div>
        </c:forEach>
    </div>
</body>
</html>
