package POO_InterfacesRepositorio.Lecciones.Interfaces.Modelo;

public class Cliente extends BaseEntity{
        //Atributos de Cliente
    private String Nombre;
    private String Apellido;

        //Constructores de Cliente
    public Cliente(String nombre, String apellido) {
        super();
        this.Nombre = nombre;
        this.Apellido = apellido;
    }

        //Asignadores de atributos de Cliente (setter)
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
        public void setApellido(String apellido) {
            this.Apellido = apellido;
        }

        //Lectores de atributos de Cliente (getter)
    public String getNombre() {
        return this.Nombre;
    }
        public String getApellido() {
            return this.Apellido;
        }

        //Métodos de Cliente
    @Override
    public String toString() {
        return "ID :" + this.ID +
                ", nombre: '" + this.Nombre + '\'' +
                ", apellido: '" + this.Apellido + '\'';
    }

}
