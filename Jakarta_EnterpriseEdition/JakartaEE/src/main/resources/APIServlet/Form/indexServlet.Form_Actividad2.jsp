<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%
    Map<String, String> errores = (Map<String, String>)request.getAttribute("errores");  //.set o .getAtribute() devuelven genéricos de tipo Object. Se hace necesario un cast
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
    <h3>Registro de compras</h3>

<div class="px-5">
<form action="/JakartaEE/crear" method="post">

    <div>
        <label for="nombre">Nombre del producto</label>
        <div class="col-sm-4">
            <input type="text" name="nombre" id="nombre" class="form-control" value="${param.nombre}">
        </div>
        <%
            if(errores != null && errores.containsKey("nombre")){
                out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errores.get("nombre") + "</small>");
            }
        %>
    </div>
    <div>
        <label for="precio">Precio $</label>
        <div class="row-mb-3">
            <input type="text" name="precio" id="precio" class="form-control" value="${param.precio}">
        </div>
        <%
            if(errores != null && errores.containsKey("precio")){
                out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errores.get("precio") + "</small>");
            }
        %>
    </div>
    <div class="row-mb-3">
        <label for="fabricante" class="col-form-label col-sm-2">Fabricante</label>
        <div>
            <input type="text" name="fabricante" id="fabricante" class="form-control" value="${param.fabricante}">
        </div>
        <%
            if(errores != null && errores.containsKey("precio")){
                out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errores.get("precio") + "</small>");
            }
        %>
    </div>
    <div class="row mb-3">
            <label for="categoría" class="col-form-label col-sm-2">Categorías</label>
            <div>
            <div class="col-sm-4">
                <select name="categoría" id="categoría" class="form-select" multiple>
                    <option value="">-- seleccionar --</option>
                    <option value="1" ${paramValues.categoría.equals("1")? "selected" : ""}>
                        Ropa deportiva
                    </option>
                    <option value="2" ${paramValues.categoría.equals("2")? "selected" : ""}>
                        Tecnología
                    </option>
                    <option value="3" ${paramValues.categoría.equals("3")? "selected" : ""}>
                        Frutas y verduras
                    </option>
                    <option value="4" ${paramValues.categoría.equals("4")? "selected" : ""}>
                        Electrodomésticos
                    </option>
                    <option value="5" ${paramValues.categoría.equals("5")? "selected" : ""}>
                        Juguetería
                    </option>
                </select>
            </div>
            <%
                if(errores != null && errores.containsKey("categoría")){
                    out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errores.get("categoría") + "</small>");
                }
            %>
            </div>
        </div>
    </div>
    <div class="px-5">
        <div class="row-mb-5">
            <input type="submit" value="Enviar" class="btn btn-success">
        </div>
    </div>
    
</form>
</div>
</body>
</html>