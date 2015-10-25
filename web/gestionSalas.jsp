<%-- 
    Document   : gestionSalas
    Created on : Oct 24, 2015, 8:15:39 PM
    Author     : Nico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link id="themecss" rel="stylesheet" type="text/css" href="//www.shieldui.com/shared/components/latest/css/light-bootstrap-gradient/all.min.css" />
        <script type="text/javascript" src="//www.shieldui.com/shared/components/latest/js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="//www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
    </head>
    <jsp:include page="topMenu.jsp" />
    <body class="theme-light">
        <form class="form-horizontal">
            <fieldset>
                <!-- Button Drop Down -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="buttondropdown">Cine</label>
                    <div class="col-md-4">
                        <div class="input-group">
                            <input id="buttondropdown" name="buttondropdown" class="form-control" placeholder="Seleccione el cine" required="" type="text">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">

                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu pull-right">
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </fieldset>
        </form>
        <div id="grid"></div>
        <script src="ScriptsExternos/dataGridSalas.js.js" type="text/javascript"></script>
    </body>
</html>