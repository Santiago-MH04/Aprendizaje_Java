package APIServlet.Session.Lecciones.Configs.Estereotipos;

import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.*;

@SessionScoped
@Named
@Stereotype //Agrupa varias anotaciones (mostradas arriba) bajo esta etiqueta
@Retention(RUNTIME) //Va a aplicar durante tiempo de ejecución
@Target(ElementType.TYPE)   //Se aplica sobre las clases mencionadas en su argumento /*@Stateful(passivationCapable=true)*/
public @interface CarritoCompras {
    //Atributos de CarritoCompras
    //Constructores de CarritoCompras
    //Asignadores de atributos de CarritoCompras (setters)
    //Lectores de atributos de CarritoCompras (getters)
    //Métodos de CarritoCompras
}
