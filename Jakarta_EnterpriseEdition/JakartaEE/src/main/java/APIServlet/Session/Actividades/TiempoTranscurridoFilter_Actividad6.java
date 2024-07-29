package APIServlet.Session.Actividades;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@WebFilter("/*")
public class TiempoTranscurridoFilter_Actividad6 implements Filter {
    //Atributos de TiempoTranscurridoFilter_Actividad6
    //Constructores de TiempoTranscurridoFilter_Actividad6
    //Asignadores de atributos de TiempoTranscurridoFilter_Actividad6 (setter)
    //Lectores de atributos de TiempoTranscurridoFilter_Actividad6 (getter)
        //Métodos de TiempoTranscurridoFilter_Actividad6
            //Tener en cuenta que se ve en el archivo log del día de ejecución
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //Este Filter se comporta más como un Listener, que otra cosa
        try {   //Así se ejecuta y se cierra de manera automática el proceso
                //Obtener las tiempos
            LocalDateTime t1 = LocalDateTime.now();
                //Calcular la diferencia horaria simulando un proceso
            TimeUnit.MILLISECONDS.sleep(450);
            LocalDateTime t2 = LocalDateTime.now();
            Duration Dt = Duration.between(t1, t2);

                //Obtener la sesión
            ServletContext AlLog = servletRequest.getServletContext();
                //Filtrar la operación
            filterChain.doFilter(servletRequest, servletResponse);
                //Publicarlo en el log (Tomcat/logs/log del día de la ejecución) De aquí que se comporte más como un Listener que un Filter
            AlLog.log(String.format("La duración de este proceso ha sido de %d ms", Dt.toMillis()));   //La expresión regular debe sostener el String.format(Mensaje, Variable)
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
