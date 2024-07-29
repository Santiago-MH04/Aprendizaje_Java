package API_Local_Date_Time.Lecciones;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class EjemploLocalTime {
    public static void main(String[] args) {
            //Crear la hora actual
        LocalTime HoraActual = LocalTime.now();     //La precisión llega hasta los ns
        System.out.println("HoraActual = " + HoraActual);
        System.out.println("Hora del día: " + HoraActual.getHour());    //La hora se obtiene en formato 24h
        System.out.println("minuto de la hora: " + HoraActual.getMinute());
        System.out.println("segundos del minuto: " + HoraActual.getSecond());

            //Crear una hora dada
        LocalTime h6_30 = LocalTime.of(06, 30);
        System.out.println("h6_30: " + h6_30 + "h");
        LocalTime SeisHTreinta = LocalTime.parse("06:30");      //En el formato, pueden agregarse hasta precisión de ns
        System.out.println("SeisHTreinta: " + SeisHTreinta + "h");

            //Sumar una hora
        LocalTime SieteHTreinta = h6_30.plus(1,  ChronoUnit.HOURS);
        System.out.println("SieteHTreinta: " + SieteHTreinta + "h");

            //Comparar horas
        boolean SeráAntes = SieteHTreinta.isBefore(SeisHTreinta);
        System.out.println("¿Es antes o después?: " + (SeráAntes? "antes" : "después"));

            //Dar formato a una hora
                //Formato 24h
        DateTimeFormatter fh24 = DateTimeFormatter.ofPattern("HH:mm:ss 'h'");     //HH -> 24h; hh -> am-pm
        String HHFormateado = HoraActual.format(fh24);
        System.out.println("HHFormateado = " + HHFormateado);
                //Formato am-pm
        DateTimeFormatter fhAP = DateTimeFormatter.ofPattern("hh:mm:ss a");     //HH -> 24h; hh -> am-pm; a -> define si am o pm
        String hhFormateado = HoraActual.format(fhAP);
        System.out.println("hhFormateado = " + hhFormateado);
            //Ajustar una hora a un formato predeterminado          //Es el mismo procedimiento, pero al contrario
        String HHFormateadoViceversa = fh24.format(HoraActual);
        System.out.println("HHFormateadoViceversa = " + HHFormateadoViceversa);

            //Horas mínima y máxima
        LocalTime HoraMin = LocalTime.MIN;
        System.out.println("HoraMin: " + HoraMin + "h");
        LocalTime HoraMax = LocalTime.MAX;
        System.out.println("HoraMax: " + HoraMax + "h");

            //Probar la inmutabilidad de las fechas
    }
}
