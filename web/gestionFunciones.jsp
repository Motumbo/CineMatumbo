<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="headerInclude.jsp" />
        <title>Gestion Funciones</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <c:if test="${usuarioConectado.categoria eq 'cliente' or !usuarioConectado.existe(usuarioConectado)}">
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
                <th>Tarifa</th>
                </thead>
                <c:forEach items="${listaFunciones.dameListaTodos()}" var="funcion">
                    <c:set var="sala" value="${listaSalas.buscarSala(funcion.getIdSalaAlQuePertenece())}" />
                    <c:set var="cine" value="${listaCines.buscarCine(sala.getIdDelCineAlQuePertenezco(sala.getIdSala()))}" />
                    <tr>
                        <td>${funcion.getIdFuncion()}</td>
                        <td>${cine.getNombre()}</td>
                        <td>${sala.getNombre()}</td>
                        <td>${funcion.getPelicula().getNombre()}</td>
                        <td>${funcion.getFechaHoraInicio()}</td>
                        <td>$ ${funcion.getTarifa()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-md-4">
            <form class="form-horizontal" action="controlFuncion">
                <fieldset>
                    <legend>Agregar Funcion</legend>
                    <input type="hidden" name="accion" value="agregar" />
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="idSalaAgregar">Nombre de la sala</label>
                        <div class="col-md-6">
                            <select name="idSalaAgregar" class="form-control">
                                <c:forEach items="${listaSalas.dameListaTodos()}" var="sala">
                                    <option value="${sala.getIdSala()}">ID ${sala.getIdSala()} - ${sala.getNombre()}</option>
                                </c:forEach>
                            </select>
                            <span class="help-block">Seleccione la sala a la cual quiere agregar la funcion</span>  
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="idPeliculaAgregar">Nombre de la pelicula</label>
                        <div class="col-md-6">
                            <select name="idPeliculaAgregar" class="form-control">
                                <c:forEach items="${listaPeliculas.dameListaTodos()}" var="pelicula">
                                    <option value="${pelicula.getIdPelicula()}">${pelicula.getNombre()}</option>
                                </c:forEach>
                            </select>
                            <span class="help-block">Seleccione la pelicula a la cual quiere agregar la funcion</span>  
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="fechaHoraAgregar">Fecha y hora</label>  
                        <div class="col-md-6">
                            <input name="fechaHoraAgregar" placeholder="Ingrese la fecha y hora de la funcion" class="form-control input-md" required="" type="text">
                            <span class="help-block">Formato: yyyy-mm-dd hh:mm:ss</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="tarifaAgregar">Tarifa</label>  
                        <div class="col-md-6">
                            <input name="tarifaAgregar" placeholder="Ingrese el precio de la entrada" class="form-control input-md" required="" type="number" min="0">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="buttonAgregar"></label>
                        <div class="col-md-6">
                            <button type="submit" value="agregar" name="buttonAgregar" class="btn btn-primary">Crear funcion</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
        <div class="col-md-4">
            <form class="form-horizontal" action="controlFuncion">
                <fieldset>
                    <legend>Modificar Sala</legend>
                    <input type="hidden" name="accion" value="modificar" />
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="idModificar">Funcion</label>
                        <div class="col-md-6">
                            <select name="idModificar" class="form-control">
                                <c:forEach items="${listaFunciones.dameListaTodos()}" var="funcion">
                                    <option value="${funcion.getIdFuncion()}">ID ${funcion.getIdFuncion()} - ${funcion.getPelicula().getNombre()}</option>
                                </c:forEach>
                            </select>
                            <span class="help-block">Seleccione la funcion a modificar</span>  
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="fechaHoraModificar">Fecha y hora</label>  
                        <div class="col-md-6">
                            <input name="fechaHoraModificar" placeholder="Nueva fecha y hora de la funcion" class="form-control input-md" required="" type="text">
                            <span class="help-block">Formato: yyyy-mm-dd hh:mm:ss</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="tarifaModificar">Tarifa</label>  
                        <div class="col-md-6">
                            <input name="tarifaModificar" placeholder="Nuevo precio de la entrada" class="form-control input-md" required="" type="number" min="0">
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
            <form class="form-horizontal" action="controlFuncion">
                <fieldset>
                    <legend>Borrar Funcion</legend>
                    <input type="hidden" name="accion" value="borrar" />
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="idBorrar">Funcion</label>
                        <div class="col-md-6">
                            <select name="idBorrar" class="form-control">
                                <c:forEach items="${listaFunciones.dameListaTodos()}" var="funcion">
                                    <option value="${funcion.getIdFuncion()}">ID ${funcion.getIdFuncion()} - ${funcion.getPelicula().getNombre()}</option>
                                </c:forEach>
                            </select>
                            <span class="help-block">Seleccione la funcion a borrar</span>  
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="buttonBorrar"></label>
                        <div class="col-md-6">
                            <button type="submit" value="borrar" name="buttonBorrar" class="btn btn-primary">Eliminar funcion</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
</html>
