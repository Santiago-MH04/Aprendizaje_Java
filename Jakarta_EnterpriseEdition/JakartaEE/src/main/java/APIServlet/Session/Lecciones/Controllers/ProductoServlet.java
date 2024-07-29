package APIServlet.Session.Lecciones.Controllers;

import APIServlet.Session.Lecciones.Configs.Calificadores.ProductoServicePrincipal;
import APIServlet.Session.Lecciones.Service.*;
import APIServlet.Session.Lecciones.Models.Producto;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos-session.html", "/productos-session"})
public class ProductoServlet extends HttpServlet {
        //Atributos de ProductoServlet
    @Inject /*@Named("defecto")*/
    @ProductoServicePrincipal
    private ProductoService Service;
    @Inject
    private LoginService SeAutoriza;

    //Constructores de ProductoServlet
    //Asignadores de atributos de ProductoServlet (setter)
    //Lectores de atributos de ProductoServlet (getter)
        //Métodos de ProductoServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,  IOException {
            //Obtener la conexión
        /*Connection Conn = (Connection)req.getAttribute("conn");*/
        /*ProductoService Service = new ProductoServiceJDBCImpl(Conn)*/;

            //Obtener los productos de la base de datos
        List<Producto> Productos = this.Service.Listar();

        /*LoginService SeAutoriza = new LoginServiceImpl_Session();*/
        Optional<String> UsuarioSessionOptional = this.SeAutoriza.getUsername(req);

            //Información que va a ser mostrada en la vista
        req.setAttribute("productos", Productos);
        req.setAttribute("username", UsuarioSessionOptional);
        req.setAttribute("titulum", req.getAttribute("titulum") + ": listado de productos");

            //Redirección a la vista
        getServletContext().getRequestDispatcher("/listar_productos.jsp").forward(req, resp);

        /*String MensajeRequest = (String)req.getAttribute("mensaje");
        String MensajeApp = (String)getServletContext().getAttribute("mensaje");

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

            if (UsuarioSessionOptional.isPresent()) {
                out.println("<div style='color:blue;'>Hola " + UsuarioSessionOptional.get() + ", bienvenido</div>");
                out.println("<p><a href=" + req.getContextPath() + "/index.jsp>Volver</a></p>");
            }

            out.println("<table>");
            out.println("    <tr>");
            out.println("       <th>ID</th>");
            out.println("       <th>Nombre</th>");
            out.println("       <th>Tipo</th>");
            if (UsuarioSessionOptional.isPresent()) {
                out.println("       <th>Precio</th>");
                out.println("       <th>Agregar</th>");
            }
            out.println("    </tr>");

            Productos.forEach(p -> {
                out.println("    <tr>");
                out.println("       <td style=\"text-align: center\">" + p.getID() + "</td>");
                out.println("       <td style=\"text-align: center\">" + p.getNombre() + "</td>");
                out.println("       <td style=\"text-align: center\">" + p.getCategoria() + "</td>");
                if (UsuarioSessionOptional.isPresent()) {
                    out.println("       <td style=\"text-align: center\">" + p.getPrecio() + "</td>");
                    out.println("       <td style=\"text-align: center\"><a href=\"" + req.getContextPath() +
                            "/carrito/modificar-session?id=" +      //Se envía el ID del producto como parámetro id
                            p.getID() +
                            "\">Añadir al carrito</a></td>");
                }
                out.println("    </tr>");
            });

            out.println("</table>");
            out.println("<p>" + MensajeApp + "</p>");
            out.println("<p>" + MensajeRequest + "</p>");
            out.println("    </body>");
            out.println("</html>");           //Se cierra porque se abrió

            //out.close();    //No es tan necesario cerrar el recurso, sólo por buenas prácticas
        }*/
    }
}
