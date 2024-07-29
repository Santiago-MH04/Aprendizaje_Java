package APIServlet.Session.Actividades.Actividad7_Cursos.Interceptores;

import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, METHOD})
public @interface TransaccionalAct {
    //Atributos de TransaccionalAct
    //Constructores de TransaccionalAct
    //Asignadores de atributos de TransaccionalAct (setter)
    //Lectores de atributos de TransaccionalAct (getter)
    //Métodos de TransaccionalAct
}
