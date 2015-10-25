<%-- 
    Document   : topMenu
    Created on : Oct 22, 2015, 5:53:08 PM
    Author     : Nico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="usuarioConectado" class="Modelo.Usuario" scope="session"/>
<jsp:setProperty name="usuarioConectado" property="*"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="Bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <title>CineMatumbo</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-12">
                    <div class="row">
                        <div class="col-sm-12 col-md-12">
                            <div class="col-sm-6 col-md-6">
                                <h1 class="text-muted"><a href="index.jsp">CineMatumbo</a></h1>
                            </div>

                            <div class="col-lg-offset-2 col-sm-4 col-md-4" style="margin-top:15px;">
                                <% //if (usuarioConectado.existe(user)) { %>
                                <!-- HACER QUE SE DESCONECTE LA SESION
                                <a href="index.jsp" class="btn pull-right btn-default" type="button">Log Out</a> -->
                                <% //} else {%>
                                <a href="registro.jsp" class="btn pull-right btn-default" type="button">Registro</a>
                                <a href="login.jsp" class="btn pull-right btn-default" type="button">Log In</a>
                                <%//}%>
                            </div>
                        </div>
                    </div>

                    <div class="navbar navbar-default">
                        <div class="container">
                            <div class="container">
                                <ul class="nav navbar-nav">
                                    <% if (usuarioConectado.getCategoria().equals("admin")) { %>
                                    <li><a href="gestionUsuarios.jsp">Gestionar usuarios</a></li>
                                    <li><a href="gestionSalas.jsp">Gestionar salas</a></li>
                                    <li><a href="gestionPeliculas.jsp">Gestionar películas</a></li>
                                    <li><a href="gestionFunciones.jsp">Gestionar funciones</a></li>
                                        <% } else if (usuarioConectado.getCategoria().equals("cliente")) { %>
                                    <li><a href="cartelera.jsp">Cartelera</a></li>
                                    <li><a href="reservar.jsp">Reservar entradas</a></li>
                                    <li><a href="misReservas.jsp">Mis reservas</a></li>
                                    <li><a href="miCuenta.jsp">Mi cuenta</a></li>
                                        <%}%>

                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
