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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/usuarios/form")
public class UsuarioFormServlet extends HttpServlet {
        //Atributos de UsuarioFormServlet
    @Inject
    private UsuarioService Service;

    //Constructores de UsuarioFormServlet
    //Asignadores de atributos de UsuarioFormServlet (setter)
    //Lectores de atributos de UsuarioFormServlet (getter)
        //Métodos de UsuarioFormServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //Obtener la conexión
        /*Connection Conn = (Connection)req.getAttribute("conn");*/
        /*UsuarioService Service = new UsuarioServiceJDBCImpl(Conn);*/
            //Obtener los parámetros, gestionando errores
        Long ID;
        try {
            ID = Long.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e) {
            ID = 0L;
        }
            //Poblar un objeto de tipo usuario
        Usuario Usuariou = new Usuario();
        if (ID > 0) {
            Optional<Usuario> UsuarioOptional = this.Service.PorID(ID);
            if (UsuarioOptional.isPresent()) {
                Usuariou = UsuarioOptional.get();
            }
        }
            //Configurar los atributos
        req.setAttribute("usuario", Usuariou);
        req.setAttribute("titulum", req.getAttribute("titulum") + ": registro de usuarios");

            //Redirigir a la vista del formulario con los datos del usuario encontrado
        getServletContext().getRequestDispatcher("/form_usuarios.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Obtener la conexión
        /*Connection Conn = (Connection)req.getAttribute("conn")*/;
        /*UsuarioService Service = new UsuarioServiceJDBCImpl(Conn);*/

            //Obtener los parámetros, gestionando errores
        Long ID;
        try {
            ID = Long.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e) {
            ID = 0L;
        }
        String NombreUsuario = req.getParameter("username");
        String Contraseña = req.getParameter("password");
        String Correo = req.getParameter("email");

            //Crear mapa con los errores que se puedan presentar
        Map<String, String> Errores = new HashMap<>();

        if (NombreUsuario == null || NombreUsuario.isBlank()){
            Errores.put("username", "Se requiere un nombre de usuario");
        }
        if ((ID == 0) && (Contraseña == null || Contraseña.isBlank())){
            Errores.put("password", "Es necesario asignar una contraseña");
        }
        if (Correo == null || Correo.isBlank()){
            Errores.put("email", "Se requiere una dirección de correo válida");
        }

            //Poblar un objeto de tipo usuario, que se guarde en caso de error
        Usuario Usuarini = new Usuario();
        if (ID > 0) {
            Optional<Usuario> UsuarioOptional = this.Service.PorID(ID);
            if (UsuarioOptional.isPresent()) {
                Usuarini = UsuarioOptional.get();
            }
        }
        Usuarini.setNombreUsuario(NombreUsuario);
        Usuarini.setCorreo(Correo);

        if (Contraseña != null && !(Contraseña.isBlank())){
            Usuarini.setContraseña(Contraseña);
        }

            //Ejecutar la modificación de la base de datos
        if (Errores.isEmpty()){
                //Si el mapa de errores está vacío, redirigir a la lista de los usuarios
            this.Service.Guardar(Usuarini);
                //Redirigir al controlador que lista los usuarios
            resp.sendRedirect(req.getContextPath() + "/usuarios-session");
        } else {
                // Si el mapa de errores no está, al mismo formulario, con los datos anteriormente poblados
            req.setAttribute("usuario", Usuarini);
            req.setAttribute("erroresU", Errores);
            req.setAttribute("titulum", req.getAttribute("titulum") + ": formulario de usuarios");
            getServletContext().getRequestDispatcher("/form_usuarios.jsp").forward(req, resp);
        }
    }
}

