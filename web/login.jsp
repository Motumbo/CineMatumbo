<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Log in</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <form id="loginForm" class="form-horizontal" action="controlUsuario">
            <fieldset>
                <input type="hidden" name="accion" value="login" />
                <div class="form-group">
                    <label class="col-md-4 control-label" for="usuario">Usuario</label>  
                    <div class="col-md-4">
                        <input id="userinput" name="usuario" placeholder="Ingrese su nombre de usuario" class="form-control input-md" required="" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="password">Contraseña</label>
                    <div class="col-md-4">
                        <input id="passwordinput" name="password" placeholder="Ingrese su contraseña" class="form-control input-md" required="" type="password">
                    </div>
                </div>
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
