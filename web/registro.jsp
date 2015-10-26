<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <form id="registerForm" class="form-horizontal" action="controlUsuario">
            <fieldset>
                <input type="hidden" name="accion" value="registrarse" />
                <div class="form-group">
                    <label class="col-md-4 control-label" for="usuario">Usuario</label>  
                    <div class="col-md-4">
                        <input id="textinput" name="usuario" placeholder="Ingrese su nombre de usuario" class="form-control input-md" required="" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="mail">E-Mail</label>  
                    <div class="col-md-4">
                        <input id="textinput" name="mail" placeholder="Ingrese su correo electrónico" class="form-control input-md" required="" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="password">Contraseña</label>
                    <div class="col-md-4">
                        <input id="passwordinput" name="password" placeholder="Ingrese su contraseña" class="form-control input-md" required="" type="password">
                    </div>
                </div>
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
