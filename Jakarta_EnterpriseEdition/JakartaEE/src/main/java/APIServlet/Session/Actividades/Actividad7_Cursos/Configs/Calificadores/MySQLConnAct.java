package APIServlet.Session.Actividades.Actividad7_Cursos.Configs.Calificadores;

import jakarta.inject.Qualifier;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, CONSTRUCTOR, PARAMETER})
public @interface MySQLConnAct {
    //Atributos de MySQLConnAct
    //Constructores de MySQLConnAct
    //Asignadores de atributos de MySQLConnAct (setter)
    //Lectores de atributos de MySQLConnAct (getter)
    //Métodos de MySQLConnAct
}
