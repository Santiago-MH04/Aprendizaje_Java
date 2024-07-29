package POO_Herencia.Lecciones.Bambalinas;

public class Alumno extends Persona {
        //Atributos de la clase Alumno
    private String institución;
    private double NotaMatemáticas;
    private double NotaLengua;
    private double NotaHistoria;

        //Constructores de Alumno
    public Alumno() {
        System.out.println("Alumno: iniciando constructor...");
    }
    public Alumno(String nombre, String apellido){
        super(nombre, apellido);
    }
    public Alumno(String nombre, String apellido, int edad){
        super(nombre, apellido, edad);
    }
    public Alumno(String nombre, String apellido, int edad, String institución){
        super(nombre, apellido, edad);
        this.institución = institución;
    }
    public Alumno(String nombre, String apellido, int edad, String institución, double notaMatemáticas, double notaLengua, double notaHistoria){
        this(nombre, apellido, edad, institución);
        this.NotaMatemáticas = notaMatemáticas;
        this.NotaLengua = notaLengua;
        this.NotaHistoria = notaHistoria;
    }

        //Asignadores de atributos (setter)
    public void setInstitución(String institución) {
        this.institución = institución;
    }
        public void setNotaMatemáticas(double notaMatemáticas) {
            NotaMatemáticas = notaMatemáticas;
        }
            public void setNotaLengua(double notaLengua) {
                NotaLengua = notaLengua;
            }
                public void setNotaHistoria(double notaHistoria) {
                NotaHistoria = notaHistoria;
            }

        //Lectores de atributos (getter)
    public String getInstitución() {
        return institución;
    }
        public double getNotaMatemáticas() {
            return NotaMatemáticas;
        }
            public double getNotaLengua() {
                return NotaLengua;
            }
                public double getNotaHistoria() {
                    return NotaHistoria;
                }

        //Otros métodos de Alumno
    @Override
    public String saludar() {
        return super.saludar() + " Mi nombre es " + getNombre() +
                " y Soy un estudiante.";
    }
    public double calcularPromedio(){
        System.out.println("Promedio de: " + Alumno.class.getCanonicalName());
        return (NotaMatemáticas + NotaLengua + NotaHistoria)/3;
    }

    @Override
    public String toString() {
        return  super.toString()  +
                "\nInstitución: " + institución + '.' +
                "\nNotaMatemáticas: " + NotaMatemáticas + '.' +
                "\nNotaLengua: " + NotaLengua + '.' +
                "\nNotaHistoria: " + NotaHistoria +
                "\nPromedio: " + this.calcularPromedio();
    }
}
