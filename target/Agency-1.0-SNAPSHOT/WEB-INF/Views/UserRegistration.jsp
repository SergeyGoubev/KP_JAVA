<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 29.05.2021
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> Агенство по проведению праздников</title>

    <!-- Bootstrap core CSS -->
    <!-- <link href="/resources/css/bootstrap.min.css" rel="stylesheet"> -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <style>
        <%@ include file="/resources/css/signin.css" %>
    </style>

</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="index">ПуА</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
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

<main class="form-signin">
    <form:form method="post" action="newuser">

    <h1 class="h3 mb-3 fw-normal">Заполните данные для регистрации:</h1>

    <div class="form-floating">
        <form:input path="name" class="form-control" id="floatingInput" placeholder="Ivan"/>
        <label for="floatingInput">Имя</label>
    </div>

    <div class="form-floating">
        <form:input path="surname" class="form-control" id="floatingInput" placeholder="Ivanov"/>
        <label for="floatingInput">Фамилия</label>
    </div>

    <div class="form-floating">
        <form:input type="number" path="age" class="form-control" id="floatingInput" placeholder="25"/>
        <label for="floatingInput">Возраст</label>
    </div>

    <div class="form-floating">
        <form:input type="number" path="telephone" class="form-control" id="floatingInput"
                    placeholder="89997776655"/>
        <label for="floatingInput">Телефон</label>
    </div>

    <div class="form-floating">
        <form:input path="email" class="form-control" id="floatingInput" placeholder="Ivan"/>
        <label for="floatingInput">Электронная почта</label>
    </div>

    <div class="form-floating">
        <form:input path="wishes" class="form-control" id="floatingInput" placeholder="Ivan"/>
        <label for="floatingInput">Пожелания</label>
    </div>

    <div class="form-floating">
        <input type="file" name="image2" id="floatingInput" placeholder="ФОТО"/>
    </div>

    <div class="form-floating">
        <form:input path="login" class="form-control" id="floatingInput" placeholder="Ivan"/>
        <label for="floatingInput">Логин</label>
    </div>

    <div class="form-floating">
        <form:input type="password" path="password" class="form-control" id="floatingPassword"
                    placeholder="Password"/>
        <label for="floatingPassword">Пароль</label>
    </div>
    <button class="btn btn-outline-success" type="submit" value="Добавить">Добавить</button>
    </form:form>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
            crossorigin="anonymous"></script>
</body>
</html>
