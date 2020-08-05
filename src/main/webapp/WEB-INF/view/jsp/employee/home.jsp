<%--
  Created by IntelliJ IDEA.
  User: crist
  Date: 03-08-2020
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Ubuntu:500"
          rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <% int activeTab = (request.getAttribute("activeTab") != null) ? (int) request.getAttribute("activeTab") : 0; %>
    <script>
        $(function () {
            $("#tabs").tabs({
                active:<%=activeTab%>
            });
        });
    </script>
    <script>
        $(function () {
            $("#dialog").dialog();
        });
    </script>
    <title>Home</title>
</head>
<body>
<div class="logout" align="right">
    <form action="<c:url value="/logout"/>" method="POST">
        <button id="logout" type="submit">Cerrar sesión</button>
    </form>
</div>
<div class="logo">
    <img src="<c:url value="/img/logo-A.png"/> " alt="logo">
</div>
<div class="saludo">
    <h2>Hola, ${sessionScope.user.personData.firstName}</h2>
</div>
<div id="tabs">
    <ul>
        <li><a href="#tabs-1">Gestionar visitas</a></li>
        <li><a href="#tabs-2">Visualizar pagos</a></li>
    </ul>
    <div id="tabs-1">
        <h3>Gestionar visitas</h3>
        <table class="sinborde" align="center">
            <thead>
            <tr>
                <th>ID visita</th>
                <th>Fecha visita</th>
                <th>Cliente</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${allVisits}" var="visit">
                <tr>
                    <td class="sinborde"><c:out value="${visit.id}"></c:out></td>
                    <td class="sinborde"><c:out value="${visit.schedulingDate}"/></td>
                    <td class="sinborde"><c:out value="${visit.customer.id}"/></td>
                    <td class="sinborde">
                        <form method="POST" action="<c:url value="/employee/visit/${visit.id}"/>">
                            <button type="submit">Detalles</button>
                        </form>
                        <form method="POST" action="<c:url value="/employee"/>">
                            <button type="submit" name="submit-btn" value="finish">Finalizar</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="tabs-2">
        <h3>Visualización de pagos</h3>
        <table class="sinborde" align="center">
            <thead>
            <tr>
                <th>Nº de transación del pago</th>
                <th>Fecha del pago</th>
                <th>Valor total</th>
                <th>Estado del pago</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="pay" items="${payments}">
                <tr>
                    <td class="sinborde"><c:out value="${pay.id}"/></td>
                    <td class="sinborde"><c:out value="${pay.payDay}"/></td>
                    <td class="sinborde"><c:out value="${pay.amount}"/></td>
                    <td class="sinborde"><c:out value="${pay.ready ? 'Pagado': 'No Pagado'}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<footer>
    <p>
        Asesorías digitales <br> Todos los derechos reservados.
    </p>
</footer>
</body>
</html>
