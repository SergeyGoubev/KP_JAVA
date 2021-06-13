<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 29.05.2021
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title> Агенство по проведению праздников</title>

    <!-- Bootstrap core CSS -->
    <!-- <link href="/resources/css/bootstrap.min.css" rel="stylesheet"> -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <style>
        <%@ include file="/resources/css/carousel.css" %>
    </style>

</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="userIndex">ПуА</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="userIndex">Главная</a>
                    </li>
                    <li class="nav-item"><a class="nav-link">Люди<i class="fa fa-angle-down"></i></a>
                        <ul class="submenu">
                            <li class="nav-item"><a class="nav-link" href="Hosts/1">Ведущие</a></li>
                            <li class="nav-item"><a class="nav-link" href="Hosts/2">Фотографы</a></li>
                            <li class="nav-item"><a class="nav-link" href="Hosts/3">Видеографы</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link">Еда</a>
                        <ul class="submenu">
                            <li class="nav-item"><a class="nav-link" href="Hosts/4">Рестораны</a></li>
                            <li class="nav-item"><a class="nav-link" href="Hosts/5">Торты</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="Hosts/6">Декор и флористика</a></li>
                    <li class="nav-item"><a class="nav-link" href="Hosts/7">Салон красоты</a></li>
                    <li class="nav-item"><a class="nav-link">Музыка, танцы, шоу</a>
                        <ul class="submenu">
                            <li class="nav-item"><a class="nav-link" href="error">Шоу-программы</a></li>
                            <li class="nav-item"><a class="nav-link" href="Hosts/11">Музыкальное сопровождение</a></li>
                            <li class="nav-item"><a class="nav-link" href="Hosts/10">Постановка танца</a></li>
                            <li class="nav-item"><a class="nav-link" href="error">Шоу программа для взрослых</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="Hosts/8">Транспорт</a></li>
                    <li class="nav-item"><a class="nav-link" href="Hosts/9">Отели</a></li>
                    <li class="nav-item"><a class="nav-link">Личный кабинет</a>
                        <ul class="submenu">
                            <li class="nav-item"><a class="nav-link" href="pageUserInfo">${userJSP.name} ${userJSP.surname}</a></li>
                            <li class="nav-item"><a class="nav-link" href="guests">Список гостей</a></li>
                            <li class="nav-item"><a class="nav-link" href="error">Учёт расходов</a></li>
                            <li class="nav-item"><a class="nav-link" href="error">Мои заказы</a></li>
                            <li class="nav-item"><a class="nav-link" href="index">Выход</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<main>
    <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item">
                <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></svg>

                <div class="container">
                    <div class="carousel-caption">
                        <h1>Праздники у Алекса</h1>
                        <p>Мы являемся единственным агентством в городе Владимир,
                            с помощью которого вы сможете подготовиться к одному из самых значимых дней в вашей жизни
                            максимально быстро и просто. Вы сможете просмотреть анкеты ведущих, фотографов и других
                            помощников в организации праздники, общаться с ними напрямую. Сможете подобрать шоу-программу
                            и даже заказать торт.</p>
                    </div>
                </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</main>

<div>
    <c:choose>
        <c:when test="${user.typeOfUser.description == \"organizator\"}">
            <div>
                <a href="/organizator/orders/${user.userId}">Полученные заказы</a>
            </div>
        </c:when>
        <c:otherwise>
            <div>
                <a href="/order">Сделать заказ</a>
            </div>
        </c:otherwise>
    </c:choose>
    <div>
        <a href="/messages/${user.userId}">Просмотреть сообщения</a>
    </div>
    <div>
        ${user.name} + ${user.surname} <br>
        ${user.typeOfUser.description}
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

</body>
</html>