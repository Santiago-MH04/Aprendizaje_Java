package POO_ClasesAbstractas.Actividad.Clase;

public abstract class Mamífero {
        //Atributos de Mamífero
    protected String NombreCiéntifico;
    protected String Hábitat;
    protected float Altura;
    protected float Longitud;
    protected float Peso;

        //Constructores de Mamífero
    public Mamífero() {
    }
    public Mamífero(String nombreCientífico) {
        NombreCiéntifico = nombreCientífico;
    }
    public Mamífero(String nombreCientífico, String hábitat, float altura, float longitud, float peso) {
        this(nombreCientífico);
        this.Hábitat = hábitat;
        this.Altura = altura;
        this.Longitud = longitud;
        this.Peso = peso;
    }

        //Asignadores de atributos de Mamífero (setter)

        //Lectores de atributos de Mamífero (getter)
    public String getNombreCientífico() {
        return this.NombreCiéntifico;
    }
    public String getHábitat() {
        return this.Hábitat;
    }
    public float getAltura() {
        return this.Altura;
    }
    public float getLongitud() {
        return this.Longitud;
    }
    public float getPeso() {
        return this.Peso;
    }

        //Métodos de Mamífero
    public abstract String Comer();
    public abstract String Correr();
    public abstract String Dormir();
    public abstract String Comunicarse();
    public String resumen(){
        StringBuilder Detalle = new StringBuilder("Detalle " + this.getClass().getSimpleName().toLowerCase() + " (" + this.getNombreCientífico() + ") ")
                .append("\nHábitat: " + this.getHábitat())
                .append("\nAltura: " + this.getAltura() + " m")
                .append("\nLongitud: " + this.getLongitud() + " m")
                .append("\nPeso: " + this.getPeso() + " kg")
                .append("\nAlimentación: " + this.Comer())
                .append("\nDesplazamiento: " + this.Correr())
                .append("\nDescanso: " + this.Dormir())
                .append("\nComunicación: " + this.Comunicarse());
        String Resumen = Detalle.toString();
        return Resumen;
    }
}
