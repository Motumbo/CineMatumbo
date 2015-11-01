<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="headerInclude.jsp" />
        <title>Gestion Peliculas</title>
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
                <th>Titulo</th>
                <th>Genero</th>
                <th>Clasificacion</th>
                <th>Duracion</th>
                <th>Imagen</th>
                </thead>
                <c:forEach items="${listaPeliculas.dameListaTodos()}" var ="pelicula">
                    <tr>
                        <td>${pelicula.getIdPelicula()}</td>
                        <td>${pelicula.getNombre()}</td>
                        <td>${pelicula.getGenero()}</td>
                        <td>${pelicula.getClasificacion()}</td>
                        <td>${pelicula.getDuracion()} minutos</td>
                        <td><img src="${pelicula.getImagen()}" width="50"></td>
                    </tr>                 
                </c:forEach>
            </table>
        </div>
        <div class="col-md-4">
            <form class="form-horizontal" action="controlPelicula">
                <fieldset>
                    <legend>Agregar Pelicula</legend>
                    <input type="hidden" name="accion" value="agregar" />
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="nombreAgregar">Titulo</label>  
                        <div class="col-md-6">
                            <input name="nombreAgregar" placeholder="Ingrese el titulo de la pelicula" class="form-control input-md" required="" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="generoAgregar">Genero</label>  
                        <div class="col-md-6">
                            <input name="generoAgregar" placeholder="Ingrese el genero de la pelicula" class="form-control input-md" required="" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="clasificacionAgregar">Clasificacion</label>
                        <div class="col-md-6">
                            <select name="clasificacionAgregar" class="form-control">
                                <option value="ATP">ATP</option>
                                <option value="+13">+13</option>
                                <option value="+16">+16</option>
                                <option value="+18">+18</option>
                            </select>
                            <span class="help-block">Seleccione la clasificacion de la pelicula</span>  
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="duracionAgregar">Duracion</label>  
                        <div class="col-md-6">
                            <input name="duracionAgregar" placeholder="Ingrese la duracion de la pelicula" class="form-control input-md" required="" type="number" min="0">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="imagenAgregar">Imagen</label>  
                        <div class="col-md-6">
                            <input name="imagenAgregar" placeholder="Ingrese el link de la imagen de la pelicula" class="form-control input-md" required="" type="url">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="buttonAgregar"></label>
                        <div class="col-md-6">
                            <button type="submit" value="agregar" name="buttonAgregar" class="btn btn-primary">Crear pelicula</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
        <div class="col-md-4">
            <form class="form-horizontal" action="controlPelicula">
                <fieldset>
                    <legend>Modificar Pelicula</legend>
                    <input type="hidden" name="accion" value="modificar" />
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="idModificar">Pelicula</label>
                        <div class="col-md-6">
                            <select name="idModificar" class="form-control">
                                <c:forEach items="${listaPeliculas.dameListaTodos()}" var="pelicula">
                                    <option value="${pelicula.getIdPelicula()}">ID ${pelicula.getIdPelicula()} - ${pelicula.getNombre()}</option>
                                </c:forEach>
                            </select>
                            <span class="help-block">Seleccione la pelicula a modificar</span>  
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="nombreModificar">Titulo</label>  
                        <div class="col-md-6">
                            <input name="nombreModificar" placeholder="Nuevo titulo de la pelicula" class="form-control input-md" required="" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="generoModificar">Genero</label>  
                        <div class="col-md-6">
                            <input name="generoModificar" placeholder="Nuevo genero de la pelicula" class="form-control input-md" required="" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="clasificacionModificar">Clasificacion</label>  
                        <div class="col-md-6">
                            <select name="clasificacionModificar" class="form-control">
                                <option value="ATP">ATP</option>
                                <option value="+13">+13</option>
                                <option value="+16">+16</option>
                                <option value="+18">+18</option>
                            </select>
                            <span class="help-block">Seleccione la clasificacion de la pelicula</span>  
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="duracionModificar">Duracion</label>  
                        <div class="col-md-6">
                            <input name="duracionModificar" placeholder="Nueva duracion de la pelicula" class="form-control input-md" required="" type="number" min="0">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="imagenModificar">Imagen</label>  
                        <div class="col-md-6">
                            <input name="imagenModificar" placeholder="Nuevo link de la imagen de la pelicula" class="form-control input-md" required="" type="url">
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
            <form class="form-horizontal" action="controlPelicula">
                <fieldset>
                    <legend>Borrar Pelicula</legend>
                    <input type="hidden" name="accion" value="borrar" />
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="idBorrar">Pelicula</label>
                        <div class="col-md-6">
                            <select name="idBorrar" class="form-control">
                                <c:forEach items="${listaPeliculas.dameListaTodos()}" var="pelicula">
                                    <option value="${pelicula.getIdPelicula()}">ID ${pelicula.getIdPelicula()} - ${pelicula.getNombre()}</option>
                                </c:forEach>
                            </select>
                            <span class="help-block">Seleccione la pelicula a borrar</span>  
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-6 control-label" for="buttonBorrar"></label>
                        <div class="col-md-6">
                            <button type="submit" value="borrar" name="buttonBorrar" class="btn btn-primary">Eliminar Pelicula</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
</html>
