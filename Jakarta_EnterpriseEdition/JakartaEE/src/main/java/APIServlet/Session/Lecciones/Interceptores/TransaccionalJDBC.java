package APIServlet.Session.Lecciones.Interceptores;

import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@InterceptorBinding //Va a enlazarse a una clase o método que usa componentes CDI para controlar su ejecución
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, METHOD})
public @interface TransaccionalJDBC {
    //Atributos de TransaccionalJDBC
    //Constructores de TransaccionalJDBC
    //Asignadores de atributos de TransaccionalJDBC (setter)
    //Lectores de atributos de TransaccionalJDBC (getter)
    //Métodos de TransaccionalJDBC
}
