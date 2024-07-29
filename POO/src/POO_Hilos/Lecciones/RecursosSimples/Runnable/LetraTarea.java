package POO_Hilos.Lecciones.RecursosSimples.Runnable;

import java.util.Random;

public class LetraTarea implements Runnable{
        //Atributos de ViajeTarea
    private String Nombre;
    private final String SIN = "cuenta";
    private final String PLU = "cuentas";

        //Constructores de ViajeTarea
    public LetraTarea(String nombre) {
        this.Nombre = nombre;
    }
    //Asignadores de atributos de ViajeTarea (setter)
        //Lectores de atributos de ViajeTarea (getter)
    public String getNombre() {
        return this.Nombre;
    }

        //Métodos de ViajeTarea
    @Override
    public void run() {
        System.out.println("Se inicia el método run del hilo " + this.getNombre());
        Random equis = new Random();
        int LetEquis = 0;
        int Iteraciones = 0;
        char Ese = 0;

        while(Ese != 's'){
            try {
                LetEquis = equis.nextInt(25 + 1) + 'a';
                Ese = (char)LetEquis ;
                System.out.println(Ese);
                Thread.sleep(10);
                Iteraciones++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String Número = (Iteraciones > 1)? PLU : SIN;
        System.out.println("Se finaliza el método run del hilo " + this.getNombre() +  ", para encontrar la letra 's', luego de " + Iteraciones +  " " + Número + ".");
    }
}
