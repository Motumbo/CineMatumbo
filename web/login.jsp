<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="headerInclude.jsp" />
        <title>Log in</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <c:if test="${usuarioConectado.existe(usuarioConectado)}">
            <c:redirect url="index.jsp"/>
        </c:if>
        <form id="loginForm" class="form-horizontal" action="controlUsuario">
            <fieldset>
                <input type="hidden" name="accion" value="login" />
                <div class="form-group">
                    <label class="col-md-4 control-label" for="usuarioLogin">Usuario</label>  
                    <div class="col-md-4">
                        <input name="usuarioLogin" placeholder="Ingrese su nombre de usuario" class="form-control input-md" required="" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="passwordLogin">Contraseña</label>
                    <div class="col-md-4">
                        <input name="passwordLogin" placeholder="Ingrese su contraseña" class="form-control input-md" required="" type="password">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="buttonLogin"></label>
                    <div class="col-md-4">
                        <button value="login" type="submit" name="buttonLogin" class="btn btn-primary">Log in</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </body>
</html>
