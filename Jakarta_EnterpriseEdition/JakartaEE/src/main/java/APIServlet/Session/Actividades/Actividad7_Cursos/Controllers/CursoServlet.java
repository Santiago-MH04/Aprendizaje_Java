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
import java.sql.Connection;
import java.util.List;

@WebServlet({"/indexcurso.html", "/cursos/buscar"})
    //Si es de interés ejecutar esta actividad en el futuro, cambiar
    // la dirección a /index.jsp
public class CursoServlet extends HttpServlet {
        //Atributos de CursoServlet
    @Inject
    private CursoServiceActividad Service;
    //Constructores de CursoServlet
    //Asignadores de atributos de CursoServlet (setter)
    //Lectores de atributos de CursoServlet (getter)

        //Métodos de CursoServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //Obtener la conexión, ya creada desde el filtro
        /*Connection ConnActividad = (Connection)req.getAttribute("connAct");*/
            //Utilizar la clase Service, para obtener la información que va en la aplicación web
        /*CursoServiceActividad Service = new CursoServiceActividadImpl(ConnActividad);*/
        List<Curso> Cursos = this.Service.Listar();
            //Crear parámetros para la vista
        req.setAttribute("titre", "Actividad 7: listado de cursos");
        req.setAttribute("cursos", Cursos);
            //Redirigir a la vista
        getServletContext().getRequestDispatcher("/listar_cursos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //Obtener la conexión, ya creada desde el filtro y los parámetros del formulario
        Connection ConnActividad = (Connection)req.getAttribute("connAct");
        String Nombre = req.getParameter("nombre");
            //Utilizar la clase Service, para buscar información de acuerdo con los deseos del usuario
        /*CursoServiceActividad Service = new CursoServiceActividadImpl(ConnActividad);*/
        List<Curso> Cursos = this.Service.PorNombre(Nombre);
            //Crear parámetros para la nueva vista
        req.setAttribute("titre", "Actividad 7: filtrando cursos");
        req.setAttribute("cursos", Cursos);
            //Redirigir a la vista
        getServletContext().getRequestDispatcher("/listar_cursos.jsp").forward(req, resp);
    }
}
