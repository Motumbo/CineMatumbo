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
        <%@include file="topMenu.jsp" %>
        <form class="form-horizontal">
            <fieldset>
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="userinput">Usuario</label>  
                    <div class="col-md-4">
                        <input id="userinput" name="userinput" placeholder="Ingrese su nombre de usuario" class="form-control input-md" required="" type="text">

                    </div>
                </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="passwordinput">Contraseña</label>
                    <div class="col-md-4">
                        <input id="passwordinput" name="passwordinput" placeholder="Ingrese su contraseña" class="form-control input-md" required="" type="password">

                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="loginbutton"></label>
                    <div class="col-md-4">
                        <button id="loginbutton" name="loginbutton" class="btn btn-primary">Log in</button>
                    </div>
                </div>

            </fieldset>
        </form>

    </body>
</html>
