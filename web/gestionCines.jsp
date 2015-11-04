<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="headerInclude.jsp" />
        <title>JSP Page</title>
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
                <th>Nombre del Cine</th>
                <th>Ciudad</th>
                </thead>
                <c:forEach items="${listaCines.dameListaTodos()}" var="cine">
                    <tr>
                        <td>${cine.getIdCine()}</td>
                        <td>${cine.getNombre()}</td>
                        <td>${cine.getCiudad()}</td>
                    </tr>             
                </c:forEach>
            </table>
        </div>
        <div class="col-md-4">
            <form class="form-horizontal" action="controlCine">
                <fieldset>
                    <legend>Agregar Cine</legend>
                    <input type="hidden" name="accion" value="agregar" />
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="nombreAgregar">Nombre de cine</label>  
                        <div class="col-md-6">
                            <input name="nombreAgregar" placeholder="Ingrese el nombre del cine" class="form-control input-md" required="" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="ciudadAgregar">Ciudad</label>  
                        <div class="col-md-6">
                            <input name="ciudadAgregar" placeholder="Ingrese la ciudad del cine" class="form-control input-md" required="" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="buttonAgregar"></label>
                        <div class="col-md-6">
                            <button type="submit" value="agregar" name="buttonAgregar" class="btn btn-primary">Crear cine</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
        <div class="col-md-4">
            <form class="form-horizontal" action="controlCine">
                <fieldset>
                    <legend>Modificar Cine</legend>
                    <input type="hidden" name="accion" value="modificar" />
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="idModificar">Cine</label>
                        <div class="col-md-6">
                            <select name="idModificar" class="form-control">
                                <c:forEach items="${listaCines.dameListaTodos()}" var="cine">
                                    <option value="${cine.getIdCine()}">ID ${cine.getIdCine()} - ${cine.getNombre()}</option>
                                </c:forEach>
                            </select>
                            <span class="help-block">Seleccione el cine a modificar</span>  
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="nombreModificar">Nombre de cine</label>  
                        <div class="col-md-6">
                            <input name="nombreModificar" placeholder="Nuevo nombre de cine" class="form-control input-md" required="" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="ciudadModificar">Ciudad</label>  
                        <div class="col-md-6">
                            <input name="ciudadModificar" placeholder="Nueva ciudad del cine" class="form-control input-md" required="" type="text">
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
            <form class="form-horizontal" action="controlCine">
                <fieldset>
                    <legend>Borrar Cine</legend>
                    <input type="hidden" name="accion" value="borrar" />
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="idBorrar">Cine</label>
                        <div class="col-md-6">
                            <select name="idBorrar" class="form-control">
                                <c:forEach items="${listaCines.dameListaTodos()}" var="cine">
                                    <option value="${cine.getIdCine()}">ID ${cine.getIdCine()} - ${cine.getNombre()}</option>
                                </c:forEach>
                            </select>
                            <span class="help-block">Seleccione el cine a borrar</span>  
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="buttonBorrar"></label>
                        <div class="col-md-6">
                            <button type="submit" value="borrar" name="buttonBorrar" class="btn btn-primary">Eliminar Cine</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
</html>
