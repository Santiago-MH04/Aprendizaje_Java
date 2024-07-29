<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Color color</title>
</head>
<body>
    <h3 style="color: ${cookie.color.getValue() == null? "black" : cookie.color.getValue()}">Actividad 3: cambiando el color de un texto</h3>
        <p style="color: ${cookie.color.getValue() == null? "black" : cookie.color.getValue()}">Hola Mundo. Cambiemos el color del texto de acuerdo con estas opciones</p>

        <form action="/JakartaEE/cambiar-color" method="get">
    <div>
        <label for="color">Cambiar color</label>
        <div>
            <div>
                <select name="color" id="color">
                    <option value="blue">Azul</option>
                    <option value="red">Rojo</option>
                    <option value="green">Verde</option>
                    <option value="aqua">Aguamarina</option>
                    <option value="BlueViolet">Violeta</option>
                    <option value="Gray">Gris</option>
                    <option value="Cyan">Cyan</option>
                </select>
            </div>
        </div>
    </div>
    <div>
        <input type="submit" value="Cambiar">
    </div>
    </form>
</body>
</html>