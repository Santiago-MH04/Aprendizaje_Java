package APIServlet.Headers.Controllers;

import APIServlet.Headers.Models.Producto;
import APIServlet.Headers.Service.ProductoService;
import APIServlet.Headers.Service.ProductoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/productos.xls", "/productos.html", "/productos"})
public class ProductoXLSServlet extends HttpServlet {
    //Atributos de ProductoXLSServlet
    //Constructores de ProductoXLSServlet
    //Asignadores de atributos de ProductoXLSServlet (setter)
    //Lectores de atributos de ProductoXLSServlet (getter)
        //Métodos de ProductoXLSServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService Service = new ProductoServiceImpl();
        List<Producto> Productos = Service.Listar();

        String ServletPath = req.getServletPath();
        boolean EsXLS = ServletPath.endsWith(".xls");

        resp.setContentType("text/html;charset=UTF-8");
        if(EsXLS){
            resp.setContentType("application/vnd.ms-excel");        //Muestra un archivo .xls
            resp.setHeader("Content-Disposition","attachment;filename=productos.xls");  //Fuerza la descarga con el nombre de archivo indicado
        }

        try (PrintWriter out = resp.getWriter()) {    //Con el try-catch, el recurso se cierra automáticamente
            if (!EsXLS) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");            //Siempre que se abre, se cierra
                out.println("    <head>");
                out.println("         <meta charset = \"UTF-8\">");
                out.println("         <title>Listado de productos</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("       <h1>Listado de productos</h1>");
                out.println("<p><a href=\"" + req.getContextPath() + "/productos.xls" + "\">Exportar a .xls (Excel)</a></p>");
                out.println("<p><a href=\"" + req.getContextPath() + "/productos.json" + "\">Listar en formato JSON</a></p>");
            }
            out.println("<table>");
            out.println("    <tr>");
            out.println("       <th>ID</th>");
            out.println("       <th>Nombre</th>");
            out.println("       <th>Tipo</th>");
            out.println("       <th>Precio</th>");
            out.println("    </tr>");

            Productos.forEach(p -> {
                out.println("    <tr>");
                out.println("       <td>" + p.getID() + "</td>");
                out.println("       <td>" + p.getNombre() + "</td>");
                out.println("       <td>" + p.getTipo() + "</td>");
                out.println("       <td>" + p.getPrecio() + "</td>");
                out.println("    </tr>");
            });

            if (!EsXLS) {
                out.println("</table>");
                out.println("    </body>");
                out.println("</html>");           //Se cierra porque se abrió

                //out.close();    //No es tan necesario cerrar el recurso, sólo por buenas prácticas
            }
        }
    }
}
