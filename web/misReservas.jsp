<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <div class="container">    
            <table class="table table-striped">
                <thead>
                <th>Numero de ID</th>
                <th>Cine</th>
                <th>Sala</th>
                <th>Pelicula</th>
                <th>Fecha y hora de inicio</th>
                <th>Asiento</th>
                </thead>
                <c:forEach items="${listaReservas.dameMisReservasActivas(usuarioConectado.idUsuario)}" var="reserva">
                    <c:set var="sala" value="${listaSalas.buscarSala(reserva.getFuncion().getIdSalaAlQuePertenece())}" />
                    <c:set var="cine" value="${listaCines.buscarCine(sala.getIdDelCineAlQuePertenezco(sala.getIdSala()))}" /> 
                    <tr>
                        <td>${reserva.getIdReserva()}</td>
                        <td>${cine.getNombre()}</td>
                        <td>${sala.getNombre()}</td>
                        <td>${reserva.getFuncion().getPelicula().getNombre()}</td>
                        <td>${reserva.getFuncion().getFechaHoraInicio()}</td>
                        <td>${reserva.getAsiento()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
