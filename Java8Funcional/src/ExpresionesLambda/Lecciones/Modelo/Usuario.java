package ExpresionesLambda.Lecciones.Modelo;

public class Usuario {
        //Atributos de Usuario
    private String Nombre;

        //Constructores de Usuario
    public Usuario() {
    }
    public Usuario(String nombre) {
        this.Nombre = nombre;
    }

        //Asignadores de atributos de Usuario (setter)
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

        //Lectores de atributos de Usuario (getter)
    public String getNombre() {
        return this.Nombre;
    }

    //Métodos de Usuario
}
