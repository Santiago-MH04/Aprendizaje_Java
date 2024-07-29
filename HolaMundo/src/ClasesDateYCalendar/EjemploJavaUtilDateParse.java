package ClasesDateYCalendar;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class EjemploJavaUtilDateParse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Ingrese una fecha con el siguiente formato \"yyyy-MM-dd\"");
        try {
            Date fecha = format.parse(sc.next());
            System.out.println("fecha = " + fecha);
            System.out.println("format = " + format.format(fecha));

            Date fecha2 = new Date();
            System.out.println("fecha2 = " + fecha2);

            if (fecha.after(fecha2)){
                System.out.println("La fecha ingresada por el usuario es posterior a la fecha actual (fecha2)");
            } else if (fecha.before(fecha2)) {
                System.out.println("La fecha ingresada por el usuario es anterior a la fecha actual (fecha2)");
            } else if (fecha.equals(fecha2)) {
                System.out.println("La fecha ingresada por el usuario es la misma que la fecha actual (fecha2)");
            }

            if (fecha.compareTo(fecha2) > 0){
                System.out.println("La fecha ingresada por el usuario es posterior a la fecha actual (fecha2)");
            } else if (fecha.compareTo(fecha2) < 0){
                System.out.println("La fecha ingresada por el usuario es anterior a la fecha actual (fecha2)");
            } else if (fecha.compareTo(fecha2) == 0) {
                System.out.println("La fecha ingresada por el usuario es la misma que la fecha actual (fecha2)");
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

