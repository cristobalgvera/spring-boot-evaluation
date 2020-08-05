<%@ page import="cl.fullstack.springbootproject.model.visit.Summary" %><%--
  Created by IntelliJ IDEA.
  User: crist
  Date: 03-08-2020
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Ubuntu:500" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <title>Summary</title>
</head>
<body>
<div class="logout" align="right">
    <form action="<c:url value="/logout"/>" method="POST">
        <button class="ui-button ui-widget-shadow" id="logout" type="submit">Cerrar sesión</button>
    </form>
</div>
<div class="logo">
    <img src="<c:url value="/img/logo-A.png"/> " alt="logo">
</div>
<div align="center" class="loquesea">
    <h4>Finalización de visita</h4>
    <p>Para finalizar una visita, primero debe completar un cuadro
        informativo sobre las actividades realizadas durante el proceso de
        asesoría.</p>
    <p>Además, deberá evaluar la satisfacción del proceso.</p>
    <form:form action="${pageContext.request.contextPath}/employee/visit/finish/${visitId}" method="POST" modelAttribute="summary">
        <form:hidden path="rating" id="rating"></form:hidden>
        <form:textarea path="description" cssClass="ui-corner-all" cols="60" rows="15"></form:textarea>
<%--        <textarea id="textarea" name="description" placeholder="Detalle las actividades" required>${summary.description}</textarea>--%>
        <ul class="ratings">
            <li class="star" name="default" value="10"></li>
            <li class="star" name="default" value="9"></li>
            <li class="star" name="default" value="8"></li>
            <li class="star" name="default" value="7"></li>
            <li class="star" name="default" value="6"></li>
            <li class="star" name="default" value="5"></li>
            <li class="star" name="default" value="4"></li>
            <li class="star" name="default" value="3"></li>
            <li class="star" name="default" value="2"></li>
            <li class="star" name="default" value="1"></li>
        </ul>
        <button class="ui-button ui-widget-shadow" name="submit-btn" value="save" type="submit">Guardar</button>
        <button class="ui-button ui-widget-shadow" name="submit-btn" value="terminate" type="submit">Finalizar</button>
<%--        <input type="hidden" name="rating" value=1 id="rating">--%>
    </form:form>
</div>
<footer>
    <p>
        Asesorías digitales <br> Todos los derechos reservados.
    </p>
</footer>
<script>
    $(function () {
        var star = '.star', selected = '.selected';

        $(star).on('click', function () {
            $("#rating").val(parseInt($(this).val(), 10));

            $(selected).each(function () {
                $(this).removeClass('selected');
            });
            $(this).addClass('selected');
        });

    });
    <% int rating = (int) ((Summary) (request.getAttribute("summary"))).getRating();%>
    $(document).ready(function () {
        let star = '.star', selected = '.selected';
        let rating =
        <%=rating%>
        if ((rating > 0)) {
            $("ul li").each(function () {
                if (rating >= parseInt($(this).val(), 10)) {
                    $(this).addClass('selected');

                }
            })
        } else {
            $("ul li").last().addClass('selected');
        }
    });
</script>
</body>
</html>
