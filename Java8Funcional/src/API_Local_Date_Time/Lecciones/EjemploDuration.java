package API_Local_Date_Time.Lecciones;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class EjemploDuration {
    public static void main(String[] args) {
            //Comparar tiempo transcurrido entre eventos en dos fechas (con estándar en horas)
        LocalDateTime Fecha1 = LocalDateTime.now();
        LocalDateTime Fecha2 = LocalDateTime.now().plus(1, ChronoUnit.HOURS)    //O con el método plusHours(1)
                .plusMinutes(20);

        Duration Lapso = Duration.between(Fecha1, Fecha2);
        System.out.println("Lapso [h]: " + Lapso.plus(0,ChronoUnit.HOURS)); //Al duration también se
                                                                                        // le puede añadir tiempo
        System.out.println("Lapso [s]: " + Lapso.getSeconds());
        System.out.println("Lapso [h cumplidas]: " + Lapso.toHours());  //Se pueden obtener los días, horas, minutos, segundos, ms o ns
                                                                        // ya cumplidos con el método to
    }
}
