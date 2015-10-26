<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <div class="input-group">
                            <input id="buttondropdown" name="buttondropdown" class="form-control" placeholder="Seleccione el cine" required="" type="text">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu pull-right"></ul>
                            </div>
                        </div>
                    </div>
                </div>
            </fieldset>
        </form>
        <div id="grid"></div>
        <script src="ScriptsExternos/dataGridSalas.js" type="text/javascript"></script>
    </body>
</html>