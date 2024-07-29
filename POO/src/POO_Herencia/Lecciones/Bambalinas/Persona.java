package POO_Herencia.Lecciones.Bambalinas;

public class Persona {
        //Atributos de Persona
    private String nombre;
    private String apellido;
    private int edad;
    private String correo;

        //Constructores de Persona
    public Persona() {
        System.out.println("Persona: iniciando constructor...");
    }
    public Persona(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public Persona(String nombre, String apellido, int edad) {
        this(nombre, apellido);
        this.edad = edad;
    }

        //Asignadores de atributos (setter)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
            public void setEdad(int edad) {
                this.edad = edad;
            }
                public void setCorreo(String correo) {
                this.correo = correo;
            }

        //Lectores de atributos (getter)
    public String getNombre() {
        return this.nombre;
    }
        public String getApellido() {
            return this.apellido;
        }
            public int getEdad() {
                return this.edad;
            }
                public String getCorreo() {
                    return this.correo;
                }

        //Otros métodos de Persona
    public String saludar(){
        return "Hola, ¿qué tal?";
    }
    @Override
    public String toString() {
        return this.saludar() +
                "\nNombre: " + nombre + '.' +
                "\nApellido: " + apellido + '.' +
                "\nEdad: " + edad + '.' +
                "\nCorreo: " + correo;
    }
}
