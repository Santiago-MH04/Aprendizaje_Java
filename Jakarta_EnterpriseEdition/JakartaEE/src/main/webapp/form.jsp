<%@page contentType="text/html" pageEncoding="UTF-8" import="java.time.format.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib uri="jakarta.tags.core" prefix="d"%>--%> <%--Esto es dizque para superar la vulnerabilidad, pero ni idea de cómo asignarle el prefijo para que funcione--%>

<jsp:include page="layout/header.jsp" />
        <h3>${titulum}</h3>
    <form action="${pageContext.request.contextPath}/productos/form" method="post">
        <div class="row mb-2">
            <label class="col-form-label col-sm-2" for="nombre">Nombre</label>
            <div class="col-sm-4">
                <input class="form-control" type="text" name="nombre" value="${producto.nombre}" id="nombre">
            </div>
            <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('nombre')}">
                <div style="color:red;">${errores.nombre}</div>
            </c:if>
        </div>
        <div class="row mb-2">
            <label class="col-form-label col-sm-2" for="precio">Precio</label>
            <div class="col-sm-4">
                <input class="form-control" type="number" name="precio" value="${(requestScope.producto.precio < 0) ? producto.precio : ""}" id="precio">
            </div>
            <c:if test="${requestScope.erroresP != null && !empty erroresP.precio}">
                <div style="color:red;">${errores.precio}</div>
            </c:if>
        </div>
        <div class="row mb-2">
            <label class="col-form-label col-sm-2" for="sku">SKU</label>
            <div class="col-sm-4">
                <input class="form-control" type="text" name="sku" value="${requestScope.producto.SKU}" id="sku">
            </div>
            <c:if test="${requestScope.erroresP != null && not empty erroresP.sku}">
                <div style="color:red;">${errores.sku}</div>
            </c:if>
        </div>
        <div class="row mb-2">
            <label class="col-form-label col-sm-2" for="fecha_registro">Fecha de registro</label>
            <div class="col-sm-4">
                <input class="form-control" type="date" name="fecha_registro" value="${(requestScope.producto.fechaRegistro != null) ? producto.fechaRegistro.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : ""}" id="fecha_registro">
            </div>
            <c:if test="${requestScope.erroresP != null && requestScope.erroresP.containsKey('fecha_registro')}">
                <div style="color:red;">${errores.fecha_registro}</div>
            </c:if>
        </div>
        <div class="row mb-2">
            <label class="col-form-label col-sm-2" for="categoria">Categoría</label>
            <div class="col-sm-4">
                <select class="form-select" name="categoria" id="categoria">
                    <option value="" selected disabled>---- Seleccionar ----</option>
                    <c:forEach items="${requestScope.categorias}" var="c">
                        <option value="${c.ID}" ${(c.ID.equals(requestScope.producto.categoria.ID)) ? "selected" : ""}> ${c.nombre} </option>
                    </c:forEach>
                </select>
            </div>
            <c:if test="${requestScope.erroresP != null && requestScope.erroresP.containsKey('categoria')}">
                <div style="color:red;">${errores.categoria}</div>
            </c:if>
        </div>
        <div class="row mb-2">
            <div>
                <input class="btn btn-primary" type="submit" value="${(requestScope.producto.ID != null && producto.ID > 0) ? "Editar" : "Guardar"}">
            </div>
        </div>
        <input type="hidden" name="id" value="${producto.ID}"></input>
    </form>
<jsp:include page="layout/footer.jsp" />
