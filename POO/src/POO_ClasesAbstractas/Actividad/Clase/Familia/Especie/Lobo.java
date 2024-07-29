package POO_ClasesAbstractas.Actividad.Clase.Familia.Especie;

import POO_ClasesAbstractas.Actividad.Clase.Familia.Cánido;

public class Lobo extends Cánido {
        //Atributos de Lobo
    private int NumCamada;
    private String Subespecie;

        //Constructores de Lobo
    public Lobo(String nombreCientífico, String hábitat, float altura, float longitud, float peso,
                String color, float tamañoColmillos,
                int numCamada, String subespecie) {
        super(nombreCientífico, hábitat, altura, longitud, peso, color, tamañoColmillos);
        this.NumCamada = numCamada;
        this.Subespecie = subespecie;
    }

        //Asignadores de atributos de Lobo (setter)
        //Lectores de atributos de Lobo (getter)
    public int getNumCamada() {
        return this.NumCamada;
    }
        public String getSubespecie() {
            return this.Subespecie;
        }

        //Métodos de Lobo
    @Override
    public String Comer() {
        return "El " + this.getNombreCientífico() + " " + this.getSubespecie() + " acecha a su presa, mimetizándose gracias a su "
                + this.getColor() + " y corre en relevos, agotando rápidamente a su presa.";
    }
    @Override
    public String Correr() {
        return "El " + this.getNombreCientífico() + " " + this.getSubespecie() + " se desplaza en filas, donde el líder de su manada de hasta " +
                this.getNumCamada() + " miembros es liderada por los más ancianos, y cerradas por el macho alfa.";
    }
    @Override
    public String Dormir() {
        return "El " + this.getNombreCientífico() + " " + this.getSubespecie() + " puede dormir por períodos de 15h al día";
    }
    @Override
    public String Comunicarse() {
        return "El " + this.getNombreCientífico() + " " + this.getSubespecie() + " se comunica con aullidos, " +
                "tanto para amenazar como para defenderse.";
    }
    @Override
    public String resumen() {
        return super.resumen();
    }
}
