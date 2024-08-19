package APIServlet.Session.Actividades.Actividad7_Cursos.Controllers;

import APIServlet.Session.Actividades.Actividad7_Cursos.ModelosActividad.Curso;
import APIServlet.Session.Actividades.Actividad7_Cursos.ServiceActividad.CursoServiceActividad;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/eliminar/cursos")
public class CursoEliminarServlet extends HttpServlet {
        //Atributos de CursoEliminarServlet
    @Inject
    private CursoServiceActividad Service;
    //Constructores de CursoEliminarServlet
    //Asignadores de atributos de CursoEliminarServlet (setter)
    //Lectores de atributos de CursoEliminarServlet (getter)

        //Métodos de CursoEliminarServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //Obtener la conexión
        /*Connection ConnActividad = (Connection)req.getAttribute("connAct");*/
            //Instanciar el servicio
        /*CursoServiceActividad Service = new CursoServiceActividadImpl(ConnActividad);*/
            //Obtener el ID, con manejo de errores
        Long ID;
        try {
            ID = Long.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e) {
            ID = 0L;
        }
        if (ID > 0) {
                //Obtener un Optional de curso, para evadir cualquier posible error
            Optional<Curso> OC = this.Service.PorID(ID);
                //Ejecutar la acción de eliminación
            if (OC.isPresent()) {
                this.Service.Eliminar(ID);
                    //Redirigir a la primera vista, en caso de éxito
                resp.sendRedirect(req.getContextPath() + "/cursos/buscar");
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "El curso solicitado no se encuentra en la base de datos");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "¡Error!: el ID del curso debe agregarse como parámetro de la búsqueda");
        }
        //Redirigir a la vista
    }
}
