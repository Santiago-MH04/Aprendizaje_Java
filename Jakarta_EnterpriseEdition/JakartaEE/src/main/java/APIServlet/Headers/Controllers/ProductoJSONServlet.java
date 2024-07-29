package APIServlet.Headers.Controllers;

import APIServlet.Headers.Models.Producto;
import APIServlet.Headers.Service.ProductoService;
import APIServlet.Headers.Service.ProductoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/productos.json")
public class ProductoJSONServlet extends HttpServlet {
    //Atributos de ProductoXLSServlet
    //Constructores de ProductoXLSServlet
    //Asignadores de atributos de ProductoXLSServlet (setter)
    //Lectores de atributos de ProductoXLSServlet (getter)
        //Métodos de ProductoXLSServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService Service = new ProductoServiceImpl();
        List<Producto> Productos = Service.Listar();

        ObjectMapper Mapper = new ObjectMapper();   //Este objeto sirve para empezar a crear el JSON
        String json = Mapper.writeValueAsString(Productos);

        resp.setContentType("application/json");
        resp.getWriter().write(json);               //El parámetro de salida se escribe como un JSON
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream JSONStream = req.getInputStream();

        ObjectMapper Mapper = new ObjectMapper();   //Este objeto sirve para empezar a transformar el JSON recibido
        Producto ElProducto = Mapper.readValue(JSONStream, Producto.class);

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {    //Con el try-catch, el recurso se cierra automáticamente
            out.println("<!DOCTYPE html>");
            out.println("<html>");            //Siempre que se abre, se cierra
            out.println("    <head>");
            out.println("         <meta charset = \"UTF-8\">");
            out.println("         <title>Detalle del producto desde JSON</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("       <h1>Detalle del producto desde JSON</h1>");
            out.println("       <ul>");
            out.println("           <li>ID: " + ElProducto.getID() + "</li>");
            out.println("           <li>Nombre: " + ElProducto.getNombre() + "</li>");
            out.println("           <li>Tipo: " + ElProducto.getTipo() + "</li>");
            out.println("           <li>Precio: " + ElProducto.getPrecio() + "</li>");
            out.println("       </ul>");
            out.println("    </body>");
            out.println("</html>");           //Se cierra porque se abrió

            //out.close();    //No es tan necesario cerrar el recurso, sólo por buenas prácticas
        }
    }
}
