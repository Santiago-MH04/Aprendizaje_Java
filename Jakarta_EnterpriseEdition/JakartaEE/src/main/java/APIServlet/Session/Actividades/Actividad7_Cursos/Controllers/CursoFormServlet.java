package APIServlet.Session.Actividades.Actividad7_Cursos.Controllers;

import APIServlet.Session.Actividades.Actividad7_Cursos.ModelosActividad.*;
import APIServlet.Session.Actividades.Actividad7_Cursos.ServiceActividad.*;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/cursos/form")
public class CursoFormServlet extends HttpServlet {
        //Atributos de CursoFormServlet
    @Inject
    private CursoServiceActividad Service;
    //Constructores de CursoFormServlet
    //Asignadores de atributos de CursoFormServlet (setter)
    //Lectores de atributos de CursoFormServlet (getter)

        //Métodos de CursoFormServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //Obtener la conexión
        /*Connection ConnActividad = (Connection)req.getAttribute("connAct");*/
        /*CursoServiceActividad Service = new CursoServiceActividadImpl(ConnActividad);*/
            //Obtener los parámetros
        Long ID;
        try {
            ID = Long.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e) {
            ID = 0L;
        }
            //Asignar los parámetros a un objeto de tipo curso
        Curso C = new Curso();
        if (ID > 0) {
            Optional<Curso> CO = this.Service.PorID(ID);
            if (CO.isPresent()) {
                C = CO.get();
            }
        }
            //Crear un atributo del request con el curso, y otro con el título
        req.setAttribute("curso", C);
        req.setAttribute("titulus", ((ID > 0)? "Editar curso" : "Crear curso"));
            //Redirigir a la vista
        getServletContext().getRequestDispatcher("/form_cursos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //Obtener la conexión
        /*Connection ConnActividad = (Connection)req.getAttribute("connAct");*/
        /*CursoServiceActividad Service = new CursoServiceActividadImpl(ConnActividad);*/
            //Obtener los parámetros, gestionando errores
        Long ID;
        try {
            ID = Long.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e) {
            ID = 0L;
        }
        String Nombre = req.getParameter("nombre");
        String Descripción = req.getParameter("descripcion");
        String Instructor = req.getParameter("instructor");
        Double Duración;
        try {
            Duración = Double.valueOf(req.getParameter("duracion"));
        } catch (NumberFormatException e) {
            Duración = 0D;
        }
            //Definir los errores
        Map<String, String> Errores = new HashMap<>();
        if (Nombre == null || Nombre.isBlank()){
            Errores.put("nombre", "El curso debe tener un nombre");
        }
        if (Descripción == null || Descripción.isBlank()){
            Errores.put("descripcion", "Se requiere una descripción para el curso");
        }
        if (Instructor == null || Instructor.isBlank()){
            Errores.put("instructor", "Este curso debe ser impartido por una persona");
        }
        if (Duración <= 0){
            Errores.put("duracion", "El curso tiene que ocupar un período para realizarse");
        }

            //Asignar los parámetros a un objeto del tipo curso
        Curso Cursirijillo = new Curso();
            Cursirijillo.setID(ID);     //Si el ID es 0, esto lo maneja el Service, y con el repositorio crea un nuevo curso
            Cursirijillo.setNombre(Nombre);
            Cursirijillo.setDescripción(Descripción);
            Cursirijillo.setInstructor(Instructor);
            Cursirijillo.setLongevidad(Duración);

            //Ejecutar la actualización
        if(Errores.isEmpty()){
            this.Service.Guardar(Cursirijillo);
                //Redirigir a la vista
            resp.sendRedirect(req.getContextPath() + "/cursos/buscar");
        } else {
                //Crear un atributo del request con el curso, uno con el título y otro con los errores
            req.setAttribute("curso", Cursirijillo);
            req.setAttribute("titulus", ((ID > 0) ? "Editar curso" : "Crear curso"));
            req.setAttribute("errores", Errores);
                //Redirigir al formulario de creación/edición de cursos
            getServletContext().getRequestDispatcher("/form_cursos.jsp").forward(req, resp);
        }
    }
}
