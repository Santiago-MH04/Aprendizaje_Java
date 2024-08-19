<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="layout/header.jsp" />    <%--La directiva include es distinta de la etiqueta include, cuidadongos--%>
    <h3>${titulum}</h3>    <!--El referer quiere decir la dirección de la última consulta de un sitio en particular-->
    <ul class="list-group">
        <li class="list-group-item active">Menú de opciones</li>    <%--Te lo muestra en un color más fuerte--%>
        <li class="list-group-item">
            <a href="${pageContext.request.contextPath}/productos-session">Productos disponibles</a>
        </li>
        <li class="list-group-item">
            <a href="${pageContext.request.contextPath}/login-session.html">Iniciemos sesión</a>  <!--Por favor verificar que el archivo login y el index
                                                                    se encuentren ambos en la carpeta webapp para ejecutar sin errores-->
        </li>
        <li class="list-group-item">
            <a href="${pageContext.request.contextPath}/carrito/ver">Carrito de compras</a>
        </li>
        <li class="list-group-item">
            <a href="${pageContext.request.contextPath}/logout-session">Cerremos sesión</a>
        </li>
    </ul>
<jsp:include page="layout/footer.jsp" />    <%--La directiva include es distinta de la etiqueta include, cuidadongos--%>