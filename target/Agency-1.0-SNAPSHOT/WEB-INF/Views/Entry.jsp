<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 29.05.2021
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title> Агенство по проведению праздников</title>

    <!-- Bootstrap core CSS -->
    <!-- <link href="/resources/css/bootstrap.min.css" rel="stylesheet"> -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <style>
        <%@ include file="/resources/css/carousel.css" %>
        <%@ include file="/resources/css/style.css" %>
    </style>

</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="index">ПуА</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="index">Главная</a>
                    </li>
                    <li class="nav-item"><a class="nav-link">Люди<i class="fa fa-angle-down"></i></a>
                        <ul class="submenu">
                            <li class="nav-item"><a class="nav-link" href="error">Ведущие</a></li>
                            <li class="nav-item"><a class="nav-link" href="error">Фотографы</a></li>
                            <li class="nav-item"><a class="nav-link" href="error">Видеографы</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link">Еда</a>
                        <ul class="submenu">
                            <li class="nav-item"><a class="nav-link" href="error">Рестораны</a></li>
                            <li class="nav-item"><a class="nav-link" href="error">Торты</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="error">Декор и флористика</a></li>
                    <li class="nav-item"><a class="nav-link" href="error">Салон красоты</a></li>
                    <li class="nav-item"><a class="nav-link">Музыка, танцы, шоу</a>
                        <ul class="submenu">
                            <li class="nav-item"><a class="nav-link" href="error">Шоу-программы</a></li>
                            <li class="nav-item"><a class="nav-link" href="error">Музыкальное сопровождение</a></li>
                            <li class="nav-item"><a class="nav-link" href="error">Постановка танца</a></li>
                            <li class="nav-item"><a class="nav-link" href="error">Шоу программа для взрослых</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="error">Транспорт</a></li>
                    <li class="nav-item"><a class="nav-link" href="error">Отели</a></li>
                    <li class="nav-item"><a class="nav-link">Личный кабинет</a>
                        <ul class="submenu">
                            <li class="nav-item"><a class="nav-link" href="entry">Вход</a></li>
                            <li class="nav-item"><a class="nav-link" href="userRegistration">Регистрация клиента</a></li>
                            <li class="nav-item"><a class="nav-link" href="organizatorRegistration">Регистрация организатора</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<main class="main">
    <div class="container">
        <section id="content">
            <form method="post" action="${pageContext.request.contextPath}/entry">
                <h1>Авторизация</h1>
                <div>
                    <input name="login" class="form-control" id="floatingInput" placeholder="Ivanov1234"/>
                </div>
                <div>
                    <input name="password" class="form-control" id="floatingPassword" placeholder="Password" />
                </div>
                <div>
                    <input type="submit" value="Вход" />
                    <a href="organizatorRegistration">Регистрация<br>организатора</a>
                    <a href="userRegistration">Регистрация<br>Пользователя</a>
                </div>
            </form><!-- form -->
        </section><!-- content -->
    </div><!-- container -->
</main>
<h1>
    ${daoTest.login} <br>
    ${daoTest.password} <br>
</h1>
</body>
</html>

