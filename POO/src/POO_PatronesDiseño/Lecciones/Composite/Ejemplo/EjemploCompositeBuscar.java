package POO_PatronesDiseño.Lecciones.Composite.Ejemplo;

import POO_PatronesDiseño.Lecciones.Composite.Archivo;
import POO_PatronesDiseño.Lecciones.Composite.Directorio;

public class EjemploCompositeBuscar {
    public static void main(String[] args) {

        Directorio Doc = new Directorio("Documentos");
        Directorio Java = new Directorio("Java");
        Directorio Stream = new Directorio("API Stream");

        Java.addComponente(new Archivo("Patrón-Composite.docx"));      //Se le agregan objetos de clases concretas. Cuidadongos ahí con el error
        Stream.addComponente(new Archivo("Stream-Map.docx"));      //El error es que se agregan elementos concretos, no abstractos
        Java.addComponente(Stream);

        Doc.addComponente(new Archivo("CV_1035438200.pdf"));
        Doc.addComponente(new Archivo("logo.eps"));
        Doc.addComponente(Java);

        //System.out.println(Doc.Mostrar(0));

        //Buscando ando
        boolean Hallado = Doc.Buscar("Patrón-Composite.docx");
        System.out.println("¿\"Patrón-Composite.docx\" se encuentra en el directorio?: " +
                (Hallado? ("sí, se encuentra en " + Doc.getNombre()) : ("no se encuentra en " + Doc.getNombre())));

        Hallado = Doc.Buscar("API Stream");
        System.out.println("¿\"API Stream\" se encuentra en el directorio?: " +
                (Hallado? ("sí, se encuentra en " + Doc.getNombre()) : ("no se encuentra en " + Doc.getNombre())));
    }
}
