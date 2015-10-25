<%-- 
    Document   : registro
    Created on : Oct 22, 2015, 6:14:37 PM
    Author     : Nico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <form id="registerForm" class="form-horizontal" action="Control_Usuario">
            <fieldset>
                <input type="hidden" name="accion" value="registrarse" />
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="usuario">Usuario</label>  
                    <div class="col-md-4">
                        <input id="textinput" name="usuario" placeholder="Ingrese su nombre de usuario" class="form-control input-md" required="" type="text">

                    </div>
                </div>

                <!-- Text input
                <div class="form-group">
                    <label class="col-md-4 control-label" for="mail">E-Mail</label>  
                    <div class="col-md-4">
                        <input id="textinput" name="mail" placeholder="Ingrese su correo electrónico" class="form-control input-md" required="" type="text">

                    </div>
                </div>
-->
                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="password">Contraseña</label>
                    <div class="col-md-4">
                        <input id="passwordinput" name="password" placeholder="Ingrese su contraseña" class="form-control input-md" required="" type="password">

                    </div>
                </div>
                
                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="singlebutton"></label>
                    <div class="col-md-4">
                        <button id="singlebutton" type="submit" value="registro" name="singlebutton" class="btn btn-primary">Crear cuenta</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </body>
</html>
