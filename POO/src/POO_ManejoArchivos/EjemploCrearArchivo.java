package POO_ManejoArchivos;

import POO_ManejoArchivos.Servicio.ArchivoServicio;

public class EjemploCrearArchivo {
    public static void main(String[] args) {

        String RutaArchivo = "C:\\Users\\Santiago\\Documents\\ArchivosJava\\CursoJava\\POO\\Archivo\\Java.txt";

            //Crear instancia de la clase
        ArchivoServicio Service = new ArchivoServicio();
            //Service.CrearArchivo(RutaArchivo);
        Service.CrearArchivo2(RutaArchivo);

    }
}
