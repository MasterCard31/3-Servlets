<%-- 
    Document   : loginMongo
    Created on : 7 abr. 2023, 19:50:17
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/WebApp03/ServletLoginMongo" method="post">
        <label for="username">Nombre de usuario:</label>
        <input type="text" id="username" name="username"><br>
        <label for="password">Contraseña:</label>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="Iniciar sesión">
</form>
    </body>
</html>
