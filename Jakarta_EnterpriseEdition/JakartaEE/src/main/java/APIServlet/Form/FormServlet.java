package APIServlet.Form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/registro")
public class FormServlet extends HttpServlet {
    //Atributos de FormServlet
    //Constructores de FormServlet
    //Asignadores de atributos de FormServlet (setter)
    //Lectores de atributos de FormServlet (getter)
        //Métodos de FormServlet
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username"); //El argumento va con el nombre del index.html
        String password = req.getParameter("password"); //El argumento va con el nombre del index.html
        String email = req.getParameter("email"); //El argumento va con el nombre del index.html
        String país = req.getParameter("país"); //El argumento va con el nombre del index.html
        String[] lenguajes = req.getParameterValues("lenguajes"); //El argumento va con el nombre del index.html
        String[] roles = req.getParameterValues("roles"); //El argumento va con el nombre del index.html

        boolean habilitar = req.getParameter("habilitar") != null &&
                req.getParameter("habilitar").equals("on"); //El argumento va con el nombre del index.html
        String idioma = req.getParameter("idioma");       //El argumento va con el nombre del index.html
        String secreto = req.getParameter("secreto");     //El argumento va con el nombre del index.html

        Map<String, String> Errores = new HashMap<>();      //Alt+J es el comando que he estado buscando toda mi vida

        if (username == null || username.isBlank()) {
            Errores.put("username", "El nombre de usuario es requerido");
        }
        if (password == null || password.isBlank()) {
            Errores.put("password", "La contraseña no puede ser vacía");
        }
        if (email == null || !email.contains("@")) {
            Errores.put("email", "El formato de correo es inválido");
        }
        if (país == null || país.isEmpty()) {
            Errores.put("país", "El páis es requerido");
        }
        if (lenguajes == null || lenguajes.length == 0) {
            Errores.put("lenguajes", "Debe seleccionar, al menos, un lenguaje de programación");
        }
        if (roles == null || roles.length == 0) {
            Errores.put("roles", "Debe seleccionar, al menos, un rol");
        }
        if (idioma == null) {
            Errores.put("idioma", "Debe seleccionar un idioma");
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


                out.println("           <li>Usuario: " + username + "</li>");
                out.println("           <li>Contraseña: " + password + "</li>");
                out.println("           <li>Correo: " + email + "</li>");
                out.println("           <li>País: " + país + "</li>");

                out.println("           <li>Lenguajes de programación: <ul>");     //Hay que recorrer este arreglo, correspondiente a los lenguajes de programación
                Arrays.asList(lenguajes).forEach(l -> {
                    out.println("               <li>" + l + "</li>");     //Así se recorre la cuestión
                });
                out.println("           </ul></li>");     //Se cierra el recorrido, conservando la jerarquía

                out.println("           <li>Roles: <ul>");     //Hay que recorrer este arreglo, correspondiente a los roles
                Arrays.asList(roles).forEach(r -> {
                    out.println("               <li>" + r + "</li>");     //Así se recorre la cuestión
                });
                out.println("           </ul></li>");     //Se cierra el recorrido, conservando la jerarquía

                out.println("           <li>Idioma: " + idioma + "</li>");
                out.println("           <li>Habilitado: " + habilitar + "</li>");
                out.println("           <li>Secreto: " + secreto + "</li>");

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
                out.println("<p><a href = \"/JakartaEE/index.html\">Volver</a></p>");*/

            req.setAttribute("errores", Errores);
            /*getServletContext().getRequestDispatcher("/index.html")
                    .forward(req, resp);*/                                //Renombrando al index.html en index.html, pasa a soportar código Java

            getServletContext().getRequestDispatcher("/index.html")
                    .forward(req, resp);                                //Renombrando al index.html en index.html, pasa a soportar código Java
        }
    }
}
