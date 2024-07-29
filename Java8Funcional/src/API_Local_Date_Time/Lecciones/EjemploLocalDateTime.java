package API_Local_Date_Time.Lecciones;

import java.time.LocalDateTime;
import java.time.Month;

public class EjemploLocalDateTime {
    public static void main(String[] args) {
            //Crear la fecha y hora actuales
        LocalDateTime FechaHoraActual = LocalDateTime.now();
        System.out.println("FechaHoraActual: " + FechaHoraActual);

            //Crear una fecha y hora dadas
                //A partir de unos datos brutos
        LocalDateTime FechaHoraDadas = LocalDateTime.of(2023, Month.MAY, 29, 14, 30); //Existe sobrecarga hasta nos ns
        System.out.println("FechaHoraDadas: " + FechaHoraDadas);
                //A partir de un String
        LocalDateTime FechaHoraDadas2 = LocalDateTime.parse("2023-09-15T21:25");    //En formato YYYY-MM-dd'T'HH:mm:ss:nn por defecto, para dar formato con el formatter
        //LocalDateTime FechaHoraDadasX = LocalDateTime.parse(String fecha, DateTimeFormatter formato);    //Para convertir un String a fecha
        System.out.println("FechaHoraDadas2 = " + FechaHoraDadas2);
                //Crear el día de mañana
        LocalDateTime FechaHoraDíaSiguiente = LocalDateTime.now().plusDays(1);      //Así como se suman días, también horas, minutos y segundos
        System.out.println("FechaHoraDíaSiguiente: " + FechaHoraDíaSiguiente);

    }
}
