package APIServlet.Session.Lecciones.Controllers;

import APIServlet.Session.Lecciones.Models.Usuario;
import APIServlet.Session.Lecciones.Service.*;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Optional;

@WebServlet({"/login-session", "/login-session.html"})
public class LoginServlet extends HttpServlet {
        //Atributos de LoginServlet
    /*final static String USERNAME = "Quesocolo";
    final static String PASSWORD = "Churus1529*";*/
    @Inject
    private UsuarioService Service;
    @Inject
    private LoginService SeAutoriza;

    //Constructores de LoginServlet
    //Asignadores de atributos de LoginServlet (setter)
    //Lectores de atributos de LoginServlet (getter)
        //Métodos de LoginServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*LoginService SeAutoriza = new LoginServiceImpl_Session();*/
        Optional<String> UsuarioSessionOptional = this.SeAutoriza.getUsername(req);

        if (UsuarioSessionOptional.isPresent()){
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {    //Con el try-catch, el recurso se cierra automáticamente
                out.println("<!DOCTYPE html>");
                out.println("<html>");            //Siempre que se abre, se cierra
                out.println("    <head>");
                out.println("         <meta charset = \"UTF-8\">");
                out.println("         <title>Hola " + UsuarioSessionOptional.get() + "</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("       <h1>Hola " + UsuarioSessionOptional.get() + ". Has iniciado sesión exitosamente</h1>");
                out.println("<p><a href=" + req.getContextPath() + "/index.jsp>Volver</a></p>");
                out.println("<p><a href=" + req.getContextPath() + "/logout-session.html>Cerrar sesión</a></p>");
                out.println("    </body>");
                out.println("</html>");           //Se cierra porque se abrió

                //out.close();    //No es tan necesario cerrar el recurso, sólo por buenas prácticas
            }
        } else {
            req.setAttribute("titulum", req.getAttribute("titulum") + ": iniciar sesión");
            getServletContext().getRequestDispatcher("/loginSession.jsp").forward(req, resp);    //Tener varias direcciones parece ser la solución
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String NombreUsuario = req.getParameter("username");
        String Contraseña = req.getParameter("password");

            /*if(USERNAME.equals(NombreUsuario) && PASSWORD.equals(Contraseña)){
                HttpSession Sesión = req.getSession();
                Sesión.setAttribute("username", NombreUsuario);
                    //Para ahorrar código y no confundir al usuario
                resp.sendRedirect(req.getContextPath() + "/login-session.html");
            } else {
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos, no está autorizado a ingresar con las credenciales usadas");
            }*/

        /*UsuarioService Service = new UsuarioServiceJDBCImpl((Connection)req.getAttribute("conn"));*/
        Optional<Usuario> UsuarioOptional = this.Service.Login(NombreUsuario, Contraseña);

        if (UsuarioOptional.isPresent()){
            HttpSession Sesión = req.getSession();
            Sesión.setAttribute("username", NombreUsuario);
                //Para ahorrar código y no confundir al usuario
            resp.sendRedirect(req.getContextPath() + "/login-session.html");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos, no está autorizado a ingresar con las credenciales usadas");
        }
    }
}
