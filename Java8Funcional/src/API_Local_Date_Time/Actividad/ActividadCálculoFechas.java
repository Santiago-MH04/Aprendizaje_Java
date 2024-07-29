package API_Local_Date_Time.Actividad;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ActividadCálculoFechas {
    public static void main(String[] args) {

            //Pedir la fecha que quiere comparar
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un fecha de interés con formato dd/MM/yyyy:");
        String FechaStr = sc.next() + sc.nextLine();  //Para evitar errores al registrar cada línea https://stackoverflow.com/questions/3236830/scanner-in-java-not-working

        LocalDate FechaInterés = LocalDate.parse(FechaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate FechaActual = LocalDate.now();

        System.out.println(Resumen(FechaInterés, FechaActual));
    }

    public static String Resumen(LocalDate FechaInterés, LocalDate FechaActual){
        String Resultado = null;

            //Obtener un período en particular, el método between presenta sobrecarga
        Period t_Transcurrido = Period.between(FechaInterés, FechaActual);
        //Long Años = ChronoUnit.YEARS.between(FechaInterés, FechaActual);  //Devuelve años cumplidos transcurridos
        int Años = t_Transcurrido.getYears();
        //Long Meses = ChronoUnit.MONTHS.between(FechaInterés, FechaActual);  //Devuelve meses cumplidos transcurridos
        int Meses = t_Transcurrido.getMonths();
        //Long Días = ChronoUnit.DAYS.between(FechaInterés, FechaActual);  //Devuelve días cumplidos transcurridos
        int Días = t_Transcurrido.getDays();

        String AñosT = (Años == 1)? "un año, ":(Años == 0)?"":(Math.abs(Años) + " años, ");
        String MesesT = (Meses == 1)? "un mes, ":(Meses == 0)?"":(Math.abs(Meses) + " meses, ");
        String DíasT = (Días == 1)? "y un día":(Días == 0)?"":(((Años == 0 && Meses == 0)?"":"y ") + Math.abs(Días) + " días");

        boolean Cronología = FechaInterés.isBefore(FechaActual);
        if (Cronología) {
            Resultado = "Han transcurrido " + AñosT + MesesT + DíasT + " desde que ocurrió este evento";
        } else {
            Resultado = "Aún restan " + AñosT + MesesT + DíasT + " para que ocurra este evento";
        }
        return Resultado;
    }
}
