package ClasesDateYCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EjemploJavaUtilDate {
    public static void main(String[] args) {
        Date fecha = new Date();
        System.out.println("fecha = " + fecha);

        SimpleDateFormat ff = new SimpleDateFormat("EEEE dd 'de' MMMM, yyyy");
        String fechaStr = ff.format(fecha);
        System.out.println("fechaStr = " + fechaStr);

        long j = 0;
        for (int i = 0; i <= 10000000; i++){
            j += i;
        }
        System.out.println("j = " + j);

        Date fecha2 = new Date();
        long tiempoTotal = fecha2.getTime() - fecha.getTime();
        System.out.println("Tiempo empleado en el ciclo for [ms] = " + tiempoTotal);
        System.out.println("fechaStr = " + fechaStr);
    }
}