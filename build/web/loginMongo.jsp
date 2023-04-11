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
        <title>Iniciar sesión</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <form class="row g-3 m-3 " action="/WebApp03/ServletMongo" method="post">
            <div class="col-auto">
                <label for="username" class="visually-hidden">Nombre de usuario:</label>
                <input type="text" name="username" class="form-control" id="username" placeholder="User name">
            </div>
            <div class="col-auto">
                <label for="password" class="visually-hidden">Password</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="Password">
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3">Iniciar sesión</button>
            </div>
        </form>

    </body>
</html>
