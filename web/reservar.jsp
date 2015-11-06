<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="headerInclude.jsp" />
        <title>Reservar</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <c:if test="${usuarioConectado.categoria eq 'admin' or !usuarioConectado.existe(usuarioConectado)}">
            <c:redirect url="index.jsp"/>
        </c:if>
        <div class="container">    
            <table class="table table-striped">
                <thead>
                <th>Cine</th>
                <th>Sala</th>
                <th>Pelicula</th>
                <th>Fecha y hora de inicio</th>
                <th>Tarifa</th>
                </thead>
                <c:forEach items="${listaFunciones.dameListaTodos()}" var="funcion">
                    <c:set var="sala" value="${listaSalas.buscarSala(funcion.getIdSalaAlQuePertenece())}" />
                    <c:set var="cine" value="${listaCines.buscarCine(sala.getIdDelCineAlQuePertenezco(sala.getIdSala()))}" />
                    <tr>
                        <td>${cine.getNombre()}</td>
                        <td>${sala.getNombre()}</td>
                        <td>${funcion.getPelicula().getNombre()}</td>
                        <td>${funcion.getFechaHoraInicio()}</td>
                        <td>$ ${funcion.getTarifa()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <form class="form-horizontal">
            <fieldset>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="selectbasic">Funcion</label>
                    <div class="col-md-4">
                        <select id="selectbasic" name="selectbasic" class="form-control">
                            <c:forEach items="${listaFunciones.dameListaTodos()}" var="funcion">
                                <option value="${funcion.getIdFuncion()}">${funcion.getPelicula().getNombre()} - ${funcion.getFechaHoraInicio()}</option>
                            
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="radios">Asiento</label>
                    <div class="col-md-4"> 
                        <c:forEach begin="1" end="${(listaSalas.buscarSala(funcion.getIdSalaAlQuePertenece()).getFilas()) * (listaSalas.buscarSala(funcion.getIdSalaAlQuePertenece()).getColumnas())}" varStatus="loop">
                            <label class="radio-inline" for="radios-${loop.index}">
                                <input name="radios" id="radios-${loop.index}" value="${loop.count}" type="radio">
                                ${loop.count}
                                
                                <!-- CORREGIR CON CHECKS Y SEPARAR LA SELECCION DE BUTACAS EN OTRO FORM -->
                                
                            </label> 
                        </c:forEach>
                        </c:forEach>
                    </div>
                </div>
            </fieldset>
        </form>
    </body>
</html>
