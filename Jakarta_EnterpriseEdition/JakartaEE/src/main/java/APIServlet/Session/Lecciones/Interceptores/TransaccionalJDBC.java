package APIServlet.Session.Lecciones.Interceptores;

import jakarta.interceptor.InterceptorBinding;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@InterceptorBinding //Va a enlazarse a una clase o método que usa componentes CDI para controlar su ejecución
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, METHOD})
public @interface TransaccionalJDBC {
    //Atributos de TransaccionalJDBC
    //Constructores de TransaccionalJDBC
    //Asignadores de atributos de TransaccionalJDBC (setters)
    //Lectores de atributos de TransaccionalJDBC (getters)
    //Métodos de TransaccionalJDBC
}
