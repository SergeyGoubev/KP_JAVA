<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 12.06.2021
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form:form action="/send/${message.user.userId}" method="post" modelAttribute="message">
            <div>
                Текст сообщения: <form:textarea path="message"/>
            </div>
            <div>
                <button type="submit">Отправить</button>
            </div>
        </form:form>
    </div>
</body>
</html>
