package POO_Paquetes.Hogar;

public class Persona {
    private String nombre;
    private String apellido;
    private ColorPelo colorPelo;

        //Asignación de constantes
    public static final String GÉNERO_MASCULINO = "Masculino";
    public static final String GÉNERO_FEMENINO  = "Femenino";

        //Asignación de atributos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
            public void setColorPelo(ColorPelo colorPelo) { this.colorPelo = colorPelo; }

        //Lector de atributos
    public String getNombre() {
        return nombre;
    }
        public String getApellido() {
            return apellido;
        }
            public ColorPelo getColorPelo() { return colorPelo; }

        //Creador de métodos
    public String LanzarPelota(){
        return "¡Lanza la pelota al perro!";
    }
    public static String saludar(){
        return "¡Hola, ¿qué tal?!";
    }
}
