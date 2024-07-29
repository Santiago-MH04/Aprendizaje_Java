package APIServlet.Session.Actividades.Actividad7_Cursos.Interceptores;

import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, METHOD})
public @interface LoggingAct {
    //Atributos de LoggingAct
    //Constructores de LoggingAct
    //Asignadores de atributos de LoggingAct (setter)
    //Lectores de atributos de LoggingAct (getter)
    //Métodos de LoggingAct
}
