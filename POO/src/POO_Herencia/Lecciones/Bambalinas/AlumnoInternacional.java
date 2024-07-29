package POO_Herencia.Lecciones.Bambalinas;

public class AlumnoInternacional extends Alumno{
        //Atributos de AlumnoInternacional
    private String país;
    private double notaIdiomas;

        //Constructores de AlumnoInternacional
    public AlumnoInternacional() {
        System.out.println("AlumnoInternacional: iniciando constructor... ");
    }
    public AlumnoInternacional(String nombre, String apellido) {
        super(nombre, apellido);
    }
    public AlumnoInternacional(String nombre, String apellido, String país) {
        super(nombre, apellido);
        this.país = país;
    }

        //Asignadores de atributos (setter)
    public void setPaís(String país) {
        this.país = país;
    }
        public void setNotaIdiomas(double notaIdiomas) {
        this.notaIdiomas = notaIdiomas;
    }

        //Lectores de atributos (getter)
    public String getPaís() {
        return país;
    }
        public double getNotaIdiomas() {
        return notaIdiomas;
    }

        //Otros métodos de AlumnoInternacional
    @Override
    public String saludar() {
        return super.saludar() + "\b de intercambio de " + getPaís() + ".";
    }
    @Override
    public double calcularPromedio() {
        System.out.println("Promedio de: " + AlumnoInternacional.class.getCanonicalName());
        return ((super.calcularPromedio())*3 + this.notaIdiomas)/4;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nPaís: " + país + '.' +
                "\nNota idiomas: " + notaIdiomas;
    }
}
