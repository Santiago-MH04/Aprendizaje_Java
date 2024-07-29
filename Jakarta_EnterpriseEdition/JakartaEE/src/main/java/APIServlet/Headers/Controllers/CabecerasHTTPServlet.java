package APIServlet.Headers.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabeceras-request")
public class CabecerasHTTPServlet extends HttpServlet {
    //Atributos de CabecerasHTTPServlet
    //Constructores de CabecerasHTTPServlet
    //Asignadores de atributos de CabecerasHTTPServlet (setter)
    //Lectores de atributos de CabecerasHTTPServlet (getter)
        //Métodos de CabecerasHTTPServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String MétodoHTTP = req.getMethod();
        String RequestURI = req.getRequestURI();
        String RequestURL = req.getRequestURL().toString();
        String ContextPath = req.getContextPath();
        String ServletPath = req.getServletPath();

        String IP = req.getLocalAddr();
        String IPCliente = req.getRemoteAddr();
        int Puerto = req.getLocalPort();
        String Esquema = req.getScheme();
        String Host = req.getHeader("host");

        String URL = Esquema + "://" + Host + ContextPath + ServletPath;
        String URL2 = Esquema + "://" + IP + ":" + Puerto + ContextPath + ServletPath;

        try (PrintWriter out = resp.getWriter()) {    //Con el try-catch, el recurso se cierra automáticamente
            out.println("<!DOCTYPE html>");
            out.println("<html>");            //Siempre que se abre, se cierra
            out.println("    <head>");
            out.println("         <meta charset = \"UTF-8\">");
            out.println("         <title>Cabeceras HTTP Request</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("       <h1>Cabeceras HTTP Request</h1>");
            out.println("       <ul>");
            out.println("               <li>Método HTTP: " + MétodoHTTP + "</li>");
            out.println("               <li>Request URI: " + RequestURI + "</li>");
            out.println("               <li>Request URL: " + RequestURL + "</li>");
            out.println("               <li>Ruta de contexto: " + ContextPath + "</li>");
            out.println("               <li>Ruta del Servlet: " + ServletPath + "</li>");
            out.println("               <li>IP local: " + IP + "</li>");
            out.println("               <li>IP Cliente: " + IPCliente + "</li>");
            out.println("               <li>Puerto local: " + Puerto + "</li>");
            out.println("               <li>Esquema: " + Esquema + "</li>");
            out.println("               <li>Host: " + Host + "</li>");
            out.println("               <li>URL: " + URL + "</li>");
            out.println("               <li>URL2: " + URL2 + "</li>");

            Enumeration<String> headerNames = req.getHeaderNames();
            while(headerNames.hasMoreElements()){
                String Cabecera = headerNames.nextElement();
                out.println("               <li>" + Cabecera + ": " + req.getHeader(Cabecera) + "</li>");
            }

            out.println("       </ul>");
            out.println("    </body>");
            out.println("</html>");           //Se cierra porque se abrió

            //out.close();    //No es tan necesario cerrar el recurso, sólo por buenas prácticas
        }
    }
}
