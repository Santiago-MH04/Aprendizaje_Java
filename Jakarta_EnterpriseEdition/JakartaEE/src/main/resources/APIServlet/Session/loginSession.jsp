<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--<%@ taglib uri="jakarta.tags.core" prefix="d"%>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario login</title>
</head>
<body>
    <h1>Iniciar sesión</h1>
<form action="/JakartaEE/login-session" method="post">
    <div>
        <label for="username">Nombre de usuario</label>
        <div>
            <input type="text" name="username" id="username">
        </div>
    </div>
    <div>
        <label for="password">Contraseña</label>
        <div>
            <input type="password" name="password" id="password">
        </div>
    </div>
    <div>
        <input type="submit" value="Enviar">
    </div>
</form>
</body>
</html>