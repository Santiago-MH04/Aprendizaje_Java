package APIServlet.Session.Lecciones.Configs.Calificadores;

import jakarta.inject.Qualifier;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Qualifier  //Aquí se decide cuál es la implementación por defecto, ahorrándonos el trabajo de anotar con @Alternative en los casos que no
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, CONSTRUCTOR, METHOD, PARAMETER})   //Puede actuar sobre cualquier elemento en las llaves
public @interface MySQLConn {   //Para que en lugar del @Named de la conexión, se vea un tris más elegante
    //Atributos de MySQLConn
    //Constructores de MySQLConn
    //Asignadores de atributos de MySQLConn (setter)
    //Lectores de atributos de MySQLConn (getter)
    //Métodos de MySQLConn
}
