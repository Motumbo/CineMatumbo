<%-- 
    Document   : cartelera
    Created on : Oct 24, 2015, 8:16:57 PM
    Author     : Nico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="EstilosExternos/carteleraStyle.css" rel="stylesheet" type="text/css"/>
        <title>Cartelera</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <div class="container">
            <div id="blog" class="row"> 
                <div class="col-md-10 blogShort">
                    <h1>Title 1</h1>
                    <img src="http://www.kaczmarek-photo.com/wp-content/uploads/2012/06/guinnes-150x150.jpg" alt="post img" class="pull-left img-responsive thumb margin10 img-thumbnail">

                    <em>This snippet use <a href="http://bootsnipp.com/snippets/featured/sexy-sidebar-navigation" target="_blank">Sexy Sidebar Navigation</a></em>
                    <article><p>
                            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text
                            ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only 
                            five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release
                            of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of
                            Lorem Ipsum.    
                        </p></article>
                    <a class="btn btn-blog pull-right marginBottom10" href="http://bootsnipp.com/user/snippets/2RoQ">READ MORE</a> 
                </div>
                <div class="col-md-10 blogShort">
                    <h1>Title 2</h1>
                    <img src="http://www.kaczmarek-photo.com/wp-content/uploads/2012/06/DSC_4073-150x150.jpg" alt="post img" class="pull-left img-responsive thumb margin10 img-thumbnail">
                    <article><p>
                            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text
                            ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only 
                            five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release
                            of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of
                            Lorem Ipsum.
                        </p></article>
                    <a class="btn btn-blog pull-right marginBottom10" href="http://bootsnipp.com/user/snippets/2RoQ">READ MORE</a> 
                </div>

                <div class="col-md-10 blogShort">
                    <h1>Title 3</h1>
                    <img src="http://www.kaczmarek-photo.com/wp-content/uploads/2012/06/DSC_1681-150x150.jpg" alt="post img" class="pull-left img-responsive thumb margin10 img-thumbnail">
                    <article><p>
                            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text
                            ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only 
                            five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release
                            of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of
                            Lorem Ipsum.
                        </p></article>
                    <a class="btn btn-blog pull-right marginBottom10" href="http://bootsnipp.com/user/snippets/2RoQ">READ MORE</a> 
                </div>

                <div class="col-md-12 gap10"></div>
            </div>
        </div>
    </body>
</html>
