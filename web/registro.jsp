<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="headerInclude.jsp" />
        <title>Registro</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <c:if test="${usuarioConectado.existe(usuarioConectado)}">
            <c:redirect url="index.jsp"/>
        </c:if>
        <form id="registerForm" class="form-horizontal" action="controlUsuario">
            <fieldset>
                <input type="hidden" name="accion" value="registro" />
                <div class="form-group">
                    <label class="col-md-4 control-label" for="usuarioRegistro">Usuario</label>  
                    <div class="col-md-4">
                        <input name="usuarioRegistro" placeholder="Ingrese su nombre de usuario" class="form-control input-md" required="" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="mailRegistro">E-Mail</label>  
                    <div class="col-md-4">
                        <input name="mailRegistro" placeholder="Ingrese su correo electrónico" class="form-control input-md" required="" type="email">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="passwordRegistro">Contraseña</label>
                    <div class="col-md-4">
                        <input name="passwordRegistro" placeholder="Ingrese su contraseña" class="form-control input-md" required="" type="password">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="buttonRegistro"></label>
                    <div class="col-md-4">
                        <button type="submit" value="registro" name="buttonRegistro" class="btn btn-primary">Crear cuenta</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </body>
</html>
