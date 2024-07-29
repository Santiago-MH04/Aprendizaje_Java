package APIServlet.Cookie.Lecciones.Controllers;

import APIServlet.Cookie.Lecciones.Service.*;
import APIServlet.Headers.Models.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos-cookie.html", "/productos-cookie"})
public class ProductoServlet extends HttpServlet {
    //Atributos de ProductoServlet
    //Constructores de ProductoServlet
    //Asignadores de atributos de ProductoServlet (setter)
    //Lectores de atributos de ProductoServlet (getter)
        //Métodos de ProductoServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService Service = new ProductoServiceImpl();
        List<Producto> Productos = Service.Listar();

        LoginService SeAutoriza = new LoginServiceImpl();
        Optional<String> CookieOptional = SeAutoriza.getUsername(req);

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {    //Con el try-catch, el recurso se cierra automáticamente

            out.println("<!DOCTYPE html>");
            out.println("<html>");            //Siempre que se abre, se cierra
            out.println("    <head>");
            out.println("         <meta charset = \"UTF-8\">");
            out.println("         <title>Listado de productos</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("       <h1>Listado de productos</h1>");
            if (CookieOptional.isPresent()){
                out.println("<div style='color:blue;'>Hola " + CookieOptional.get() + ", bienvenido</div>");
                out.println("<p><a href=" + req.getContextPath() + "/index.html>Volver</a></p>");
            }
            out.println("<table>");
            out.println("    <tr>");
            out.println("       <th>ID</th>");
            out.println("       <th>Nombre</th>");
            out.println("       <th>Tipo</th>");
            if (CookieOptional.isPresent()) {
                out.println("       <th>Precio</th>");
            }
            out.println("    </tr>");

            Productos.forEach(p -> {
                out.println("    <tr>");
                out.println("       <td>" + p.getID() + "</td>");
                out.println("       <td>" + p.getNombre() + "</td>");
                out.println("       <td>" + p.getTipo() + "</td>");
                if (CookieOptional.isPresent()) {
                    out.println("       <td>" + p.getPrecio() + "</td>");
                }
                out.println("    </tr>");
            });

            out.println("</table>");
            out.println("    </body>");
            out.println("</html>");           //Se cierra porque se abrió

            //out.close();    //No es tan necesario cerrar el recurso, sólo por buenas prácticas
        }
    }
}
