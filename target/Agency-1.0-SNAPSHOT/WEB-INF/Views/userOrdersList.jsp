<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 13.06.2021
  Time: 17:27
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
                <div>
                    Организатор: ${item.organizator.name} ${item.organizator.surname}
                </div>
                <div>
                    Описание: ${item.description}
                </div>
                <div>
                    <c:if test="${item.status == \"accepted\"}">
                        <a href="/user/orders/accept/${item.id}">Выполнен</a>
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
