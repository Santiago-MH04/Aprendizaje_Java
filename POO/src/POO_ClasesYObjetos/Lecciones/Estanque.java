package POO_ClasesYObjetos.Lecciones;

public class Estanque {
        //Atributos de estanque
    private int capacidad;

        //Constructores de estanque
    public Estanque() {
        this.capacidad = 40;
    }
    public Estanque(int capacidad) {
        this.capacidad = capacidad;
    }

        //Lector de capacidad
    public int getCapacidad() {
        return capacidad;
    }
}
