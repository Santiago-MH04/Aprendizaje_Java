package APIServlet.Headers.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/hora-actualizada")
public class HoraActualizadaServlet extends HttpServlet {
    //Atributos de HoraActualizadaServlet
    //Constructores de HoraActualizadaServlet
    //Asignadores de atributos de HoraActualizadaServlet (setter)
    //Lectores de atributos de HoraActualizadaServlet (getter)
        //Métodos de HoraActualizadaServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("refresh","1");  //Así, se actualiza la hora constantemente, cada 1s

        LocalTime HoraActual = LocalTime.now();
        DateTimeFormatter DF = DateTimeFormatter.ofPattern("HH:mm:ss");

        try (PrintWriter out = resp.getWriter()) {    //Con el try-catch, el recurso se cierra automáticamente
            out.println("<!DOCTYPE html>");
            out.println("<html>");            //Siempre que se abre, se cierra
            out.println("    <head>");
            out.println("         <meta charset = \"UTF-8\">");
            out.println("         <title>La hora actualizada</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("       <h1>La hora actualizada</h1>");
            out.println("           <h3>Hora: " + HoraActual.format(DF) + " h</h3>");
            out.println("    </body>");
            out.println("</html>");           //Se cierra porque se abrió

            //out.close();    //No es tan necesario cerrar el recurso, sólo por buenas prácticas
        }
    }
}
