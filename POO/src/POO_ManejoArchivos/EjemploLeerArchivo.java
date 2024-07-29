package POO_ManejoArchivos;

import POO_ManejoArchivos.Servicio.ArchivoServicio;

public class EjemploLeerArchivo {
    public static void main(String[] args) {

        ArchivoServicio Archivo = new ArchivoServicio();
        String RutaArchivo = "C:\\Users\\Santiago\\Documents\\ArchivosJava\\CursoJava\\POO\\Archivo\\Java.txt";
        //System.out.println(Archivo.LeerArchivo(RutaArchivo));
        System.out.println(Archivo.LeerArchivo2(RutaArchivo));
    }
}
