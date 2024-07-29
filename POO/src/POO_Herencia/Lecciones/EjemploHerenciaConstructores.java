package POO_Herencia.Lecciones;

import POO_Herencia.Lecciones.Bambalinas.*;

public class EjemploHerenciaConstructores {
    public static void main(String[] args) {
        System.out.println("---------------------Creando la instancia de la clase Alumno---------------------");
        Alumno estudiante = new Alumno("Colín", "Barrigoncín", 2, "Colegio Tapitas");
        //Persona estudiante = new Alumno();
        //((Alumno)estudiante).setInstitución("Colegio Tapitas"); //Se fuerza estudiante a tipo Alumno, pues, de momento, es
                                                                  //sólo tipo Persona
            estudiante.setNotaLengua(3.8);
            estudiante.setNotaHistoria(4.3);
            estudiante.setNotaMatemáticas(4.0);
            estudiante.setCorreo("colinbarrigoncin1508@colegiotapitas.edu");

        System.out.println("---------------------Creando la instancia de la clase AlumnoInternacional---------------------");
        AlumnoInternacional estudianteIntercambio = new AlumnoInternacional("Olaf","Olafson", "Noruega");
            estudianteIntercambio.setEdad(4);
            estudianteIntercambio.setInstitución("Colegio Tapitas");
            estudianteIntercambio.setNotaIdiomas(3.5);
            estudianteIntercambio.setNotaHistoria(3.8);
            estudianteIntercambio.setNotaMatemáticas(4.2);
            estudianteIntercambio.setNotaLengua(4.2);
            estudianteIntercambio.setCorreo("olafolafson2303@colegiotapitas.edu");

        System.out.println("---------------------Creando la instancia de la clase Profesor---------------------");
        Profesor docente = new Profesor("Floricienta", "Regañoncienta", "Matemáticas");
            docente.setEdad(40);
            /*docente.nombre = "Floricienta";*/ //Si la clase con el main y Persona estuviesen en el mismo paquete, se puede
                                                //asignar un nombre sin recurrir al método setter, sino invocando el
                                                //atributo nombre como tal
            docente.setCorreo("floricientaregañoncienta2008@colegiotapitas.edu");

        System.out.println();
        imprimir(estudiante);
        imprimir(estudianteIntercambio);
        imprimir(docente);
    }

    public static void imprimir(Persona persona){
        System.out.println("Detalles en común del tipo Persona");
        System.out.println("Nombre: " + persona.getNombre() + "." +
                "\tApellido: " + persona.getApellido() + "." +
                "\tEdad: " + persona.getEdad() + "." +
                "\tCorreo: " + persona.getCorreo() + ".");

        if(persona instanceof Profesor){
            System.out.println("Detalles de una persona del tipo Profesor");
            System.out.println("Asignatura: " + ((Profesor)persona).getAsignatura());
        }

        if(persona instanceof Alumno){
            System.out.println("Detalles de una persona del tipo Alumno");
            System.out.println("Institución: " + ((Alumno)persona).getInstitución() +
                    "\nNota matemáticas: " + ((Alumno)persona).getNotaMatemáticas() +
                    "\nNota historia: " + ((Alumno)persona).getNotaHistoria() +
                    "\nNota lengua: " + ((Alumno)persona).getNotaLengua());
            if(persona instanceof AlumnoInternacional){
                System.out.println("Detalles de una persona del tipo AlumnoInternacional");
                System.out.println("País: " + ((AlumnoInternacional)persona).getPaís() +
                        "\nNota idiomas: " + ((AlumnoInternacional)persona).getNotaIdiomas());
            }
            System.out.println("----Sobreescritura del cálculo del promedio----");
            System.out.println("Promedio: " + ((Alumno)persona).calcularPromedio());
            System.out.println("----Sobreescritura del cálculo del promedio----");
        }
        System.out.println("----Sobreescritura del método saludar----" +
                "\n" + persona.saludar());
        System.out.println();
    }
}
