<%@page contentType="text/html" pageEncoding="UTF-8"
 import="java.util.*, APIServlet.Session.Actividades.Actividad7_Cursos.ModelosActividad.*"
%>
<%--<%@ taglib uri="jakarta.tags.core" prefix="d"%>--%>
<%
 Curso C = (Curso)request.getAttribute("curso");
 String Título = (String)request.getAttribute("titulus");
 Map<String, String> Errores = (Map<String, String>)request.getAttribute("errores");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><%=Título%>></title>
</head>
<body>
    <h1><%=Título%>></h1>
    <p><a href="<%request.getContextPath()%>/cursos/buscar">Volver</a></p>
    <form action="<%request.getContextPath()%>/cursos/form" method="post">
        <div>
            <label for="nombre">Nombre del curso</label>
            <input type="text" name="nombre" id="nombre" value="<%=C.getNombre() != null ? C.getNombre() : ""%>">
            <div>
                <% if (Errores != null && Errores.containsKey("nombre")) {%>
                    <div><%=Errores.get("nombre")%></div>
                <% } %>
            </div>
        </div>
        <div>
            <label for="descripcion">Descripción</label>
            <input type="text" name="descripcion" id="descripcion" value="<%=C.getNombre() != null ? C.getNombre() : ""%>">
            <% if (Errores != null && Errores.containsKey("descripcion")) {%>
                <div><%=Errores.get("descripcion")%></div>
            <% } %>
        </div>
        <div>
            <label for="instructor">Instructor</label>
            <input type="text" name="instructor" id="instructor" value="<%=C.getNombre() != null ? C.getNombre() : ""%>">
            <% if (Errores != null && Errores.containsKey("instructor")) {%>
                <div><%=Errores.get("instructor")%></div>
            <% } %>
        </div>
        <div>
            <label for="duracion">Duración del curso</label>
            <input type="text" name="duracion" id="duracion" value="<%=C.getNombre() != null ? C.getNombre() : ""%>">
            <% if (Errores != null && Errores.containsKey("duracion")) {%>
                <div><%=Errores.get("duracion")%></div>
            <% } %>
        </div>
        <div><input type="submit" value="<%=(C.getID() != null && C.getID() > 0) ? "Editar" : "Guardar" %>"></div>
        <input type="hidden" name="id" value="<%=C.getID()%>">
    </form>
</body>
</html>