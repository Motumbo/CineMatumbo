<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="headerInclude.jsp" />
        <title>Mis Reservas</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <c:if test="${usuarioConectado.categoria eq 'admin' or !usuarioConectado.existe(usuarioConectado)}">
            <c:redirect url="index.jsp"/>
        </c:if>
        <h1 style="text-align: center">misReservas</h1>
    </body>
</html>
