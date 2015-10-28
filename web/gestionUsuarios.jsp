<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:useBean id="listaUsuarios" class="Controladora.Usuario_Control" scope="application"/>
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
            <input type="hidden" name="accion" value="listar"/>
            <button value="listar" type="submit" name="buttonLogin" class="btn btn-primary">LISTAR</button>
            <div id="grid" ></div>
            <script type="text/javascript">
                var gridData = [
                <c:forEach items="${listaUsuarios.listaUsuarios}" var="element" varStatus="status">
                {
                "id" : ${element.id},
                        "nombre": ${element.nombre},
                        "email": ${element.email},
                        "categoria": ${element.categoria}
                }
                    <c:if test="${!status.last}">
                ,
                    </c:if>
                        ]
                </c:forEach>
            </script>
            <script src="ScriptsExternos/dataGridUsuarios.js" type="text/javascript"></script>
        </form>
    </body>
</html>