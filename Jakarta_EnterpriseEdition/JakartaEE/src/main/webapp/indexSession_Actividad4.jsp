<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--<%@ taglib uri="jakarta.tags.core" prefix="d"%>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sesiones HTTP</title>
</head>
<body>
    <h3>Manejo de sesiones, actividad 4</h3>
    <p>Hola <%=session.getAttribute("nombre") != null? session.getAttribute("nombre"): "usuario"%>, bienvenido a la actividad 4</p>
    <form action="/JakartaEE/guardar-session" method="post">
        <div>
            <label for="nombre">Ingresa tu nombre de sesión</label>
            <div>
                <input type="text" name="nombre" id="nombre">
            </div>
        </div>
        <div>
            <input type="submit" value="Enviar">
        </div>
    </form>
</body>
</html>