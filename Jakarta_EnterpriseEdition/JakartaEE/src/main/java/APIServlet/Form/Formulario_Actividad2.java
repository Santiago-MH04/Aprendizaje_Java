package APIServlet.Form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/crear")
public class Formulario_Actividad2 extends HttpServlet {
    //Atributos de FormServlet
    //Constructores de FormServlet
    //Asignadores de atributos de FormServlet (setter)
    //Lectores de atributos de FormServlet (getter)

    //Métodos de FormServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    //Lo que tiene que tener nuestro formulario
    //    - nombre (no vacío)
    //    - precio (no vacío y entero)
    //    - fabricante (no vacío, entre 4 y 10 caracteres)

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String nombre = req.getParameter("nombre"); //El argumento va con el nombre del index.jsp
        Integer precio = null;
        try {
            precio = Integer.valueOf(req.getParameter("precio")); //El argumento va con el nombre del index.jsp
        } catch(NumberFormatException e){

        }
        String fabricante = req.getParameter("fabricante"); //El argumento va con el nombre del index.jsp
        Integer categoría = null;
        try {
            categoría = Integer.valueOf(req.getParameter("categoría")); //El argumento va con el nombre del index.jsp
        } catch(NumberFormatException e){

        }

        Map<String, String> Errores = new HashMap<>();      //Alt+J es el comando que he estado buscando toda mi vida

        if (nombre == null || nombre.isBlank()){
            Errores.put("nombre", "El nombre del producto es requerido");
        }
        if (precio == null || precio < 1){
            Errores.put("precio", "El precio debe ser un número natural");
        }
        if (fabricante == null || fabricante.isBlank()){
            Errores.put("fabricante", "El nombre del fabricante es requerido");
        } else if (fabricante.length() < 4 || fabricante.length() > 10) {
            Errores.put("fabricante", "El nombre del fabricante debe tener entre 4 y 10 caracteres");
        }
        if (categoría == null){
            Errores.put("categoría", "Debe seleccionar una categoría");
        }

        if (Errores.isEmpty()) {
            try (PrintWriter out = resp.getWriter()) {    //Con el try-catch, el recurso se cierra automáticamente
                out.println("<!DOCTYPE html>");
                out.println("<html>");            //Siempre que se abre, se cierra
                out.println("    <head>");
                out.println("         <meta charset = \"UTF-8\">");
                out.println("         <title>Resultado formulario</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("       <h1>Resultado formulario</h1>");
                out.println("       <ul>");


                out.println("           <li>Nombre: " + nombre + "</li>");
                out.println("           <li>Precio: $" + precio + "</li>");
                out.println("           <li>Fabricante: " + fabricante + "</li>");
                out.println("           <li>Categoría: " + categoría + "</li>");

                out.println("       </ul>");
                out.println("    </body>");
                out.println("</html>");           //Se cierra porque se abrió

                //out.close();    //No es tan necesario cerrar el recurso, sólo por buenas prácticas
            }
        } else {
            //Mostrar los mensajes de error dentro del propio formulario
                /*Errores.forEach(err -> {
                    out.println("<li>" + err + "</li>");
                });
                out.println("<p><a href = \"/JakartaEE/index.jsp\">Volver</a></p>");*/

            req.setAttribute("errores", Errores);
            getServletContext().getRequestDispatcher("/index.jsp") //Recordar siempre asociar a la ruta indicada, y cambiarlo por el index.jsp
                    .forward(req, resp);                                //Renombrando al index.jsp en index.jsp, pasa a soportar código Java
        }
    }
}
