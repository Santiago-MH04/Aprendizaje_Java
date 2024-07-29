<%@page contentType="UTF-8" import="java.util.*, APIServlet.Session.Actividades.Actividad7_Cursos.ModelosActividad.*"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%--<%@ taglib uri="jakarta.tags.core" prefix="d"%>--%>
<%
  String Titre = (String)request.getAttribute("titre");
  List<Curso> Cursos = (List<Curso>)request.getAttribute("cursos");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><%=Titre%></title>
</head>
<body>
  <h1><%=Titre%></h1>
  <p><a href="<%=request.getContextPath()%>/cursos/form">Crear [+]</a></p>
  <form action="<%=request.getContextPath()%>/cursos/buscar" method="post">
    <input type="text" name="nombre" />
    <input type="submit" value="Buscar" />
  </form>
  <table>
    <tr>
      <th>ID</th>
      <th>Nombre</th>
      <th>Instructor</th>
      <th>Duraci&oacute;n</th>
      <th>Editar curso</th>
      <th>Eliminar</th>
    </tr>
    <% for (Curso C : Cursos){ %>
      <tr>
        <td><%=C.getID()%></td>
        <td><%=C.getNombre()%></td>
        <td><%=C.getInstructor()%></td>
        <td><%=C.getLongevidad()%></td>
        <td><a href="<%=request.getContextPath()%>/cursos/form?id=<%=C.getID()%>    ">Modificar</a></td>
        <td><a onclick="return confirm('¿Está seguro de que desea eliminar este curso?');"
                href="<%=request.getContextPath()%>/eliminar/cursos?id=<%=C.getID()%>">Eliminar
            </a>
        </td>
      </tr>
    <% } %>
  </table>
</body>
</html>