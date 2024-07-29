package POO_ClasesAbstractas.Actividad.Clase.Familia.Especie;

import POO_ClasesAbstractas.Actividad.Clase.Familia.Cánido;

public class Perro extends Cánido {
        //Atributos de Perro
    private int FuerzaMordida;

        //Constructores de Perro
    public Perro(String nombreCientífico, String hábitat, float altura, float longitud, float peso,
                 String color, float tamañoColmillos,
                 int fuerzaMordida) {
        super(nombreCientífico, hábitat, altura, longitud, peso, color, tamañoColmillos);
        this.FuerzaMordida = fuerzaMordida;
    }

        //Asignadores de atributos de Perro (setter)
        //Lectores de atributos de Perro (getter)
    public int getFuerzaMordida() {
        return this.FuerzaMordida;
    }

        //Métodos de Perro
    @Override
    public String Comer() {
        return "El " + this.getNombreCientífico() + " se alimenta en manadas. " +
                "Son de los animales más exitosos, ya que, viviendo en manada, son capaces de usar sus colmillos de " +
                this.getTamañoColmillos() + " y de imprimir mordidas de " + this.getFuerzaMordida() + " psi.";
    }
    @Override
    public String Correr() {
        return "El " + this.getNombreCientífico() + " acecha a su presa, mimetizándose gracias a su "
                + this.getColor() + " y corre en relevos, agotando rápidamente a su presa.";
    }
    @Override
    public String Dormir() {
        return "El " + this.getNombreCientífico() + " duerme hasta 14h al día, bajo la sombra de los árboles.";
    }
    @Override
    public String Comunicarse() {
        return "El " + this.getNombreCientífico() + " usa sus potentes ladridos, " +
                "tanto para comunicarse, como para transmitir amenazas.";
    }
    @Override
    public String resumen() {
        return super.resumen();
    }
}
