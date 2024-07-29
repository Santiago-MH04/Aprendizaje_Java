package APIServlet.Headers.Controllers;

import APIServlet.Headers.Models.Producto;
import APIServlet.Headers.Service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/buscar-producto")
public class BuscarProductoServlet extends HttpServlet {
    //Atributos de BuscarProductoServlet
    //Constructores de BuscarProductoServlet
    //Asignadores de atributos de BuscarProductoServlet (setter)
    //Lectores de atributos de BuscarProductoServlet (getter)
        //Métodos de BuscarProductoServlet
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService Service = new ProductoServiceImpl();
        String Nombre = req.getParameter("producto");

        Optional<Producto> Encontrado = Service.BuscarProducto(Nombre);

        if(Encontrado.isPresent()){
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {    //Con el try-catch, el recurso se cierra automáticamente
                out.println("<!DOCTYPE html>");
                out.println("<html>");            //Siempre que se abre, se cierra
                out.println("    <head>");
                out.println("         <meta charset = \"UTF-8\">");
                out.println("         <title>Producto encontrado</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("       <h1>Producto encontrado</h1>");
                out.println("           <h3>Producto encontrado: " + Encontrado.get().getNombre() +
                        ". Precio: $ " + Encontrado.get().getPrecio() + "</h3>");
                out.println("    </body>");
                out.println("</html>");           //Se cierra porque se abrió

                //out.close();    //No es tan necesario cerrar el recurso, sólo por buenas prácticas
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,
                    "Lo sentimos, el producto " + Nombre + " no ha sido encontrado");
        }
    }
}
