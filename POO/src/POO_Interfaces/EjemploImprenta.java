package POO_Interfaces;

import POO_Interfaces.Imprenta.Modelo.*;
import static POO_Interfaces.Imprenta.Modelo.Género.NOVELA;
import static POO_Interfaces.Imprenta.Modelo.Imprimible.*;

public class EjemploImprenta {
    public static void main(String[] args) {
        Curriculum CV = new Curriculum(new Persona("Pepito", "Pérez"),
                "Ingeniero químico", "Resumen laboral");
        CV.addExperiencia("Java")
                .addExperiencia("Oracle DBA")
                .addExperiencia("Spring Framework")
                .addExperiencia("Angular")
                .addExperiencia("Desarrollador fullstack");


        Libro libro = new Libro(new Persona("Günter", "Grass"), "El tambor de hojalata", NOVELA);
        libro.addPágina(new Página("Libro Primero"))
                .addPágina(new Página("Las cuatro faldas"))
                .addPágina(new Página("Bajo la balsa"))
                .addPágina(new Página("La mariposa y la bombilla"))
                .addPágina(new Página("El álbum de fotos"));

        Informe informe = new Informe("Estudio sobre microservicios",
                new Persona("Manuelitas", "Torombolitas"),
                new Persona("Quesocolo", "Chiquitín y Torombozuelos"));

        Imprimir(CV);
        Imprimible.Imprimir(informe);
        Imprimible.Imprimir(libro);
        System.out.println(Imprimible.TEXTO_DEFECTO);
        Imprimir(new Imprimible() {
            @Override
            public String Imprimir() {
                return "Hola, ¿qué tal? Imprimiendo un objeto genérico de una clase anónima";
            }
        });
    }
}
