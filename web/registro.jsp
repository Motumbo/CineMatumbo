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
        <form class="form-horizontal">
            <fieldset>
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Usuario</label>  
                    <div class="col-md-4">
                        <input id="textinput" name="textinput" placeholder="Ingrese su nombre de usuario" class="form-control input-md" required="" type="text">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">E-Mail</label>  
                    <div class="col-md-4">
                        <input id="textinput" name="textinput" placeholder="Ingrese su correo electrónico" class="form-control input-md" required="" type="text">

                    </div>
                </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="passwordinput">Contraseña</label>
                    <div class="col-md-4">
                        <input id="passwordinput" name="passwordinput" placeholder="Ingrese su contraseña" class="form-control input-md" required="" type="password">

                    </div>
                </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="passwordinput">Repetir contraseña</label>
                    <div class="col-md-4">
                        <input id="passwordinput" name="passwordinput" placeholder="Vuelva a ingresar su contraseña" class="form-control input-md" required="" type="password">

                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="singlebutton"></label>
                    <div class="col-md-4">
                        <button id="singlebutton" name="singlebutton" class="btn btn-primary">Crear cuenta</button>
                    </div>
                </div>

            </fieldset>
        </form>

    </body>
</html>
