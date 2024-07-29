package POO_Herencia.Lecciones.Bambalinas;

public class Profesor extends Persona {
        //Atributos de la clase Profesor
    private String Asignatura;

        //Constructores de Profesor
    public Profesor() {
        System.out.println("Profesor: iniciando constructor...");
    }
    public Profesor(String nombre, String apellido) {
        super(nombre, apellido);
    }
    public Profesor(String nombre, String apellido, String asignatura) {
        super(nombre, apellido);
        this.Asignatura = asignatura;
    }

            //Asignadores de atributos (setter)
    public void setAsignatura(String asignatura) {
        this.Asignatura = asignatura;
    }

        //Lectores de atributos (getter)
    public String getAsignatura() {
        return this.Asignatura;
    }

        //Otros métodos de Profesor
    @Override
    public String saludar() {
        return "Buenos días. Mi nombre es " + getNombre() +
                " e imparto la asignatura de " + getAsignatura().toLowerCase();
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nDocente asignatura:" + Asignatura;
    }
}
