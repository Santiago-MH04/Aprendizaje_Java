package POO_Interfaces.Imprenta.Modelo;

public class Persona {
        //Atributos de Persona
    private String Nombre;
    private String Apellido;

        //Constructores de Persona
    public Persona() {
    }
    public Persona(String nombre, String apellido) {
        this.Nombre = nombre;
        this.Apellido = apellido;
    }

        //Asignadores de atributos de Persona (setter)
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.Apellido = apellido;
    }

        //Lectores de atributos de Persona (getter)
    public String getNombre() {
        return this.Nombre;
    }
        public String getApellido() {
            return this.Apellido;
        }

        //Métodos de Persona
    @Override
    public String toString() {
        return this.Nombre + " " + this.Apellido;
    }
}
