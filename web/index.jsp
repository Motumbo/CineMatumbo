<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="headerInclude.jsp" />
        <title>CineMatumbo</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <div class="container">
            <h1 style="text-align: center">CARTELERA</h1>
            <div id="blog" class="row"> 
                <c:forEach items="${listaPeliculas.dameListaTodos()}" var="pelicula" varStatus="status">
                    <div class="col-md-10 blogShort">
                        <h1>${pelicula.getNombre()}</h1>
                        <img src="${pelicula.getImagen()}" width="160" alt="Sin imagen disponible" class="img-responsive thumb margin10 img-thumbnail">
                        <p>Genero: ${pelicula.getGenero()}</p>
                        <p>Clasificacion: ${pelicula.getClasificacion()}</p>
                        <p>Duracion: ${pelicula.getDuracion()} minutos</p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
