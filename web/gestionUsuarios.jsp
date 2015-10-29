<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:useBean id="listaUsuarios" class="Controladora.Usuario_Control" scope="request"/>
<jsp:setProperty name="listaUsuarios" property="*"/>
<html>
    <head>
        <link href="EstilosExternos/dataGridTheme.css" rel="stylesheet" type="text/css"/>
        <script src="ScriptsExternos/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="ScriptsExternos/shieldui-all.min.js" type="text/javascript"></script>
        <title>Gestion usuarios</title>
    </head>
    <jsp:include page="topMenu.jsp" />
    <body class="theme-light">
        <form action="controlUsuario">
            <div id="grid" ></div>

            <script type="text/javascript">
                var gridData = [
                <c:forEach items="${listaUsuarios.listaUsuarios}" var="usuario" varStatus="status">
                {
                "id": "${usuario.getIdUsuario()}",
                        "nombre": "${usuario.getUserName()}",
                        "email": "${usuario.getMail()}",
                        "categoria": "${usuario.getCategoria()}"
                }
                    <c:if test="${!status.last}">
                ,
                    </c:if>

                </c:forEach>
                ];
            </script>             
            <script src="ScriptsExternos/dataGridUsuarios.js" type="text/javascript"></script>

        </form>
    </body>
</html>