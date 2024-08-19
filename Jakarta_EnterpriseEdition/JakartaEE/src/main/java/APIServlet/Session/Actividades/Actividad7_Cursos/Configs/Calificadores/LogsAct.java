package APIServlet.Session.Actividades.Actividad7_Cursos.Configs.Calificadores;

import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, CONSTRUCTOR, PARAMETER})
public @interface LogsAct {
    //Atributos de LogsAct
    //Constructores de LogsAct
    //Asignadores de atributos de LogsAct (setter)
    //Lectores de atributos de LogsAct (getter)
    //Métodos de LogsAct
}
