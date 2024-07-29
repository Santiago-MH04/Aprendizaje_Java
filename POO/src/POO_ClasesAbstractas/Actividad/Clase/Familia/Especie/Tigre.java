package POO_ClasesAbstractas.Actividad.Clase.Familia.Especie;

import POO_ClasesAbstractas.Actividad.Clase.Familia.Félido;

public class Tigre extends Félido {
        //Atributos de Tigre
    private String Subespecie;

        //Constructores de Tigre
    public Tigre(String nombreCientífico, String hábitat, float altura, float longitud, float peso,
                 float tamañoGarras, int velocidad,
                 String subespecie) {
        super(nombreCientífico, hábitat, altura, longitud, peso, tamañoGarras, velocidad);
        this.Subespecie = subespecie;
    }

        //Asignadores de atributos de Tigre (setter)

        //Lectores de atributos de Tigre (getter)
    public String getSubespecie() {
        return this.Subespecie;
    }

        //Métodos de Tigre
    @Override
    public String Comer() {
        return "El " + this.getNombreCientífico() + " " + this.getSubespecie() +
                " siempre acecha sus presas, en las que se encuentran desde gacelas, hasta osos," +
                " gracias a sus garras de " + this.getTamañoGarras() + " cm";
    }
    @Override
    public String Correr() {
        return "El " + this.getNombreCientífico() + " " + this.getSubespecie() +
                " es capaz de correr hasta " + this.getVelocidad() + " km/h";
    }
    @Override
    public String Dormir() {
        return "El " + this.getNombreCientífico() + " " + this.getSubespecie() +
                " duerme hasta 16h al día.";
    }
    @Override
    public String Comunicarse() {
        return "El " + this.getNombreCientífico() + " " + this.getSubespecie()  +
                " ruge sólo cuando se siente amenazado.";
    }
    @Override
    public String resumen() {
        return super.resumen();
    }
}
