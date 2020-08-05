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
        <button id="logout" type="submit">Cerrar sesión</button>
    </form>
</div>
<div class="logo">
    <img src="<c:url value="/img/logo-A.png"/> " alt="logo">
</div>

<div id="accordion" style="width: 50%; margin: auto">
    <div class="group">
        <h3>Información general</h3>
        <div>
            <p><strong>ID:</strong> <c:out value="${visit.id}"/></p>
            <p><strong>Estado:</strong> <c:out value="${visit.ready ? 'Realizada' : 'No realizada'}"/></p>
            <c:choose>
                <c:when test="${visit.ready}">
                    <p><strong>Fecha de término:</strong> <c:out value="${visit.finishDate}"/></p>
                </c:when>
                <c:otherwise>
                    <p><strong>Fecha estimada de término:</strong> <c:out value="${visit.schedulingDate}"/></p>
                </c:otherwise>
            </c:choose>
            <p><strong>Fecha de petición:</strong> <c:out value="${visit.createdDate.get()}"/></p>
            <c:if test="${visit.lastModifiedDate.orElse(null) != null}">
                <c:set value="${visit.lastModifiedBy.get().personData}" var="personData"></c:set>
                <p><strong>Fecha última modificación:</strong> <c:out value="${visit.lastModifiedDate.get()}"/></p>
                <p><strong>Visita modificada por:</strong> <c:out
                        value="${personData.firstName} ${personData.lastName}"/></p>
            </c:if>
        </div>
    </div>
    <div class="group">
        <h3>Actividades</h3>
        <div>
    <%--    TODO: For each to put visit's activities    --%>
            <table id="activities" class="display">
                <thead>
                <tr>
                    <th>Column 1</th>
                    <th>Column 2</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Row 1 Data 1</td>
                    <td>Row 1 Data 2</td>
                </tr>
                <tr>
                    <td>Row 2 Data 1</td>
                    <td>Row 2 Data 2</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="group">
        <h3>Cliente</h3>
        <div>
            <p>Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at
                aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non
                quam. In suscipit faucibus urna. </p>
        </div>
    </div>
    <div class="group">
        <h3>Dirección</h3>
        <div>
            <div>
                <h5>Ciudad: </h5> <c:out value="${address.city}"/>
            </div>
            <p>Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus
                in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo,
                magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui. </p>
            <ul>
                <li>List item one</li>
                <li>List item two</li>
                <li>List item three</li>
            </ul>
        </div>
    </div>
    <div class="group">
        <h3>Pagos</h3>
        <div>
            <p>Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis
                egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean
                lacinia mauris vel est. </p>
            <p>Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu
                ad litora torquent per conubia nostra, per inceptos himenaeos. </p>
        </div>
    </div>
</div>

<form class="botonesC" action="<c:url value="/employee/home"/>" method="GET">
    <button name="submit-btn" value="go-back" type="submit">Volver</button>
    <button name="submit-btn" value="finish" type="submit">Finalizar</button>
</form>
<footer>
    <p>
        Asesorías digitales <br> Todos los derechos reservados.
    </p>
</footer>
</body>
</html>
