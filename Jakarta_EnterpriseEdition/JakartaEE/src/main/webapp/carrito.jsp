<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib uri="jakarta.tags.core" prefix="d"%>--%>

<jsp:include page="layout/header.jsp" />
      <h3>${titulum}</h3>
      <c:choose>
          <c:when test="${carrito.items.isEmpty()}"> <%--Ese lujo de no especificar el contexto del carrito me lo puedo dar porque no hay otra variable con el mismo nombre en otro contexto--%>
            <div class="alert alert-warning">Lo sentimos, no hay productos en tu carrito</div>
          </c:when>
          <c:otherwise>
              <form name="formucarrito" action="${pageContext.request.contextPath}/carrito/modificar-session" method="post">
                <table class="table table-hover table-striped">
                  <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Total artículo</th>
                    <th>Eliminar artículo</th>
                  </tr>
                  <c:forEach items="${carrito.items}" var="item">
                    <tr>
                      <td>${item.producto.ID}</td>
                      <td>${item.producto.nombre}</td>
                      <td>${item.producto.precio}</td>
                      <td><input type="text" size="4" name="canti_${item.producto.ID}" value="${item.cantidad}"></td>
                      <td>${item.importe}</td>
                      <td><input type="checkbox" name="Eliminar" value="${item.producto.ID}"></td>
                    </tr>
                  </c:forEach>
                    <tr>
                      <td colspan="4" style="text-align: right">Total compra:</td>
                      <td>${carrito.total}</td>
                      <td></td>
                    </tr>
                </table>
                <a class="btn btn-primary" href="javascript:document.formucarrito.submit();">Guardar cambios</a>
              </form>
          </c:otherwise>
      </c:choose>
      <div class="my-2">
          <a class="btn btn-secondary" href="${pageContext.request.contextPath}/index.jsp">Volver</a>
          <a class="btn btn-success" href="${pageContext.request.contextPath}/productos-session">Seguir comprando</a>
      </div>
<jsp:include page="layout/footer.jsp" />
