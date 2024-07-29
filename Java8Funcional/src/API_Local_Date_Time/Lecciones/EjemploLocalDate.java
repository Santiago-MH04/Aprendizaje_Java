package API_Local_Date_Time.Lecciones;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class EjemploLocalDate {
    public static void main(String[] args) {
            //Creando una fecha actual bajo el formato YYYY-MM-dd
        LocalDate FechaActual = LocalDate.now();
        System.out.println("FechaActual: " + FechaActual);
            //Día de la semana
        DayOfWeek DayWeek = FechaActual.getDayOfWeek();
        String DíaSemana = DayWeek.getDisplayName(TextStyle.FULL, new Locale("es", "CO"));
            //Día del mes
        System.out.println("día de FechaActual: " + FechaActual.getDayOfMonth());
        Month Mes = FechaActual.getMonth();                 //Por defecto, muestra dicha información en inglés
        String MesES = Mes.getDisplayName(TextStyle.FULL, new Locale("es","CO"));
        System.out.println("mes de FechaActual: " + MesES + ", o " + Mes.getValue() + "° mes del año");
        System.out.println("día de FechaActual: " + FechaActual.getDayOfMonth());
        System.out.println("día semana de FechaActual: " + DíaSemana);
        System.out.println("año de FechaActual: " + FechaActual.getYear());

            //Creando una fecha dada
                //Sin enumeradores
        LocalDate FechaDada = LocalDate.of(2023,03, 23);
        System.out.println("FechaDada: " + FechaDada);
                //Con enumeradores
        LocalDate FechaDada2 = LocalDate.of(2023, Month.MAY, 29);
        System.out.println("FechaDada2: " + FechaDada2);
                //A partir de un String
        LocalDate FechaDada3 = LocalDate.parse("2021-09-15");   //Usando el formato YYYY-MM-dd
        System.out.println("FechaDada3: " + FechaDada3);
                //Crear el día de mañana
        LocalDate FechaSiguiente = LocalDate.now().plusDays(1);
        System.out.println("FechaSiguiente: " + FechaSiguiente);
                //Crear el mismo día, restando meses
        LocalDate FechaAnterior = LocalDate.now().minus(4, ChronoUnit.MONTHS);
        System.out.println("FechaAnterior: " + FechaAnterior);
                //Obtener un día de la semana
        DayOfWeek DíaEquis = LocalDate.of(2023,03, 23).getDayOfWeek();
        System.out.println("DíaEquis: " + DíaEquis);
                //Obtener un día del mes
        int DíaYe = LocalDate.of(2023,9, 17).getDayOfMonth();    //Aquí las categorías sí
                                                                                        // pueden manejar una sola cifra
        System.out.println("DíaYe: " + DíaYe);
            //¿Será bisiesto?
        boolean DizqueBisiesto = LocalDate.of(2023,03, 23).isLeapYear();
        System.out.println("DizqueBisiesto: " + DizqueBisiesto);
            //Comparar dos días según su cronología
        boolean FueAntesODespués = LocalDate.now().isBefore(LocalDate.parse("2021-12-09"));
        System.out.println("¿Fue antes o después? " + (FueAntesODespués? "antes" : "después"));
    }

}
