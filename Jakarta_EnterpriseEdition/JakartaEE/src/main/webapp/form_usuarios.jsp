<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib uri="jakarta.tags.core" prefix="d"%>--%>
<jsp:include page="layout/header.jsp" />
        <h3>${titulum}</h3>
    <form action="${pageContext.request.contextPath}/usuarios/form" method="post">
        <div class="row mb-2">
            <label for="username">Nombre de usuario</label>
            <div>
                <input type="text" name="username" id="username" value="${usuario.nombreUsuario}">
            </div>
            <c:if test="${erroresU != null && erroresU.containsKey('username')}">
                <div style="color:red">${errores.username}</div>
            </c:if>
        </div>
        <div class="row mb-2">
            <label for="password">Contraseña</label>
            <div>
                <input type="password" name="password" id="password">
            </div>
            <c:if test="${erroresU != null && erroresU.containsKey('password')}">
                <div style="color:red">${errores.password}</div>
            </c:if>
        </div>
        <div class="row mb-2">
            <label for="email">Nombre de usuario</label>
            <div>
                <input type="text" name="email" id="email" value="${usuario.correo}">
            </div>
            <c:if test="${erroresU != null && erroresU.containsKey('email')}">
                <div style="color:red">${errores.email}</div>
            </c:if>
        </div>
        <div class="row mb-2">
            <div>
                <input class="btn btn-primary" type="submit" value="${(requestScope.usuario.ID != null && usuario.ID > 0) ? "Editar registro" : "Guardar cambios"}">
            </div>
        </div>
            <input type="hidden" value="${(usuario.ID != null && usuario.ID > 0) ? usuario.ID : 0}">
    </form>
<jsp:include page="layout/footer.jsp" />