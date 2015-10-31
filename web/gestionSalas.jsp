<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="headerInclude.jsp" />
        <title>Gestion salas</title>
    </head>
    <jsp:include page="topMenu.jsp" />
    <body class="theme-light">
        <div class="container">    
            <table class="table table-striped">
                <thead>
                <th>Cine</th>
                <th>Numero de ID</th>
                <th>Nombre de Sala</th>
                <th>Filas</th>
                <th>Columnas</th>
                <th>Tiempo de limpieza</th>
                </thead>
                <c:forEach items="${listaCines.dameListaTodos()}" var="cine" varStatus="loop">
                    <c:forEach items="${listaSalas.dameAllSalasCine(loop.count)}" var ="sala">
                        <tr>
                            <td>${cine.getNombre()}</td>
                            <td>${sala.getIdSala()}</td>
                            <td>${sala.getNombre()}</td>
                            <td>${sala.getFilas()}</td>
                            <td>${sala.getColumnas()}</td>
                            <td>${sala.getTiempoLimpieza()}</td>
                        </tr>
                    </c:forEach>                    
                </c:forEach>
            </table>
        </div>
        <div class="container">
            <form class="form-horizontal" action="controlSala">
                <fieldset>
                    <legend>Modificar Sala</legend>
                    <input type="hidden" name="accion" value="modificar" />
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="idModificar">Numero de ID</label>
                        <div class="col-md-4">
                            <select id="idModificar" name="idModificar" class="form-control">
                                <c:forEach items="${listaSalas.dameListaTodos()}" var="sala">
                                    <option value="${sala.getIdSala()}">${sala.getIdSala()}</option>
                                </c:forEach>
                            </select>
                            <span class="help-block">Seleccione el ID de la sala a modificar</span>  
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="nombreModificar">Nombre de sala</label>  
                        <div class="col-md-4">
                            <input id="nombreModificar" name="nombreModificar" placeholder="Nuevo nombre de sala" class="form-control input-md" required="" type="text">
                            <span class="help-block">Escriba un nombre de sala que no exista en ese cine</span>  
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="filasModificar">Filas</label>  
                        <div class="col-md-4">
                            <input id="mailModificar" name="filasModificar" placeholder="Nuevo numero de filas" class="form-control input-md" required="" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="columnasModificar">Columnas</label>  
                        <div class="col-md-4">
                            <input id="mailModificar" name="columnasModificar" placeholder="Nuevo numero de columnas" class="form-control input-md" required="" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="tiempoModificar">Tiempo de limpieza</label>  
                        <div class="col-md-4">
                            <input id="mailModificar" name="tiempoModificar" placeholder="Nuevo numero de tiempo de limpieza" class="form-control input-md" required="" type="text">
                        </div>
                    </div>                    
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="buttonModificar"></label>
                        <div class="col-md-4">
                            <button type="submit" value="modificar" name="buttonModificar" class="btn btn-primary">Guardar cambios</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
</html>