package API_Local_Date_Time.Lecciones;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class EjemploDuration2 {
    public static void main(String[] args) {
            //Comparar tiempo transcurrido entre eventos en dos fechas (con estándar en h)
        Instant I1 = Instant.now();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            Instant I2 = Instant.now();

            //Para comparar el tiempo transcurrido entre ambos instantes
        Duration t_Transcurrido = Duration.between(I1, I2);
        System.out.println("Han transcurrido: " + t_Transcurrido.toSeconds() + "s cumplidos");  //El método toSecondsPart()
                                                                                                // también extrae la parte decimal
    }
}
