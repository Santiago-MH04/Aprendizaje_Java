package APIServlet.Session.Actividades;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/perfil-usuario")
public class PerfilUsuarioServlet extends HttpServlet {
    //Atributos de PerfilUsuarioServlet
    //Constructores de PerfilUsuarioServlet
    //Asignadores de atributos de PerfilUsuarioServlet (setter)
    //Lectores de atributos de PerfilUsuarioServlet (getter)

       //Métodos de PerfilUsuarioServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String NombreUsuario = "";

        if (req.getSession().getAttribute("nombre") != null) {
            NombreUsuario = (String) req.getSession().getAttribute("nombre");
        }
        if (NombreUsuario.isBlank()) {
            NombreUsuario = "usuario";
            req.getSession().setAttribute("nombre", "usuario");
        }

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {    //Con el try-catch, el recurso se cierra automáticamente
            out.println("<!DOCTYPE html>");
            out.println("<html>");            //Siempre que se abre, se cierra
            out.println("    <head>");
            out.println("         <meta charset = \"UTF-8\">");
            out.println("         <title>Perfil de usuario</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("       <h1>Bienvenido " + NombreUsuario + ". Has desbloqueado la actividad 4</h1>");
            out.println("           <ul>");
            out.println("               <li>Nombre de usuario : " + NombreUsuario + "</li>");
            out.println("           </ul>");
            out.println("           <p><a href=" + req.getContextPath() + "/index.jsp" + ">Volver a inicio</a></p>");
            out.println("    </body>");
            out.println("</html>");           //Se cierra porque se abrió

            //out.close();    //No es tan necesario cerrar el recurso, sólo por buenas prácticas
        }
    }
}
