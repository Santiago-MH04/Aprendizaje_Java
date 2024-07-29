package APIServlet.Session.Lecciones.Configs.Estereotipos;

import jakarta.ejb.Stateful;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

import java.io.Serializable;
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
    /*private static final long serialVersionUID = 1L;*/ //Para arreglar el error de serialización (no ha servido de nada)
    //Constructores de CarritoCompras
    //Asignadores de atributos de CarritoCompras (setter)
    //Lectores de atributos de CarritoCompras (getter)
    //Métodos de CarritoCompras
}
