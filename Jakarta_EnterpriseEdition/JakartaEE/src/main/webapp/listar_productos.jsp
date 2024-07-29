<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib uri="jakarta.tags.core" prefix="d"%>--%> <%--Todo lo que empiece con @ son directivas, lo demás, etiquetas--%>

<jsp:include page="layout/header.jsp" />    <%--La directiva include es distinta de la etiqueta include, cuidadongos--%>
        <h3>${titulum}</h3>
        <c:if test="${requestScope.username.present}">
            <div class="alert alert-info">Hola ${requestScope.username.get()}, bienvenido</div>
            <a class="btn btn-primary my-2" href="${pageContext.request.contextPath}/productos/form">Crear [+]</a>
        </c:if>
        <p><a href="<c:out value="${pageContext.request.contextPath}" />/index.jsp">Volver</a></p>
        <table class="table table-hover table-striped">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Tipo</th>
                <c:if test="${requestScope.username.present}">
                    <th>Precio</th>
                    <th>Agregar</th>
                    <th>Editar</th>
                    <th>Eliminar producto</th>
                </c:if>
            </tr>
            <c:forEach items="${requestScope.productos}" var="P">
                <tr>
                    <td>${P.getID()}</td>
                    <td>${P.getNombre()}</td>
                    <td>${P.getCategoria().getNombre()}</td>
                    <c:if test="${requestScope.username.present}">
                        <td>${P.getPrecio()}</td>
                        <td><a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/carrito/modificar-session?id=${P.ID}">Añadir al carrito</a></td>
                        <td><a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/productos/form?id=${P.ID}">Modificar</a></td>
                        <td><a class="btn btn-sm btn-danger" onclick="return confirm('¿Está seguro que desea eliminar este producto?')"
                                href="${pageContext.request.contextPath}/productos/eliminar?id=${P.ID}">
                                Eliminar
                            </a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
        <p>${applicationScope.mensaje}</p>
        <p>${requestScope.mensaje}</p>
<jsp:include page="layout/footer.jsp" />
