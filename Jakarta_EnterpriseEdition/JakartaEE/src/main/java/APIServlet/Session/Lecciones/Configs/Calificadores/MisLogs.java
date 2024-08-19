package APIServlet.Session.Lecciones.Configs.Calificadores;

import jakarta.inject.Qualifier;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, CONSTRUCTOR, METHOD, PARAMETER})
public @interface MisLogs {
    //Atributos de MisLogs
    //Constructores de MisLogs
    //Asignadores de atributos de MisLogs (setters)
    //Lectores de atributos de MisLogs (getters)
    //Métodos de MisLogs
}
