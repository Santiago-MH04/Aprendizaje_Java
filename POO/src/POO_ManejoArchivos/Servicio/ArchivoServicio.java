package POO_ManejoArchivos.Servicio;

import java.io.*;
import java.util.Scanner;

public class ArchivoServicio {
    //Atributos de ArchivoServicio
    //Constructores de ArchivoServicio
    //Asignadores de atributos de ArchivoServicio (setter)
    //Lectores de atributos de ArchivoServicio (getter)

        //Métodos de ArchivoServicio
    public void CrearArchivo(String Ruta){
        File Archivo = new File(Ruta);      //Crea un archivo con la extensión indicada en la ruta correspondiente
        try(BufferedWriter Buffer = new BufferedWriter(new FileWriter(Archivo, true));){
            /*FileWriter Escritor = new FileWriter(Archivo, true);*/            //Append se declara como true para poder sobreescribir
            // contenido en los archivos, una vez creados

            /*BufferedWriter Buffer = new BufferedWriter(new FileWriter(Archivo, true));*/  //Esta instanciación va dentro de los
            // paréntesis del try catch
            Buffer.append("Hola mundo, ya estamos aprendiendo a crear archivos con Java")
                    .append(".\n¿Cómo vamos?");
            //Buffer.close();                                           //Con la instancia en el paréntesis del try
            // nos evitamos tener que declarar el close
            System.out.println("Archivo creado con éxito");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void CrearArchivo2(String Ruta){
        File Archivo = new File(Ruta);      //Crea un archivo con la extensión indicada en la ruta correspondiente
        try(PrintWriter Buffer = new PrintWriter(new FileWriter(Archivo, true));){
            //FileWriter Escritor = new FileWriter(Archivo, true);             //Append se declara como true para poder sobreescribir
            // contenido en los archivos, una vez creados

            //FileWriter Buffer = new FileWriter(new FileWriter(Archivo, true)); //Esta instanciación va dentro de los
            // paréntesis del try catch
            Buffer.println("Hola mundo, ya estamos aprendiendo a crear archivos con Java.");
            Buffer.printf("¿Cómo vamos, %s?", "amigos");
            //Buffer.close();                                               //Con la instancia en el paréntesis del try
            // nos evitamos tener que declarar el close
            System.out.println("Archivo creado con éxito");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String LeerArchivo(String Ruta){
        StringBuilder sb = new StringBuilder();
        File Archivo = new File(Ruta);              //Crea un archivo con la extensión indicada en la ruta correspondiente
        try (BufferedReader Reader = new BufferedReader(new FileReader(Archivo));){
            /*BufferedReader Reader = new BufferedReader(new FileReader(Archivo));*/
            String Línea;
            while((Línea = Reader.readLine()) != null){
                sb.append(Línea).append("\n");
            }
            /*Reader.close();*/                         //Como buena práctica, se recomienda siempre cerrar el recurso,
            // siempre y cuando no se usen los paréntesis en el try
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public String LeerArchivo2(String Ruta){
        StringBuilder sb = new StringBuilder();
        File Archivo = new File(Ruta);              //Crea un archivo con la extensión indicada en la ruta correspondiente
        try (Scanner S = new Scanner(Archivo)){
            /*Scanner S = new Scanner(Archivo);*/       //O se puede instanciar directamente en el try
            S.useDelimiter("\n");
            while(S.hasNext()){
                sb.append(S.nextLine()).append("\n");
            }
            /*S.close();*/                              //Como buena práctica, se recomienda siempre cerrar el recurso,
            // siempre y cuando no se usen los paréntesis en el try
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
