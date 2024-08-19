package APIServlet.Session.Lecciones.Controllers;

import APIServlet.Session.Lecciones.Models.Usuario;
import APIServlet.Session.Lecciones.Service.UsuarioService;
import APIServlet.Session.Lecciones.Service.UsuarioServiceJDBCImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/usuarios/eliminar")
public class UsuarioEliminarServlet extends HttpServlet {
        //Atributos de UsuarioEliminarServlet
    @Inject
    private UsuarioService Service;
    //Constructores de UsuarioEliminarServlet
    //Asignadores de atributos de UsuarioEliminarServlet (setters)
    //Lectores de atributos de UsuarioEliminarServlet (getters)
        //Métodos de UsuarioEliminarServlet

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //Obtener la conexión
        /*Connection Conn = (Connection)req.getAttribute("conn");*/
        /*UsuarioService Service = new UsuarioServiceJDBCImpl(Conn);*/
            //Obtener el parámetro de eliminación
        Long ID;
        try {
            ID = Long.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e) {
            ID = 0L;
        }
            //Eliminar el registro
        if (ID > 0){
            Optional<Usuario> UsuarioOptional = this.Service.PorID(ID);
            if (UsuarioOptional.isPresent()) {
                this.Service.Eliminar(ID);
                    //Redirigir al controlador de la vista de usuarios
                resp.sendRedirect(req.getContextPath()+ "/usuarios-session");
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "El usuario con el ID indicado no está en la base de datos");
            }
        } else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "El ID de usuario debe ser no nulo, mayor que cero, y enviarse como parámetro en la URL");
        }
    }
}
