package API_Local_Date_Time.Lecciones;

import java.time.LocalDate;
import java.time.Period;

public class EjemploPeriod {
    public static void main(String[] args) {
            //Comparar tiempo transcurrido entre eventos en dos fechas (con estándar en años, meses o días)
        LocalDate Queso = LocalDate.of(2017, 5, 29);
        LocalDate Colín = LocalDate.of(2021, 8, 15);
            //¿Qué tal si Colín también hubiese nacido en el mes de mayo?
        LocalDate Colín_Mentiritas = Colín.withMonth(5);        //Y así se puede cambiar cada instancia del LocalDate

        Period t_Transcurrido = Period.between(Queso, Colín);
        System.out.println("Queso y Colín se llevan: " + t_Transcurrido);
        System.out.printf("El nacimiento de Queso (%s) y el de Colín (%s) tiene una diferencia de %d años, %d meses, y %d días.",
                Queso, Colín, t_Transcurrido.getYears(), t_Transcurrido.getMonths(), t_Transcurrido.getDays());

    }
}
