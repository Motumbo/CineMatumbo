<%-- 
    Document   : login
    Created on : Oct 22, 2015, 4:49:43 PM
    Author     : Nico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <form id="loginForm" class="form-horizontal" action="Control_Usuario">
            <fieldset>
                <input type="hidden" name="accion" value="login" />
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="usuario">Usuario</label>  
                    <div class="col-md-4">
                        <input id="userinput" name="usuario" placeholder="Ingrese su nombre de usuario" class="form-control input-md" required="" type="text">

                    </div>
                </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="password">Contraseña</label>
                    <div class="col-md-4">
                        <input id="passwordinput" name="password" placeholder="Ingrese su contraseña" class="form-control input-md" required="" type="password">

                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="loginbutton"></label>
                    <div class="col-md-4">
                        <button id="loginbutton" value="login" type="submit" name="loginbutton" class="btn btn-primary">Log in</button>
                    </div>
                </div>

            </fieldset>
        </form>

    </body>
</html>
