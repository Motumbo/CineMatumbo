<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="headerInclude.jsp" />
        <title>Gestion usuarios</title>
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
                <th>Nombre de usuario</th>
                <th>Email</th>
                <th>Categoria</th>
                </thead>
                <c:forEach items="${listaUsuarios.dameListaTodos()}" var="usuario">
                    <tr>
                        <td>${usuario.getIdUsuario()}</td>
                        <td>${usuario.getUserName()}</td>
                        <td>${usuario.getMail()}</td>
                        <td>${usuario.getCategoria()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="container">
            <div class="col-md-6">
                <form class="form-horizontal" action="controlUsuario">
                    <fieldset>
                        <legend>Modificar Usuario</legend>
                        <input type="hidden" name="accion" value="modificar" />
                        <div class="form-group">
                            <label class="col-md-6 control-label" for="idModificar">Numero de ID</label>
                            <div class="col-md-6">
                                <select name="idModificar" class="form-control">
                                    <c:forEach items="${listaUsuarios.dameListaTodos()}" var="usuario">
                                        <option value="${usuario.getIdUsuario()}">ID ${usuario.getIdUsuario()} - ${usuario.getUserName()}</option>                                   
                                    </c:forEach>
                                </select>
                                <span class="help-block">Seleccione el usuario a modificar</span>  
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-6 control-label" for="usuarioModificar">Nombre de usuario</label>  
                            <div class="col-md-6">
                                <input name="usuarioModificar" placeholder="Nuevo nombre de usuario" class="form-control input-md" required="" type="text">
                                <span class="help-block">Escriba un nombre de usuario que no exista en la lista</span>  
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-6 control-label" for="mailModificar">E-Mail</label>  
                            <div class="col-md-6">
                                <input name="mailModificar" placeholder="Nuevo correo electronico" class="form-control input-md" required="" type="email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-6 control-label" for="categoriaModificar">Categoria</label>
                            <div class="col-md-6">
                                <select name="categoriaModificar" class="form-control">
                                    <option value="cliente">cliente</option>
                                    <option value="admin">admin</option>
                                </select>
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
            <div class="col-md-6">
                <form class="form-horizontal" action="controlUsuario">
                    <fieldset>
                        <legend>Borrar Usuario</legend>
                        <input type="hidden" name="accion" value="borrar" />
                        <div class="form-group">
                            <label class="col-md-6 control-label" for="idBorrar">Numero de ID</label>
                            <div class="col-md-6">
                                <select name="idBorrar" class="form-control">
                                    <c:forEach items="${listaUsuarios.dameListaTodos()}" var="usuario" varStatus="loop">
                                        <c:if test="${loop.count ne usuario.getIdUsuario()}">
                                            <option value="${usuario.getIdUsuario()}">ID ${usuario.getIdUsuario()} - ${usuario.getUserName()}</option>  
                                        </c:if>
                                    </c:forEach>
                                </select>
                                <span class="help-block">Seleccione el usuario a borrar</span>  
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-6 control-label" for="buttonBorrar"></label>
                            <div class="col-md-6">
                                <button type="submit" value="borrar" name="buttonBorrar" class="btn btn-primary">Eliminar Usuario</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </body>
</html>