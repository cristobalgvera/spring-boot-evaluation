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
    <title>Home</title>
</head>
<body>
<div class="saludo">
    <h2>Hola, ${sessionScope}</h2>
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
                        <form:form method="post" action="${pageContext.request.contextPath}/" modelAttribute="visit">
                            <form:hidden path="id"></form:hidden>
                            <button  type="submit" name="submit-btn" value="details">Detalles</button>
                            <button type="submit" name="submit-btn" value="finish">Finalizar</button>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
