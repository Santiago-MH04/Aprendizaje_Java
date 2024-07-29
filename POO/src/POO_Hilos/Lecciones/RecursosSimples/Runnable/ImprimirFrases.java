package POO_Hilos.Lecciones.RecursosSimples.Runnable;

import static POO_Hilos.Lecciones.RecursosSimples.EjemploSincronizaciónThread.*;

public class ImprimirFrases implements Runnable {
        //Atributos de ImprimirFrases
    private String[] Frases;
    private Orden Sentido;

        //Constructores de ImprimirFrases
    public ImprimirFrases(String[] frases, Orden sentido) {
        this.Frases = frases;
        this.Sentido = sentido;
    }

    //Asignadores de atributos de ImprimirFrases (setter)
    //Lectores de atributos de ImprimirFrases (getter)
        //Métodos de ImprimirFrases
    @Override
    public void run() {
        if(this.Sentido == Orden.ALE){
            ImprimirFrasesMal(Frases);
        } else {
            ImprimirFrasesBien(Frases);
        }
    }
}
