<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu:500" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>" type="text/css">
    <title>Login</title>
</head>
<body>

<div class="logo">
    <img src="resources/img/logo-A.png" alt="logo">
</div>
<div class="login">

    <div class="login-header">
        <h1>Login Intranet</h1>
    </div>
    <div class="login-form">
        <form:form action="${pageContext.request.contextPath}/login" method="POST">
            <label for="username">Usuario:</label>
            <input type="text" id="username" name="username" placeholder="Usuario" required/>
            <br>
            <label for="password">Clave:</label>
            <input type="password" id="password" name="password" placeholder="Clave" required/>
            <br>
            <button type="submit" class="login-button">Acceso</button>
        </form:form>
    </div>
</div>
<footer>
    <p> Asesorías digitales <br>
        Todos los derechos reservados.
    </p>
</footer>
</body>
</html>