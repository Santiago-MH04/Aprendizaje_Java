package ClasesDateYCalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EjemploJavaUtilCalendar {
    public static void main(String[] args) {
        Calendar calendario = Calendar.getInstance();
        //calendario.set(2022,Calendar.APRIL,25, 18,45,50);
        calendario.set(Calendar.YEAR,2020);
        calendario.set(Calendar.MONTH, Calendar.APRIL);
        calendario.set(Calendar.DAY_OF_MONTH, 27);
        calendario.set(Calendar.HOUR_OF_DAY,18);
        calendario.set(Calendar.MINUTE, 30);
        calendario.set(Calendar.SECOND, 45);

        Date fecha = calendario.getTime();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss:SSS");
        String FechaConFormato = formato.format(fecha);
        System.out.println("FechaConFormato = " + FechaConFormato);


        System.out.println("fecha sin formato = " + fecha);
        System.out.println("FechaConFormato = " + FechaConFormato);
        //System.out.println("calendario = " + calendario);
    }
}
