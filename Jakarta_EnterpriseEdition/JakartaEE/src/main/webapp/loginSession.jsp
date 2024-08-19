<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<jsp:include page="layout/header.jsp" />    <%--La directiva include es distinta de la etiqueta include, cuidadongos--%>
    <h3>${titulum}</h3>
    <form action="${pageContext.request.contextPath}/login-session" method="post">
        <div class="row my-2">
            <label class="form-label" for="username">Nombre de usuario</label>
            <div class="col-sm-4">
                <input class="form-control" type="text" name="username" id="username">
            </div>
        </div>
        <div class="row my-2">
            <label class="form-label" for="password">Contraseña</label>
            <div class="col-sm-4">
                <input class="form-control" type="password" name="password" id="password">
            </div>
        </div>
        <div class="row my-2">
            <div>
                <input class="btn btn-primary" type="submit" value="Enviar">
            </div>
        </div>
    </form>
<jsp:include page="layout/footer.jsp" />    <%--La directiva include es distinta de la etiqueta include, cuidadongos--%>