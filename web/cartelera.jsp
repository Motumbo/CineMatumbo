<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="EstilosExternos/carteleraStyle.css" rel="stylesheet" type="text/css"/>
        <title>Cartelera</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <div class="container">
            <div id="blog" class="row"> 
                <div class="col-md-10 blogShort">
                    <h1>Title 1</h1>
                    <img src="http://www.kaczmarek-photo.com/wp-content/uploads/2012/06/guinnes-150x150.jpg" alt="Sin imagen disponible" class="pull-left img-responsive thumb margin10 img-thumbnail">
                    <article><p></p></article>
                    <a class="btn btn-blog pull-right marginBottom10" href="http://bootsnipp.com/user/snippets/2RoQ">READ MORE</a>
                </div>
                <div class="col-md-12 gap10"></div>
            </div>
        </div>
    </body>
</html>
