package POO_ClasesAbstractas.Actividad.Clase.Familia.Especie;

import POO_ClasesAbstractas.Actividad.Clase.Familia.Félido;
public class León extends Félido {
        //Atributos de León
    private int NumManada;
    private float PotenciaRugido;

        //Constructores de León
    public León(String nombreCientífico, String hábitat, float altura, float longitud, float peso,
                float tamañoGarras, int velocidad,
                int numManada, float potenciaRugido) {
        super(nombreCientífico, hábitat, altura, longitud, peso, tamañoGarras, velocidad);
        this.NumManada = numManada;
        this.PotenciaRugido = potenciaRugido;
    }

        //Asignadores de atributos de León (setter)

        //Lectores de atributos de León (getter)
    public int getNumManada() {
        return this.NumManada;
    }
        public float getPotenciaRugido() {
            return this.PotenciaRugido;
        }

        //Métodos de León
    @Override
    public String Comer() {
        return "El " + this.getNombreCientífico() + " se alimenta de distintas presas, todas de gran tamaño, " +
                "para alimentar a su manada, de hasta " + this.getNumManada() +
                " miembros. Entre ellas: cebras, ñus, búfalos y hasta jirafas o elefantes." +
                " Pues, sus garras de " + this.getTamañoGarras() + " se lo permiten.";
    }
    @Override
    public String Correr() {
        return "El " + this.getNombreCientífico() + " se puede desplazar hasta " + this.getVelocidad() + " km/h.";
    }
    @Override
    public String Dormir() {
        return "El " + this.getNombreCientífico() + " duerme hasta 18h al día.";
    }
    @Override
    public String Comunicarse() {
        return "El " + this.getNombreCientífico() + " se comunica con rugidos tan fuertes," +
                " que pueden alcanzar los " + this.getPotenciaRugido() + " dB.";
    }
    @Override
    public String resumen() {
        return super.resumen();
    }
}
