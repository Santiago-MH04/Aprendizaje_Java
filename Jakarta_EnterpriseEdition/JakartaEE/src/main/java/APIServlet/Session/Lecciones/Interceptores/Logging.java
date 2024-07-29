package APIServlet.Session.Lecciones.Interceptores;

import jakarta.interceptor.InterceptorBinding;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@InterceptorBinding //Va a enlazarse a una clase o método que usa componentes CDI para controlar su ejecución
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, METHOD})
public @interface Logging {
    //Atributos de Logging
    //Constructores de Logging
    //Asignadores de atributos de Logging (setter)
    //Lectores de atributos de Logging (getter)
    //Métodos de Logging
}
