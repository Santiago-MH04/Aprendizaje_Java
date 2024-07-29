<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--<%@ taglib uri="jakarta.tags.core" prefix="d"%>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listeners HTTP</title>
</head>
<body>
    <h1>Manejo de Listeners</h1>
    <p>Hola Mundo, bienvenidos a la actividad 5</p>
    <p>El autor es ${pageContext.request.getAttribute("nombre-completo")}</p>
</body>
</html>