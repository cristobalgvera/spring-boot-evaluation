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
    <link href="https://fonts.googleapis.com/css?family=Ubuntu:500" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#accordion")
                .accordion({
                    header: "> div > h3"
                })
                .sortable({
                    axis: "y",
                    handle: "h3",
                    stop: function (event, ui) {
                        ui.item.children("h3").triggerHandler("focusout");
                        $(this).accordion("refresh");
                    }
                });
        });
    </script>
    <style>
        .group div {
            display: flex;
            flex-flow: wrap;
            justify-content: space-around;
        }
    </style>
    <title>Detalles visita</title>
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

<div id="accordion" style="width: 50%; margin: auto">
    <div class="group">
        <h3>Información general</h3>
        <div>
            <p><strong>ID:</strong> ${visit.id}</p>
            <p><strong>Estado:</strong> ${visit.ready ? 'Realizada' : 'No realizada'}</p>
            <c:choose>
                <c:when test="${visit.ready}">
                    <p><strong>Fecha de término:</strong> ${visit.finishDate}></p>
                </c:when>
                <c:otherwise>
                    <p><strong>Fecha estimada de término:</strong> ${visit.schedulingDate}</p>
                </c:otherwise>
            </c:choose>
            <p><strong>Fecha de petición:</strong> ${visit.createdDate.get()}</p>
            <c:if test="${visit.lastModifiedDate.orElse(null) != null}">
                <c:set value="${visit.lastModifiedBy.get().personData}" var="personData"/>
                <p><strong>Fecha última modificación:</strong> ${visit.lastModifiedDate.get()}</p>
                <p><strong>Visita modificada por:</strong> ${personData.firstName} ${personData.lastName}</p>
            </c:if>
        </div>
    </div>
    <div class="group">
        <h3>Actividades</h3>
        <div>
            <table id="activities" class="display">
                <thead>
                <tr>
                    <th>N°</th>
                    <th>Descripción</th>
                    <th>Estado</th>
                    <th>Fecha límite</th>
                    <th>Fecha realización</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${activities}" var="activity" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${activity.description}</td>
                        <td style="background-color: ${activity.ready ? 'lightgreen' : 'lightcoral'}"></td>
                        <td>${activity.schedulingDate}</td>
                        <c:if test="${activity.ready}">
                            <td>${activity.readyDate}</td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="group">
        <h3>Cliente</h3>
        <div>
            <c:set value="${customer.personData}" var="customerData"/>
            <p><strong>ID:</strong> ${customer.id}</p>
            <p><strong>Nombre:</strong> ${customerData.firstName} ${customerData.lastName}</p>
            <p><strong>Número telefónico:</strong> ${customerData.phoneNumber}</p>
        </div>
    </div>
    <div class="group">
        <h3>Dirección</h3>
        <div>
            <p><strong>País:</strong> ${address.country}</p>
            <p><strong>Ciudad:</strong> ${address.city}</p>
            <p><strong>Calle:</strong> ${address.street}</p>
            <p><strong>Número:</strong> ${address.addressNumber}</p>
            <c:if test="${address.block != null}">
                <p><strong>Bloque:</strong> ${address.block}</p>
            </c:if>
        </div>
    </div>
    <div class="group">
        <h3>Pagos</h3>
        <div>
            <p><strong>ID:</strong> ${payment.id}</p>
            <p><strong>Monto:</strong> ${payment.amount}</p>
            <p><strong>Estado:</strong> ${payment.ready ? 'Pagado' : 'No pagado'}</p>
            <p><strong>Fecha límite:</strong> ${payment.payDay}</p>
            <c:if test="${payment.ready}">
                <p><strong>Fecha de pago:</strong> ${payment.lastModifiedDate.get()}</p>
            </c:if>
        </div>
    </div>
</div>
<br/>
<form class="botonesC" action="<c:url value="/employee/visit/finish/${visit.id}"/>" method="GET">
    <button class="ui-button ui-widget-shadow" name="submit-btn" value="go-back" type="submit">Volver</button>
    <button class="ui-button ui-widget-shadow" name="submit-btn" value="finish" type="submit">Finalizar</button>
</form>
<footer>
    <p>
        Asesorías digitales <br> Todos los derechos reservados.
    </p>
</footer>
</body>
</html>
