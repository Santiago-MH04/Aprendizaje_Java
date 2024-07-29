package POO_Paquetes.Jardín;

import POO_Paquetes.Hogar.*;
import static POO_Paquetes.Hogar.Persona.*;


public class EjemploPaquetes {
    public static void main(String[] args) {
            //Declaración de la clase Persona en el subpaquete Hogar
                //Explícita
        POO_Paquetes.Hogar.Persona p = new POO_Paquetes.Hogar.Persona();
            p.setNombre("Santiago");
            p.setColorPelo(ColorPelo.NEGRO);
            //Implícita (importando la clase). Dado que se usó el * en el importador, esto automáticamente invoca
            // a todas las clases del subpaquete Hogar
        Persona q = new Persona();
            q.setNombre("Manuelas");
        //Gato g = new Gato(); El gato (por ser la clase gato por defecto) no puede salir de la casa
        Perro pe = new Perro();
            pe.nombre = "Milonga";
            pe.raza = "Bulldog";

        System.out.println(p.getNombre());
        System.out.println(q.getNombre());

        String jugando = pe.jugar(p);
        System.out.println(p.getNombre() + ": " + jugando);
        String saludo = saludar(); //Se ha invocado sólo con el nombre del método, dado que el método está importado desde el comienzo
        System.out.println("saludo: " + saludo);

        String GéneroMujer = GÉNERO_FEMENINO;
        String GéneroHombre = GÉNERO_MASCULINO;
    }
}
