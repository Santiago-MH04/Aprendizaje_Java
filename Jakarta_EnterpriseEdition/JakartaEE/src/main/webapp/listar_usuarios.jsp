<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp" />
<h3>${titulum}</h3>
<c:if test="${username.present}">
    <a class="btn btn-primary my-2" href="${pageContext.request.contextPath}/usuarios/form">Crear usuario [+]</a>
</c:if>
<table class="table table-hover table-striped">
    <tr>
        <th>ID</th>
        <th>Nombre de usuario</th>
        <th>Correo electrónico</th>
        <c:if test="${username.present}">
            <th>Editar información</th>
            <th>Eliminar usuario</th>
        </c:if>
    </tr>
    <c:forEach items="${usuarios}" var="u">
        <tr>
            <td>${u.ID}</td>
            <td>${u.nombreUsuario}</td>
            <td>${u.correo}</td>
            <c:if test="${requestScope.username.present}">
                <td><a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/usuarios/form?id=${u.ID}">Editar</a></td>
                <td><a class="btn btn-sm btn-danger" onclick="return confirm('¿Está seguro de que desea eliminar a este usuario?')"
                       href="${pageContext.request.contextPath}/usuarios/eliminar?id=${u.ID}">
                       Eliminar usuario
                    </a>
                </td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<jsp:include page="layout/footer.jsp" />
