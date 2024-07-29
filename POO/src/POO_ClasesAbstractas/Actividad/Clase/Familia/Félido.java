package POO_ClasesAbstractas.Actividad.Clase.Familia;

import POO_ClasesAbstractas.Actividad.Clase.Mamífero;

public abstract class Félido extends Mamífero {
        //Atributos de Félido
    protected float TamañoGarras;
    protected int Velocidad;

        //Constructores de Félido
    public Félido(String nombreCientífico, float tamañoGarras, int velocidad) {
        super(nombreCientífico);
        this.TamañoGarras = tamañoGarras;
        this.Velocidad = velocidad;
    }
    public Félido(String nombreCientífico, String hábitat, float altura, float longitud, float peso, float tamañoGarras, int velocidad) {
        super(nombreCientífico, hábitat, altura, longitud, peso);
        this.TamañoGarras = tamañoGarras;
        this.Velocidad = velocidad;
    }
        //Asignadores de atributos de Felino (setter)

        //Lectores de atributos de Felino (getter)
    public float getTamañoGarras() {
        return TamañoGarras;
    }
    public int getVelocidad() {
        return Velocidad;
    }

        //Métodos de Felino
}
