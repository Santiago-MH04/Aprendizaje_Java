package POO_ClasesYObjetos.Lecciones;

public class Motor {
        //Atributos de motor
    private double cilindraje;
    private TipoMotor tipo;

        //Constructores de motor
    public Motor() {
    }
    public Motor(double cilindraje, TipoMotor tipo) {
        this.cilindraje = cilindraje;
        this.tipo = tipo;
    }

        //Asignación de atributos de motor
    public void setCilindraje(double cilindraje) {
        this.cilindraje = cilindraje;
    }
    public void setTipo(TipoMotor tipo) {
        this.tipo = tipo;
    }

        //Lector de atributos de motor
    public double getCilindraje() {
        return cilindraje;
    }
    public TipoMotor getTipo() {
        return tipo;
    }
}
