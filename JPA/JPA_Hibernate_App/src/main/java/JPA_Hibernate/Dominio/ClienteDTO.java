package JPA_Hibernate.Dominio;

public class ClienteDTO {
        //Atributos de ClienteDTO
    private String nombre;
    private String apellido;

        //Constructores de ClienteDTO
    public ClienteDTO() {}
    public ClienteDTO(String nombre) {
        this();
        this.nombre = nombre;
    }
    public ClienteDTO(String nombre, String apellido) {
        this(nombre);
        this.apellido = apellido;
    }

        //Asignadores de atributos de ClienteDTO (setters)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        //Lectores de atributos de ClienteDTO (getters)
    public String getNombre() {
        return this.nombre;
    }
        public String getApellido() {
            return this.apellido;
        }

        //Métodos de ClienteDTO

    @Override
    public String toString() {
        return "{\n" +
                "nombre: " + this.nombre + ",\n" +
                "apellido: " + this.apellido + ",\n" +
                '}';
    }
}
