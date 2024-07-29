package POO_ClasesYObjetos.Actividad;

public class Cliente {
        //Atributos de la clase Cliente
    private String nombre;
    private String apellido;

        //Constructores de la clase Cliente
    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

        //Setters de la clase Cliente
        //Getters de la clase Cliente
    public String getNombre() {
        return nombre;
    }
        public String getApellido() {
            return apellido;
        }

        //Métodos de la clase Cliente
    @Override
    public String toString() {
        return this.nombre + " " + this.apellido;
    }
}
