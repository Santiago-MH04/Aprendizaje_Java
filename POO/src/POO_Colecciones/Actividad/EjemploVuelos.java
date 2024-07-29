package POO_Colecciones.Actividad;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EjemploVuelos {
    public static void main(String[] args) {
            //Leer archivo
        OperadorAéreo VuelosHoy = new OperadorAéreo();
        VuelosHoy.LeerArchivo("C:\\Users\\Santiago\\Documents\\ArchivosJava\\CursoJava\\POO\\src\\POO_Colecciones\\Actividad\\Recursos\\Vuelos_CSV.csv");


        /*String FechaPrueba = "29 ago 2021 05:39h";
        System.out.println((StringtoFecha(FechaPrueba)));*/

    }
    /*public static String Fecha(){
        LocalDate data = LocalDate.now();
        //DateTimeFormatter forma = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM yyyy");
        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm'h'");
        String Fecha = forma.format(data);
        return Fecha.toLowerCase();
    }*/

    /*public static LocalDateTime FHLlegada(String categoría){
        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm'h'");
        LocalDateTime FechaPruebaLDT = LocalDateTime.parse(categoría, forma);
        return FechaPruebaLDT;
    }*/

    /*public static LocalDateTime StringtoFecha(String FechaPrueba){
        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm'h'");
        LocalDateTime FechaHoraLDT = LocalDateTime.parse(FechaPrueba.toLowerCase(), forma);
        return FechaHoraLDT;
    }*/
}
