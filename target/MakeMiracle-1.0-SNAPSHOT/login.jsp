<%-- 
    Document   : login
    Created on : 13/11/2019, 05:49:08 PM
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form action="UsuarioServlet" method="post">
              <p>  
            
            <input type="text" name="user" id="user" placeholder="usu">
            <input type="password" name="pass" id="pass" placeholder="passss">
            </p>
            
            <p>
                <input type="submit" value="Acceder" >
            </p>
            </form>
        </div>
        
        
    </body>
</html>
