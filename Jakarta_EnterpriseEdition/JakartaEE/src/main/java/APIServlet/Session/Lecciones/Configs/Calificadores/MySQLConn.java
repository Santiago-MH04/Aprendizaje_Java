package APIServlet.Session.Lecciones.Configs.Calificadores;

import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Qualifier  //Aquí se decide cuál es la implementación por defecto, ahorrándonos el trabajo de anotar con @Alternative en los casos que no
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, CONSTRUCTOR, METHOD, PARAMETER})   //Puede inyectarse sobre cualquier elemento dentro de las llaves
public @interface MySQLConn {
    //Atributos de MySQLConn
    //Constructores de MySQLConn
    //Asignadores de atributos de MySQLConn (setters)
    //Lectores de atributos de MySQLConn (getters)
    //Métodos de MySQLConn
}
