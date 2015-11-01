<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="headerInclude.jsp" />
        <title>Gestion salas</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <c:if test="${usuarioConectado.categoria eq 'cliente' or !usuarioConectado.existe(usuarioConectado)}">
            <c:redirect url="index.jsp"/>
        </c:if>
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
                            <td>${sala.getTiempoLimpieza()} minutos</td>
                        </tr>
                    </c:forEach>                    
                </c:forEach>
            </table>
        </div>
        <div class="col-md-4">
            <form class="form-horizontal" action="controlSala">
                <fieldset>
                    <legend>Agregar Sala</legend>
                    <input type="hidden" name="accion" value="agregar" />
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="idCineAgregar">Nombre del cine</label>
                        <div class="col-md-6">
                            <select name="idCineAgregar" class="form-control">
                                <c:forEach items="${listaCines.dameListaTodos()}" var="cine">
                                    <option value="${cine.getIdCine()}">${cine.getNombre()}</option>
                                </c:forEach>
                            </select>
                            <span class="help-block">Seleccione el cine al cual quiere agregar la sala</span>  
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="nombreAgregar">Nombre de sala</label>  
                        <div class="col-md-6">
                            <input name="nombreAgregar" placeholder="Ingrese el nombre de la sala" class="form-control input-md" required="" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="filasAgregar">Filas</label>  
                        <div class="col-md-6">
                            <input name="filasAgregar" placeholder="Ingrese el numero de filas" class="form-control input-md" required="" type="number" min="0">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="columnasAgregar">Columnas</label>  
                        <div class="col-md-6">
                            <input name="columnasAgregar" placeholder="Ingrese el numero de columnas" class="form-control input-md" required="" type="number" min="0">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="tiempoAgregar">Tiempo de limpieza</label>  
                        <div class="col-md-6">
                            <input name="tiempoAgregar" placeholder="Ingrese el tiempo de limpieza" class="form-control input-md" required="" type="number" min="0">
                        </div>
                    </div>                    
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="buttonAgregar"></label>
                        <div class="col-md-6">
                            <button type="submit" value="agregar" name="buttonAgregar" class="btn btn-primary">Crear sala</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
        <div class="col-md-4">
            <form class="form-horizontal" action="controlSala">
                <fieldset>
                    <legend>Modificar Sala</legend>
                    <input type="hidden" name="accion" value="modificar" />
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="idModificar">Sala</label>
                        <div class="col-md-6">
                            <select name="idModificar" class="form-control">
                                <c:forEach items="${listaSalas.dameListaTodos()}" var="sala">
                                    <option value="${sala.getIdSala()}">ID ${sala.getIdSala()} - ${sala.getNombre()}</option>
                                </c:forEach>
                            </select>
                            <span class="help-block">Seleccione la sala a modificar</span>  
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="nombreModificar">Nombre de sala</label>  
                        <div class="col-md-6">
                            <input name="nombreModificar" placeholder="Nuevo nombre de sala" class="form-control input-md" required="" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="filasModificar">Filas</label>  
                        <div class="col-md-6">
                            <input name="filasModificar" placeholder="Nuevo numero de filas" class="form-control input-md" required="" type="number" min="0">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="columnasModificar">Columnas</label>  
                        <div class="col-md-6">
                            <input name="columnasModificar" placeholder="Nuevo numero de columnas" class="form-control input-md" required="" type="number" min="0">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="tiempoModificar">Tiempo de limpieza</label>  
                        <div class="col-md-6">
                            <input name="tiempoModificar" placeholder="Nuevo tiempo de limpieza" class="form-control input-md" required="" type="number" min="0">
                        </div>
                    </div>                    
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="buttonModificar"></label>
                        <div class="col-md-6">
                            <button type="submit" value="modificar" name="buttonModificar" class="btn btn-primary">Guardar cambios</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
        <div class="col-md-4">
            <form class="form-horizontal" action="controlSala">
                <fieldset>
                    <legend>Borrar Sala</legend>
                    <input type="hidden" name="accion" value="borrar" />
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="idBorrar">Sala</label>
                        <div class="col-md-6">
                            <select name="idBorrar" class="form-control">
                                <c:forEach items="${listaSalas.dameListaTodos()}" var="sala">
                                    <option value="${sala.getIdSala()}">ID ${sala.getIdSala()} - ${sala.getNombre()}</option>
                                </c:forEach>
                            </select>
                            <span class="help-block">Seleccione la sala a borrar</span>  
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="buttonBorrar"></label>
                        <div class="col-md-6">
                            <button type="submit" value="borrar" name="buttonBorrar" class="btn btn-primary">Eliminar Sala</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
</html>