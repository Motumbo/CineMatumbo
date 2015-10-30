<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="EstilosExternos/dataGridTheme.css" rel="stylesheet" type="text/css"/>
        <script src="ScriptsExternos/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="ScriptsExternos/shieldui-all.min.js" type="text/javascript"></script>
        <title>Gestion salas</title>
    </head>
    <jsp:include page="topMenu.jsp" />
    <body class="theme-light">
        <form class="form-horizontal">
            <fieldset>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="buttondropdown">Cine</label>
                    <div class="col-md-4">
                        <select id="selectCine" class="form-control" onchange="">
                            <c:forEach items="${listaCines.dameListaTodos()}" var="cine" varStatus="loop">
                                <option value="${cine.getIdCine()}">${cine.getNombre()}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </fieldset>
        </form>
        <div id="grid"></div>
        <script type="text/javascript">
            var gridData = [
            <c:forEach items="${listaSalas.DameAllSalasCine(1)}" var="sala" varStatus="status">
            {
                "id": "${sala.getIdSala()}",
                "nombre": "${sala.getNombre()}",
                "filas": "${sala.getFilas()}",
                "columnas": "${sala.getColumnas()}",
                "tiempoLimpieza": "${sala.getTiempoLimpieza()}"
            }
                <c:if test="${!status.last}">
            ,
                </c:if>
            </c:forEach>
            ];
        </script>
        <script src="ScriptsExternos/dataGridSalas.js" type="text/javascript"></script>
    </body>
</html>