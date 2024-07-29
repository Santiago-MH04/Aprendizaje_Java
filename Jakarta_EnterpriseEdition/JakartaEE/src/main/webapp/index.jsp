<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib uri="jakarta.tags.core" prefix="d"%>--%>
<jsp:include page="layout/header.jsp" />
    <h3>${titulum}</h3>     <!--El referer quiere decir la dirección de la última consulta de un sitio en particular-->
        <ul class="list-group">
            <li class="list-group-item active">Menú de opciones</li>    <%--Te lo muestra en un color más fuerte--%>
            <li class="list-group-item">
                <a href="${pageContext.request.contextPath}/usuarios-session">Usuarios enlistados</a>
            </li>
            <li class="list-group-item">
                <a href="${pageContext.request.contextPath}/productos-session">Productos disponibles</a>
            </li>
            <li class="list-group-item">
                <a href="${pageContext.request.contextPath}/login-session">Iniciemos sesión</a>  <!--Por favor verificar que el archivo login y el index
                                                                                                    se encuentren ambos en la carpeta webapp para ejecutar
                                                                                                    sin errores-->
            </li>
            <li class="list-group-item">
                <a href="${pageContext.request.contextPath}/carrito/ver">Carrito de compras</a>
            </li>
            <li class="list-group-item">
                <a href="${pageContext.request.contextPath}/logout-session">Cerremos sesión</a>
            </li>
            <li class="list-group-item">
                <a href="${pageContext.request.contextPath}/indexSession_Actividad5.jsp">Nuestros primeros Listeners: actividad 5</a>
            </li>
        </ul>
<jsp:include page="layout/footer.jsp" />
