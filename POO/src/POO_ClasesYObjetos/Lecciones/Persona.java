package POO_ClasesYObjetos.Lecciones;

public class Persona {
        //Atributos de POO_ClasesYObjetos.Persona
    private String nombre;
    private String apellido;

        //Constructor de persona
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

        //Métodos de persona
    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}
