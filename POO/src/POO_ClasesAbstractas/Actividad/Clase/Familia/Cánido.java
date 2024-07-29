package POO_ClasesAbstractas.Actividad.Clase.Familia;

import POO_ClasesAbstractas.Actividad.Clase.Mamífero;

public abstract class Cánido extends Mamífero {
        //Atributos de Cánido
    protected String Color;
    protected float TamañoColmillos;

        //Constructores de Cánido
    public Cánido(String nombreCientífico, String color, float tamañoColmillos) {
        super(nombreCientífico);
        this.Color = color;
        this.TamañoColmillos = tamañoColmillos;
    }
    public Cánido(String nombreCientífico, String hábitat, float altura, float longitud, float peso, String color, float tamañoColmillos) {
        super(nombreCientífico, hábitat, altura, longitud, peso);
        this.Color = color;
        this.TamañoColmillos = tamañoColmillos;
    }

        //Asignadores de atributos de Cánido (setter)

        //Lectores de atributos de Cánido (getter)
    public String getColor() {
        return this.Color;
    }
    public float getTamañoColmillos() {
        return this.TamañoColmillos;
    }

        //Métodos de Cánido
}
