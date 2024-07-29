package MockitoApp;

import MockitoApp.Models.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {
        //Atributos de Datos
    public static final List<Examen> EXÁMENES = Arrays.asList(new Examen(5L, "matemáticas"),
            new Examen(6L, "lengua castellana"),
            new Examen(7L, "Historia"));

    public static final List<String> PREGUNTAS = Arrays.asList("aritmética", "geometría", "cálculo");

    public static final Examen EXAMEN = new Examen(null, "Física");

    //Constructores de Datos
    //Asignadores de atributos de Datos (setter)
    //Lectores de atributos de Datos (getter)
    //Métodos de Datos
}
