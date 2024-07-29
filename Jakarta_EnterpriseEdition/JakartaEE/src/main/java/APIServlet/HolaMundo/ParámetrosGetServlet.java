package APIServlet.HolaMundo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros/url-get")
public class ParámetrosGetServlet extends HttpServlet {
    //Atributos de ParámetrosGetServlet
    //Constructores de ParámetrosGetServlet
    //Asignadores de atributos de ParámetrosGetServlet (setter)
    //Lectores de atributos de ParámetrosGetServlet (getter)
        //Métodos de ParámetrosGetServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String Saludo = req.getParameter("saludo");
        String Nombre = req.getParameter("nombre");

            out.println("<!DOCTYPE html>"); //Esta forma, con println sólo se nota en el código fuente
            out.println("<html>");            //Siempre que se abre, se cierra
            out.println("    <head>");
            out.println("         <meta charset = \"UTF-8\">");
            out.println("         <title>Parámetros get de la url</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("       <h1>Parámetros get de la url</h1>");
            if(Saludo != null && Nombre != null){
                out.println("          <h2>El saludo enviado es: " + Saludo + " " + Nombre + " </h2>");
            } else if (Saludo != null) {
                out.println("          <h2>El saludo enviado es: " + Saludo + " </h2>");
            } else if (Nombre != null) {
                out.println("          <h2>Hola, mi nombre es: " + Nombre + " </h2>");
            } else {
                out.println("          <h2>No se han proporcionado los parámetros de saludo ni nombre</h2>");
            }
            try {
                int Código = Integer.parseInt(req.getParameter("código"));
                out.println("           <h3>El código enviado es: " + Código + " </h3>");
            } catch (NumberFormatException e){
                out.println("           <h3>El código no se ha enviado, es null</h3>");
            }
            out.println("    </body>");
            out.println("</html>");           //Se cierra porque se abrió

        out.close();    //No es tan necesario cerrar el recurso, sólo por buenas prácticas
    }
}