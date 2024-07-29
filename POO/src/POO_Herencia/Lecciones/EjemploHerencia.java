package POO_Herencia.Lecciones;

import POO_Herencia.Lecciones.Bambalinas.*;

public class EjemploHerencia {
    public static void main(String[] args) {
        System.out.println("---------------------Creando la instancia de la clase Alumno---------------------");
        Alumno estudiante = new Alumno();
        //Persona estudiante = new Alumno();
            estudiante.setNombre("Colín");
            estudiante.setApellido("Barrigoncín");
            estudiante.setInstitución("Colegio Tapitas");
            //((Alumno)estudiante).setInstitución("Colegio Tapitas"); //Se fuerza estudiante a tipo Alumno, pues, de momento, es
                                                                      //sólo tipo Persona
            estudiante.setNotaLengua(3.8);
            estudiante.setNotaHistoria(4.3);
            estudiante.setNotaMatemáticas(4.0);

        System.out.println("---------------------Creando la instancia de la clase AlumnoInternacional---------------------");
        AlumnoInternacional estudianteIntercambio = new AlumnoInternacional();
            estudianteIntercambio.setNombre("Olaf");
            estudianteIntercambio.setApellido("Olafson");
            estudianteIntercambio.setPaís("Noruega");
            estudianteIntercambio.setEdad(23);
            estudianteIntercambio.setInstitución("Colegio Tapitas");
            estudianteIntercambio.setNotaIdiomas(3.5);
            estudianteIntercambio.setNotaHistoria(3.8);
            estudianteIntercambio.setNotaMatemáticas(4.2);

            //Imprimir la jerarquía de clases de AlumnoInternacional
        //Class clase = AlumnoInternacional.getClass();
        Class clase = AlumnoInternacional.class;
        while(clase.getSuperclass() != null){
            String clasePadre = clase.getSuperclass().getName();
            String claseHija = clase.getName();
            System.out.println(claseHija + " es una clase que hereda de " + clasePadre);
            clase = clase.getSuperclass();
        }

        System.out.println("---------------------Creando la instancia de la clase Profesor---------------------");
        Profesor docente = new Profesor();
            docente.setNombre("Floricienta");
            /*docente.nombre = "Floricienta";*/ //Si la clase con el main y Persona estuviesen en el mismo paquete, se puede
                                                //asignar un nombre sin recurrir al método setter, sino invocando el
                                                //atributo nombre como tal
            docente.setApellido("Regañoncienta");
            docente.setAsignatura("Matemáticas");

        System.out.println("------------------------------------------");
        System.out.println(estudiante.getNombre() + " " + estudiante.getApellido() + " " + ((Alumno)estudiante).getInstitución());
        System.out.println(estudianteIntercambio.getNombre() + " " + estudianteIntercambio.getApellido() +
                " es un estudiante de intercambio de " + estudianteIntercambio.getPaís() +
                " que se encuentra estudiando en " +estudianteIntercambio.getInstitución());
        System.out.println("Profesor de " + docente.getAsignatura() + ": " + docente.getNombre() + " " + docente.getApellido());
    }
}
