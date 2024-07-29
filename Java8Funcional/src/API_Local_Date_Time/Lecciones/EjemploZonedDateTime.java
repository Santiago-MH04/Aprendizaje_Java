package API_Local_Date_Time.Lecciones;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EjemploZonedDateTime {
    public static void main(String[] args) {
            //Partiendo de una fecha y hora locales, y extendiendo a una zona horaria determinada
                //El parámetro UTC varía para un país que adopta horarios de invierno, y verano *Para tener en cuenta*
        LocalDateTime FechaLocal = LocalDateTime.now();
        //LocalDateTime FechaLocal = LocalDateTime.parse(String fecha, DateTimeFormatter formato);   //para crear fechas con un formato
                                                                                                     // no predeterminado

        ZoneId Zona_BuenosAires = ZoneId.of("UTC-3");               //"America/Buenos_Aires" "UTC-3"
        ZonedDateTime HoraBA = ZonedDateTime.of(FechaLocal,Zona_BuenosAires);
        //ZonedDateTime HoraBA2 = FechaLocal.atZone(Zona_BuenosAires);    //Otras forma de crear las mismas fechas y horas de otra zona horaria
        //ZonedDateTime HoraBA3 = FechaLocal.atZone(ZoneOffset.of("-03:00"));
        //ZoneOffset HoraBA_UTC = ZoneOffset.of("-03:00");             //Se le ingresa la magnitud que acompaña al UTC
        System.out.println("Hora de partida en Buenos Aires: " + HoraBA);

            //Comparando una fecha y hora de dos zonas horarias distintas
        ZoneId Zona_Madrid = ZoneId.of("Europe/Madrid");            //"Europe/Madrid" "UTC+1"
        //ZoneOffset HoraMadrid_UTC = ZoneOffset.of("+01:00");             //Se le ingresa la magnitud que acompaña al UTC
        ZonedDateTime HoraMadrid = HoraBA.withZoneSameInstant(Zona_Madrid).plus(13, ChronoUnit.HOURS);  //.plusHours(13)
        //ZonedDateTime HoraMadrid = HoraBA.withZoneSameInstant(HoraMadrid_UTC).plus(13, ChronoUnit.HOURS);  //.plusHours(13)
        System.out.println("Hora de llegada en Madrid luego de un vuelo de 12h: " + HoraMadrid);

            //Dándoles un formato más amable con el usuario "dd MMMM 'de' yyyy HH:mm'h'"
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd MMMM 'de' yyyy HH:mm'h'");
        System.out.println("Fecha y hora de partida en Buenos Aires: " + f.format(HoraBA));    //Pareciera sobrecarga, pero son
                                                                                               // dos métodos diferentes, que pertenecen a
                                                                                               // dos clases distintas
        System.out.println("Fecha y hora de llegada en Madrid: " + HoraMadrid.format(f));

            //Para saber cuáles son las zonas horarias que utiliza Java
        System.out.println("\nLas zonas horarias disponibles son: ");
        ZoneId.getAvailableZoneIds().forEach(System.out::println);
    }
}
