package POO_ClasesAbstractas.Actividad.Clase.Familia.Especie;

import POO_ClasesAbstractas.Actividad.Clase.Familia.Félido;

public class Leopardo extends Félido {
        //Atributos de Leopardo

        //Constructores de Leopardo
    public Leopardo(String nombreCientífico, String hábitat, float altura, float longitud, float peso,
                    float tamañoGarras, int velocidad) {
        super(nombreCientífico, hábitat, altura, longitud, peso, tamañoGarras, velocidad);
        this.TamañoGarras = tamañoGarras;
        this.Velocidad = velocidad;
    }

        //Asignadores de atributos de Leopardo (setter)
        //Lectores de atributos de Leopardo (getter)

        //Métodos de Leopardo
    @Override
    public String Comer() {
        return "El " + this.getNombreCientífico() + " se alimenta de todo tipo de animales. " +
                "Incluso, pueden ser más pesados que él, debido a la gran fuerza de su mordida. " +
                "Y, con sus garras de " + this.getTamañoGarras() + " cm, puede asirse a los árboles para asegurarlas.";
    }
    @Override
    public String Correr() {
        return "El " + this.getNombreCientífico() + " suele acechar a sus presas y emboscarlas. " +
                "Sin embargo, puede alcanzar velocidades de hasta " +
                this.Velocidad + " km/h";
    }
    @Override
    public String Dormir() {
        return "El " + this.getNombreCientífico() + " puede dormir en cualquier lugar de su hábitat hasta por 18h al día.";
    }
    @Override
    public String Comunicarse() {
        return "El " + this.getNombreCientífico() + " se comunica con señales químicas, y rugidos de baja intensidad.";
    }
    @Override
    public String resumen() {
        return super.resumen();
    }
}
