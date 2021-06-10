<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 03.06.2021
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title> Агенство по проведению праздников</title>

    <!-- Bootstrap core CSS -->
    <!-- <link href="/resources/css/bootstrap.min.css" rel="stylesheet"> -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <style>
        <%@ include file="/resources/css/carousel.css" %>
    </style>

</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="../index">ПуА</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="../index">Главная</a>
                    </li>
                    <li class="nav-item"><a class="nav-link">Люди<i class="fa fa-angle-down"></i></a>
                        <ul class="submenu">
                            <li class="nav-item"><a class="nav-link" href="../Hosts/1">Ведущие</a></li>
                            <li class="nav-item"><a class="nav-link" href="../Hosts/2">Фотографы</a></li>
                            <li class="nav-item"><a class="nav-link" href="../Hosts/3">Видеографы</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link">Еда</a>
                        <ul class="submenu">
                            <li class="nav-item"><a class="nav-link" href="../Hosts/4">Рестораны</a></li>
                            <li class="nav-item"><a class="nav-link" href="../Hosts/5">Торты</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="../Hosts/6">Декор и флористика</a></li>
                    <li class="nav-item"><a class="nav-link" href="../Hosts/7">Салон красоты</a></li>
                    <li class="nav-item"><a class="nav-link">Музыка, танцы, шоу</a>
                        <ul class="submenu">
                            <li class="nav-item"><a class="nav-link" href="../error">Шоу-программы</a></li>
                            <li class="nav-item"><a class="nav-link" href="../Hosts/11">Музыкальное сопровождение</a>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="../Hosts/10">Постановка танца</a></li>
                            <li class="nav-item"><a class="nav-link" href="../error">Шоу программа для взрослых</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="../Hosts/8">Транспорт</a></li>
                    <li class="nav-item"><a class="nav-link" href="../Hosts/9">Отели</a></li>
                    <li class="nav-item"><a class="nav-link">Личный кабинет</a>
                        <ul class="submenu">
                            <li class="nav-item"><a class="nav-link" href="../error">Мои заказы</a></li>
                            <li class="nav-item"><a class="nav-link" href="../index">Выход</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>


<main>
    <div align="center" class="gosti">
        <table border="2" width="70%" cellpadding="2">
            <tr>
                <td>Название:</td>
                <td>Описание:</td>
                <td>Цена:</td>
                <td></td>
            </tr>

            <c:choose>
                <c:when test="${fn:length(list) gt 0}">
                    <c:forEach var="services" items="${list}">
                        <tr>
                            <td>${services.name}</td>
                            <td>${services.description}</td>
                            <td>${services.cost}</td>
                        </tr>
                    </c:forEach>
                </c:when>

                <c:otherwise>
                    <tr>
                        <td class="text"><h3>Список пуст</h3></td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </table>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>

</body>
</html>
