<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%
    Map<String, String> errores = (Map<String, String>)request.getAttribute("errores");  //.set o .getAtribute() devuelven genéricos de tipo Object. Se hace necesario un cast
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
    <h3>Formulario de usuarios</h3>

    <%
        if(errores != null && errores.size() > 0){
    %>
    <ul class="alert alert-danger mx-5 px-5">
        <%for (String error : errores.values()){%>
            <li><%=error%></li> <%--Esto es una expresión del jsp para imprimir una variable--%>
        <%}%>
    </ul>
    <%}%>

<div class="px-5">
<form action="/JakartaEE/registro" method="post">

    <div class="row mb-3">
        <label for="username" class="col-form-label col-sm-2">Usuario</label>
        <div class="col-sm-4">
            <input type="text" name="username" id="username" class="form-control" value="${param.username}">
        </div>          <!--Esto está muy atómico Ctrl+Alt+T para anidar-->
        <%
            if(errores != null && errores.containsKey("username")){
                out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errores.get("username") + "</small>");
            }
        %>
    </div>
    <div class="row mb-3">
        <label for="password" class="col-form-label col-sm-2">Contraseña</label>
        <div class="col-sm-4"><input type="password" name="password" id="password" class="form-control"></div>      <!--El tipo contraseña mejor que vaya oculto-->
        <%
            if(errores != null && errores.containsKey("password")){
                out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errores.get("password") + "</small>");
            }
        %>
    </div>
    <div class="row mb-3">
        <label for="email" class="col-form-label col-sm-2">Correo</label>
        <div class="col-sm-4">
            <input type="text" name="email" id="email" class="form-control" value="${param.email}">
        </div>
        <%
            if(errores != null && errores.containsKey("email")){
                out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errores.get("email") + "</small>");
            }
        %>
    </div>

    <div class="row mb-3">
        <label for="país" class="col-form-label col-sm-2">País</label>
        <div class="col-sm-4">
            <select name="país" id="país" class="form-select">
                <option value="" disabled>--  Seleccionar  --</option>
                <option value="CO" ${param.país.equals("CO")? "selected":""}>Colombia</option>
                <option value="ES" ${param.país.equals("ES")? "selected":""}>España</option>
                <option value="MX" ${param.país.equals("MX")? "selected":""}>México</option>
                <option value="CL" ${param.país.equals("CL")? "selected":""}>Chile</option>
                <option value="AR" ${param.país.equals("AR")? "selected":""}>Argentina</option>
                <option value="PE" ${param.país.equals("PE")? "selected":""}>Perú</option>
                <option value="VE" ${param.país.equals("VE")? "selected":""}>Venezuela</option>
            </select>
        </div>
        <%
            if(errores != null && errores.containsKey("país")){
                out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errores.get("país") + "</small>");
            }
        %>
    </div>

    <div class="row mb-3">
        <label for="lenguajes" class="col-form-label col-sm-2">Lenguajes de programación</label>
        <div>
            <select name="lenguajes" id="lenguajes" class="form-select" multiple>
                <option value="Java" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("Java"))
                .get()? "selected" : ""}>
                    Java
                </option>
                <option value="Python" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("Python"))
                .get()? "selected" : ""}>
                    Python
                </option>
                <option value="Spring" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("Spring"))
                .get()? "selected" : ""}>
                    SpringBoot
                </option>
                <option value="JS" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("JS"))
                .get()? "selected" : ""}>
                    JavaScript
                </option>
                <option value="Angular" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("Angular"))
                .get()? "selected" : ""}>
                    Angular
                </option>
                <option value="React" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("React"))
                .get()? "selected" : ""}>
                    React
                </option>
            </select>
        </div>
        <%
            if(errores != null && errores.containsKey("lenguajes")){
                out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errores.get("lenguajes") + "</small>");
            }
        %>
    </div>

    <div class="row mb-3">
        <label class="col-form-label col-sm-2">Roles</label>
        <div class="form-check col-sm-2">
            <input type="checkbox" name="roles" value="ROLE_ADMIN" class="form-check-input"
            ${paramValues.roles.stream().anyMatch(r -> r.equals("ROLE_ADMIN"))
                            .get()? "checked" : ""}>
            <label class="form-check-label">Administrador</label>
        </div>
        <div class="form-check col-sm-2">
            <input type="checkbox" name="roles" value="ROLE_USER" class="form-check-input"
            ${paramValues.roles.stream().anyMatch(r -> r.equals("ROLE_USER"))
                            .get()? "checked" : ""}>
            <label class="form-check-label">Usuario</label>
        </div>
        <div class="form-check col-sm-2">
            <input type="checkbox" name="roles" value="ROLE_MODERATOR" class="form-check-input"
            ${paramValues.roles.stream().anyMatch(r -> r.equals("ROLE_MODERATOR"))
                            .get()? "checked" : ""}>
            <label class="form-check-label">Moderador</label>
        </div>
        <%
            if(errores != null && errores.containsKey("roles")){
                out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errores.get("roles") + "</small>");
            }
        %>
    </div>

    <div class="row mb-3">
        <label class="col-form-label col-sm-2">Idiomas</label>
        <div class="form-check col-sm-2">
            <input type="radio" name="idioma" value="es" class="form-check-input" ${param.idioma.equals("es")? "checked":""}>
            <label class="form-check-label">Español</label>
        </div>
        <div class="form-check col-sm-2">
            <input type="radio" name="idioma" value="en" class="form-check-input" ${param.idioma.equals("en")? "checked":""}>
            <label class="form-check-label">Inglés</label>
        </div>
        <div class="form-check col-sm-2">
            <input type="radio" name="idioma" value="fr" class="form-check-input" ${param.idioma.equals("fr")? "checked":""}>
            <label class="form-check-label">Francés</label>
        </div>
        <%
            if(errores != null && errores.containsKey("idioma")){
                out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errores.get("idioma") + "</small>");
            }
        %>
    </div>
    
    <div class="row mb-3">
        <label for="habilitar" class="col-form-label col-sm-2">Habilitar</label>
        <div class="form-check col-sm-2">
            <input type="checkbox" name="habilitar" id="habilitar" class="form-check-input" checked>
        </div>
    </div>
    
    <div class="row mb-3">
        <div>
            <input type="submit" value="Enviar" class="btn btn-success">
        </div>
    </div>

    <input type="hidden" name="secreto" value="12345">
    
</form>
</div>
</body>
</html>