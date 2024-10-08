package APIServlet.Session.Lecciones.Controllers;

import APIServlet.Session.Lecciones.Configs.Calificadores.ProductoServicePrincipal;
import APIServlet.Session.Lecciones.Models.Producto;
import APIServlet.Session.Lecciones.Service.ProductoService;
import APIServlet.Session.Lecciones.Service.ProductoServiceJDBCImpl;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/productos/eliminar")
public class ProductoEliminarServlet extends HttpServlet {
        //Atributos de ProductoEliminarServlet
    @Inject/*@Named("defecto")*/
    @ProductoServicePrincipal
    ProductoService Service;

    //Constructores de ProductoEliminarServlet
    //Asignadores de atributos de ProductoEliminarServlet (setters)
    //Lectores de atributos de ProductoEliminarServlet (getters)
        //Métodos de ProductoEliminarServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //Obtener la conexión
        /*Connection Conn = (Connection)req.getAttribute("conn");*/
            //Usar el servicio adecuado
        /*ProductoService Service = new ProductoServiceJDBCImpl(Conn);*/
            //Obtener los parámetros necesarios, desde la vista
        Long ID;
        try {
            ID = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            ID = 0L;
        }
            //Eliminar el registro de la base de datos
        if (ID > 0) {
            Optional<Producto> OP = this.Service.PorID(ID);
            if (OP.isPresent()) {
                this.Service.Eliminar(ID);
                    //Redirigir al controlador de los productos, para obtener la vista actualizada
                resp.sendRedirect(req.getContextPath() + "/productos-session");
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "El producto solicitado no se encuentra en la base de datos");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "¡Error!: un ID válido debe enviarse como parámetro de la URL");
        }
    }
}
