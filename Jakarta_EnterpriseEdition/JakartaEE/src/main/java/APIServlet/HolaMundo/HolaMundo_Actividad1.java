package APIServlet.HolaMundo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/actividad/indexCookie.html")
public class HolaMundo_Actividad1 extends HttpServlet{
    //Atributos de HolaMundo_Actividad1
    //Constructores de HolaMundo_Actividad1
    //Asignadores de atributos de HolaMundo_Actividad1 (setter)
    //Lectores de atributos de HolaMundo_Actividad1 (getter)
        //Métodos de HolaMundo_Actividad1
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String Nombre = req.getParameter("nombre");
        String Apellido = req.getParameter("apellido");

        out.println("<!DOCTYPE html>");
        out.println("<html>");            //Siempre que se abre, se cierra
        out.println("    <head>");
        out.println("         <meta charset = \"UTF-8\">");
        out.println("         <title>Tarea 1: Servlet y envío de parámetros</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("       <h1>Tarea 1: Servlet y envío de parámetros</h1>");
        if (Nombre != null && Apellido != null) {
            out.println("           <h2>¡Hola! Mi nombre es " + Nombre + " " + Apellido + "</h2>");
        } else {
            out.println("           <h2>No se han enviado parámetros para el nombre ni para el apellido</h2>");
            out.println("           <h2>Se requieren ambos</h2>");
        }

        LocalDate FechaActual = LocalDate.now();
        DateTimeFormatter forma = DateTimeFormatter.ofPattern("EEEE dd 'de' MMMM, yyyy");
        String Fecha = forma.format(FechaActual);

        out.println("               <h3>Hoy es " + Fecha + "</h3>");

        out.println("    </body>");
        out.println("</html>");           //Se cierra porque se abrió

        out.close();    //No es tan necesario cerrar el recurso, sólo por buenas prácticas
    }
}
