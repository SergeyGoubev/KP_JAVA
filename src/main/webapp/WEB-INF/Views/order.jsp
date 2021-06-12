<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 12.06.2021
  Time: 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form:form action="/order" method="post" modelAttribute="order">
            <div>
                Описание: <form:input path="description"/>
            </div>
            <div>
                Организатор:
                <form:select path="organizator.userId">
                    <c:forEach items="${organizators}" var="item">
                        <form:option value="${item.userId}" title="${item}"/>
                    </c:forEach>
                </form:select>
            </div>
            <div>
                <button type="submit">Оставить заказ</button>
            </div>
        </form:form>
    </div>
</body>
</html>
